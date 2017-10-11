package com.bmc.ola.notification;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bmc.ola.bwagent.schedule.TaskThreadPoolExecutor;
import com.bmc.ola.bwagent.schedule.TaskThreadPoolExecutor.Config;
import com.bmc.ola.communication.configuration.ComponentConfigurationAdapter;
import com.bmc.ola.configmanager.ConfigManager;
import com.bmc.ola.jobs.quartz.BaywatchJobBase;
import com.bmc.ola.jobs.quartz.BaywatchJobExecutionContext;
import com.bmc.ola.metadataserver.exceptions.MetadataServerException;
import com.bmc.ola.metrics.client.MetricsMonitor;
import com.bmc.ola.notification.executor.SearchExecutionTask;
import com.bmc.ola.query.SearchJobAction;
import com.bmc.ola.types.Configuration;
import com.bmc.ola.types.FacetHelper;
import com.bmc.ola.types.INotificationActions;
import com.bmc.ola.types.INotificationConditions;
import com.bmc.ola.types.Notification;
import com.bmc.ola.types.NotificationAction;
import com.bmc.ola.types.NotificationAlert;
import com.bmc.ola.types.NotificationAlertResultGrid;
import com.bmc.ola.types.Query;
import com.bmc.ola.types.ResultFacet;
import com.bmc.ola.types.Results;
import com.bmc.ola.types.TotalCompareCondition;
import com.bmc.ola.types.exceptions.BayWatchDataValidationException;
import com.bmc.ola.types.exceptions.BaywatchJobException;
import com.bmc.ola.utils.Constants;
import com.bmc.ola.utils.Utils;

public class NotificationJob extends BaywatchJobBase {

	private static final Logger logger = LoggerFactory
			.getLogger(NotificationJob.class);
	private static final int CONDITION_INDEX = 0;
	private static final String CONDITION_NOT_SATISFIED = "CONDITION NOT SATISFIED";
	final String ACTION_SEPARATOR = ", ";
	
	private TaskThreadPoolExecutor searchExecutor;
	
	private static final String NOTIFICATION_SEARCH_EXECUTION = "notification.search.execution";
	
	NotificationUtils notificationUtils = NotificationManager.getInstance()
			.getNotificationUtils();
	
	public NotificationJob() {
		Configuration defaultConfiguration = new Configuration();
		defaultConfiguration.setPropertyValue(Config.CORE_POOL_SIZE.getQualifiedPropertyName(NOTIFICATION_SEARCH_EXECUTION), 5);
    	defaultConfiguration.setPropertyValue(Config.MAX_POOL_SIZE.getQualifiedPropertyName(NOTIFICATION_SEARCH_EXECUTION), 15);
    	defaultConfiguration.setPropertyValue(Config.WAIT_QUEUE_SIZE.getQualifiedPropertyName(NOTIFICATION_SEARCH_EXECUTION), 7);
    	
    	searchExecutor = new TaskThreadPoolExecutor(
    			NOTIFICATION_SEARCH_EXECUTION,new ComponentConfigurationAdapter(),defaultConfiguration);
	}

	@Override
	public void executeInternal(BaywatchJobExecutionContext jobContext)
			throws BaywatchJobException {

	try{		
			logger.debug("job_id = {}, Notification action  triggered",
					jobContext.getJobId());
			Map<String, Object> data = jobContext.getJobDataMap();
			String notificationId = (String) data.get("SCHEDULE_NOTIFICATION_OBJ");
			boolean scheduled = (Boolean) data.get("scheduled");
	
			Notification notify = notificationUtils.getNotification(notificationId);
			String componentName = ConfigManager.getInstance().getComponent() != null ? ConfigManager
					.getInstance().getComponent().getName()
					: "";
			MetricsMonitor logMonitor = new MetricsMonitor(
					MetricsMonitor.FIELD_MANAGEMENT_ENGINE, componentName);
			logMonitor.start();
	
			StringJoiner notificationActions = new StringJoiner(",");
			String STATUS ="";
	
			List<INotificationConditions> conditions = notify
					.getNotificationConditions();
			
			CountDownLatch conditionLatch = new CountDownLatch(conditions.size());
			List<SubmittedJob> submittedJobs = new ArrayList<SubmittedJob>(conditions.size());
			
			for (INotificationConditions iNotificationConditions : conditions) {
				TotalCompareCondition tcc = (TotalCompareCondition) iNotificationConditions;
				try {
					Query query = prepareSearchQuery(jobContext.getJobId(), notify,tcc.getSavedQueryObject().getQueryString());
					notificationUtils.setUserDetailsinQuery(query, notify.getUserId());
	
					Future<Results> future = searchExecutor.submit(new SearchExecutionTask(query,conditionLatch));
					
					submittedJobs.add(new  SubmittedJob(tcc.getId(),tcc,future,query));
					
				} catch (BayWatchDataValidationException e) {
	                STATUS = "FAILED : " + e.getMessage();
	                logger.error(e.getLocalizedMessage(), e);
				}catch(MetadataServerException e){
	                STATUS = "FAILED : " + e.getMessage();
	                logger.error(e.getLocalizedMessage(), e);
				}
			}// end of for loop
			
			boolean isAllDone=false;
			try {
				isAllDone = conditionLatch.await(60, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				logger.error("Interruped stop all jobs", e);
				 for (SubmittedJob job : submittedJobs) {
		                job.getFutureResults().cancel(true);
		            }
			}
			// Shutdown 
			searchExecutor.destroy();
			
			List<EvaluationJob> evaluationJobs= new ArrayList<EvaluationJob>(submittedJobs.size());
	
			for (SubmittedJob submittedJob : submittedJobs) {
				try {
	                // before doing a get you may check if it is done
	                if (!isAllDone && !submittedJob.getFutureResults().isDone()) {
	                    // cancel job and continue with others
	                	submittedJob.getFutureResults().cancel(true);
	                    continue;
	                }
	                Results results = submittedJob.getFutureResults().get();
	                EvaluationJob e = new EvaluationJob(submittedJob.getSequenceId(), submittedJob.getTotalCompareCondition(), results,submittedJob.getQuery());
					evaluationJobs.add(e);
	            } catch (ExecutionException  cause) {
	            	logger.error("Execution while executing search Queries", cause);
	                STATUS = "FAILED : " + cause.getMessage();
	            }catch(InterruptedException cause){
	                logger.error("Execution while executing search Queries", cause);
	                STATUS = "FAILED : " + cause.getMessage();  
	            }
			}
			
			String operation = "-";
			if(evaluationJobs.size()>1){
				for (EvaluationJob evaluationJob : evaluationJobs) {
					TotalCompareCondition tcc = evaluationJob.getTotalCompareCondition();
					if(tcc.getOperation()!=null && !tcc.getOperation().equals("-")){
						operation = tcc.getOperation();
						break;
					}
				}			
			}
			boolean triggerActions = collateResult(evaluationJobs,operation);
			
			// Get Notification for Alert/Report for very first condition
			TotalCompareCondition tcc = null;
			Query query=null;
			int numresults = 0;
			for (EvaluationJob evaluationJob : evaluationJobs) {
				// In Edit conditions were deleted and only single condition left with sequence Id other than 1  
				if(evaluationJobs.size()==1 || (evaluationJob.getSequenceId()==1 && evaluationJob.getTotalCompareCondition().getId()==1)) {				
					tcc= evaluationJob.getTotalCompareCondition();
					query= evaluationJob.getQuery();
					numresults= (int) evaluationJob.getResults().getTotalRecords();
					break;
				}
			}
			
			if (triggerActions
					|| com.bmc.ola.enums.NotificationType.REPORT.equals(notify
							.getNotificationType())) {
				List<INotificationActions> actions = notify.getNotificationActions();
				for (INotificationActions action : actions) {
					if (action instanceof NotificationAction) {
						notificationActions.add(((NotificationAction) action).getActionName());
						try{
						    sendEventActionExecute(evaluationJobs, notify, (NotificationAction) action,operation);
						    STATUS =STATUS + ((NotificationAction) action).getActionName()+"- TRIGGERED ##";//# used as separator
						}catch(BaywatchJobException cause){
			                STATUS =STATUS + ((NotificationAction) action).getActionName()+"- FAILED : " + cause.getMessage()+"##";
			                logger.error("Exception while ActionExecute", cause);
						}
					}
				}
			} else {
				logger.debug("job_id = {}, Notification action not triggered",
						jobContext.getJobId());
			}
			
			if(!triggerActions && com.bmc.ola.enums.NotificationType.ALERT.equals(notify
					.getNotificationType())){
				STATUS = CONDITION_NOT_SATISFIED;
			}
			if (triggerActions
				|| com.bmc.ola.enums.NotificationType.REPORT.equals(notify
						.getNotificationType()) || com.bmc.ola.enums.NotificationType.ALERT.equals(notify
								.getNotificationType())  || !scheduled) {
	
				// Create NotificationAlert
				logger.debug(
					"job_id = {}, Create notification alert for notification Id : {}",
					jobContext.getJobId(), notificationId);
				NotificationAlert alert = new NotificationAlert();
				alert.setExecutedTimestamp(new Date());
				alert.setNotificationDesc(notify.getNotificationDesc());
				alert.setNotificationName(notify.getNotificationName());
				alert.setQuery(query.getQuery());
				alert.setStatus(STATUS);
				alert.setResultcount((int) numresults);
				alert.setNotificationActions(notificationActions.toString());
				alert.setNotificationId(notificationId);
				alert.setOperation(operation);
				saveNotificationAlert(alert,notify,evaluationJobs);
			}
			// Every time a notification is executed the ExecutedTimestamp should be
			// updated
			if (scheduled) {
				notify.setExecutedTimestamp(query.getEndTime());
			}
			notificationUtils.updateNotification(notify);
			logMonitor.addMetric(MetricsMonitor.FIELD_SOURCE,
				notify.getNotificationName());
			logMonitor.addMetric(MetricsMonitor.SAVED_QUERY, query.getQuery());
			logMonitor.addMetric(MetricsMonitor.SAVED_QUERY_NAME, tcc.getSavedQueryObject().getQueryName());
			logMonitor.addMetric(MetricsMonitor.FIELD_EVETNS, numresults);
			logMonitor.stop();
		}
		catch(Throwable thr){
			logger.debug("Throwing since unknown exception", thr);
		}
	}
	
	/**
	 * @param resultForEvaluation
	 */
	private boolean collateResult(List<EvaluationJob> lstEvaluationJob, String operation) {
		boolean triggerAction=false;
		
		for (EvaluationJob evaluationJob : lstEvaluationJob) {
			// Make triggerFalse for each condition
			triggerAction=false;
			TotalCompareCondition tcc = evaluationJob.getTotalCompareCondition();
			Results results = evaluationJob.getResults();
			int limit = tcc.getLimit();
			long numresults= results.getTotalRecords();
			if (tcc.getOperator().toString().equals("EQ")) {
				if (numresults == limit) {
					triggerAction = true;
				}
			} else if (tcc.getOperator().toString().equals("LT")) {
				if (numresults < limit) {
					triggerAction = true;
				}
			} else if (tcc.getOperator().toString().equals("GT")) {
				if (numresults > limit) {
					triggerAction = true;
				}
			}
			// eevaluateCondition is false for ANDing + evaluationCondition is True for ORring - Break loop and execute 
			if(operation!=null && (operation.equals("AND") && !triggerAction) || (operation.equals("OR") && triggerAction)){
				break;
			}
		}
		return triggerAction;
	}

	/**
	 * Prepare search query from notification object.
	 * 
	 * @param notify
	 *            notification object
	 * @param queryString 
	 * @return Query object
	 */
	protected Query prepareSearchQuery(String jobId, Notification notify, String queryString) {

		Query query = new Query();
		query.setHighlighter(false);
		query.setQuery(queryString);

		/*
		 * we allow till minute level scheduling thus, erase seconds and
		 * milliseconds from current timestamp
		 */
		Calendar cal = GregorianCalendar.getInstance(Locale.ENGLISH);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		long endtime = cal.getTimeInMillis();
		int executionOffset = 0;

		if (isLastExecutionToCurrentExecutionType(notify)) {
			// reduce one millisecond from timestamp as that will be considered
			// in the next run.
			endtime--;

			executionOffset = ConfigManager
					.getInstance()
					.getIntComponentConfiguration(
							Constants.NOTIFICATION_SEARCH_EXEC_OFFSET_SEC,
							Constants.DEFAULT_NOTIFICATION_SEARCH_EXEC_OFFSET_SEC);
		} else {
			executionOffset = ConfigManager
					.getInstance()
					.getIntComponentConfiguration(
							Constants.NOTIFICATION_SEARCH_RELATIVE_EXEC_OFFSET_SEC,
							Constants.DEFAULT_NOTIFICATION_SEARCH_RELATIVE_EXEC_OFFSET_SEC);
		}

		// Need to revisit this number.
		query.setScrollSize(Constants.NUMBER_OF_RESULTS_IN_PDF);

		// offset search endtime by given configuration
		if (executionOffset > 0) {
			endtime = endtime - (executionOffset * 1000);
		}

		long starttime = notify.getExecutedTimestamp();

		if (!isFirstTimeAfterActivation(notify)) {
			starttime = starttime + 1;
		}

		if (notify.getNotificationDuration() != -1) {
			starttime = endtime
					- (notify.getNotificationDuration() * 60 * 1000);
		}

		/*
		 * If due to offset, endtime becomes smaller than starttime, then, use
		 * starttime as end time.
		 */
		if (starttime > endtime) {
			logger.debug(
					"job_id = {}, Setting search starttime as the search endtime.",
					jobId);
			endtime = starttime;
		}

		query.setStartTime(getQueryStartTime(notify, jobId, executionOffset,
				starttime, endtime, cal.getTimeInMillis()));
		query.setEndTime(endtime);
		Set<String> termFacets = new HashSet<String>();
		boolean useFacets = false;
		boolean attachLogs = false;
		for (INotificationActions action : notify.getNotificationActions()) {
			if (action instanceof NotificationAction) {
				Map<String, Object> configs = ((NotificationAction) action)
						.getConfiguration();
				useFacets |= Constants.NOTIFICATION_ATTACH_REPORT
						.equals(configs
								.get(Constants.NOTIFICATION_ATTACH_REPORT));
				attachLogs |= Constants.NOTIFICATION_ATTACH_LOGS.equals(configs
						.get(Constants.NOTIFICATION_ATTACH_LOGS));
				String termFacet = (String) configs
						.get(Constants.NOTIFICATION_FACETS);
				if (termFacet != null) {
					termFacets.add(termFacet);
				}
			}
		}
		if (termFacets.size() == 0) {
			termFacets.add(Constants.PROP_HOST);
		}
		query.setTermFacets(termFacets);
		boolean fetchHOSTFacets=isHostMacroUsedInTemplate(notify);

		/* Ideally, compare condition should be > 0, however coming as > 1000 
		 * for reports, thus, handling here
		 */
		if(!com.bmc.ola.enums.NotificationType.REPORT.equals(notify
		        .getNotificationType())) {
		    if (useFacets || fetchHOSTFacets) {
		        query.setFacetFetchCriteria((TotalCompareCondition) notify
		                .getNotificationConditions().get(CONDITION_INDEX));
		    }
		}

		query.setOnlyFacetFlag(useFacets || fetchHOSTFacets);
		query.setOnlySearchResultsFlag(useFacets && attachLogs);
		query.setHistogramFlag(true);
		
        if (notify.isIncludeRecordsFromBPPM() == false) {
            query.setQuery(Utils.addFilterToQuery("((CLASS <> \"ITDA_Event\"))", queryString));
        }

		// START the search
		query.setSearchJobAction(SearchJobAction.START);
		return query;
	}
	
	
    
    
	
	private long getQueryStartTime(Notification notify, String jobId,
			long executionOffset, long startTime, long endTime, long currentRun) {

		long start = startTime;

		if (isLastExecutionToCurrentExecutionType(notify)
				&& !isFirstTimeAfterActivation(notify)) {

			int threshold = ConfigManager
					.getInstance()
					.getIntComponentConfiguration(
							Constants.NOTIFICATION_LASTEXECUTION_RESET_THRESHOLD,
							Constants.DEFAULT_NOTIFICATION_LASTEXECUTION_RESET_THRESHOLD);

			if (threshold > 0) {

				try {

					CronExpression cronExpression = new CronExpression(
							notify.getCronExpr());

					long nextExpectedFireTime = cronExpression
							.getNextValidTimeAfter(
									new Date(notify.getExecutedTimestamp() + 1
											+ (executionOffset * 1000)))
							.getTime();

					if (currentRun != nextExpectedFireTime) {

						long misfireCount = 0;
						while (currentRun > nextExpectedFireTime) {
							misfireCount++;

							if (misfireCount > threshold) {
								break;
							}
							nextExpectedFireTime = cronExpression
									.getNextValidTimeAfter(
											new Date(nextExpectedFireTime))
									.getTime();
						}

						if (misfireCount > threshold) {

							/*
							 * First trigger after misfire don't follow the cron
							 * schedule, so, set start time to end time.
							 */
							start = endTime;
							logger.info(
									"job_id = {}, Last execution to current execution threshold limit reached. Reset start time from {} to {}",
									jobId, startTime, start);
						}
					}
				} catch (Exception e) {
					logger.error(
							"An error occurred while detecting misfire triggers to change search context.",
							e);
				}
			}
		}

		return start;
	}

	private boolean isLastExecutionToCurrentExecutionType(Notification notify) {
		return notify.getNotificationDuration() == -1;
	}

	private boolean isFirstTimeAfterActivation(Notification notify) {
		return notify.getCreatedTime() == notify.getExecutedTimestamp();
	}

	protected void sendEventActionExecute(List<EvaluationJob> evaluationJobs, Notification notify,NotificationAction notificationAction,String operation) throws BaywatchJobException {

		Map<String, Object> configs = new HashMap<String, Object>();
		configs.putAll(notificationAction.getConfiguration());

		MacroUtils mutils=new MacroUtils(evaluationJobs);
		configs.put("name", notify.getNotificationName());
		configs.putAll(mutils.getConfigurationMapFromEvaluatedresults());
		configs.put("operation", operation);
		
		// Populate host values from Search Query results
		populateHost(evaluationJobs,configs);
		
		// Do not show conditions for report type of Notification
		if (com.bmc.ola.enums.NotificationType.REPORT.equals(notify
				.getNotificationType())) {
			configs.put("conditionOperator", "-");
		}
		Object fieldsForMacroReplacementObject = configs.get("FieldsForMacroReplacement");
		
		// instance and null check
		if (fieldsForMacroReplacementObject instanceof String) {
			String[] fieldNames = ((String) fieldsForMacroReplacementObject)
					.split(",");
			for (String fieldName : fieldNames) {
				String fieald = replaceMacros(
						(String) configs.get(fieldName.trim()), configs);
				configs.put(fieldName.trim(), fieald);
			}
		}

		
		NotificationUtils notificationUtils = NotificationManager.getInstance()
				.getNotificationUtils();
		try {
			notificationUtils.sendEvent(configs);
			
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
			throw new BaywatchJobException(e.getMessage(), e) ;
		}
	}
	
	
	public void populateHost(List<EvaluationJob> evaluationJobs,Map<String, Object> configs){
		String hostFacetvalue=null;
		String tempHostvalue=null;
		for (EvaluationJob evaluationJob : evaluationJobs) {
			tempHostvalue=populateHost(evaluationJob.getResults());
			if(hostFacetvalue==null){
				hostFacetvalue=tempHostvalue;
			}else{
				if(!hostFacetvalue.equalsIgnoreCase(Constants.MULTIPLE_HOSTS)){
					if(!hostFacetvalue.equalsIgnoreCase(tempHostvalue)){
						hostFacetvalue=Constants.MULTIPLE_HOSTS;
					}
				}
			}
		}
		configs.put(Constants.HOST,hostFacetvalue);
	}
	
	private String populateHost(Results res) {
		String hostName=null;
	    List<ResultFacet> facets = res.getFacets();
	    List<String> hostNames = new ArrayList<String>();
	    for (ResultFacet facet : facets) {
	        if (facet.getName()!=null && facet.getName().equals(Constants.HOST)) {
	            for (FacetHelper facetHelper : facet.getList()) {
	                // to handle no results found scenario where we add dummy
	                // facet
	                if (facetHelper.getDisplayName() != null) {
	                    hostNames.add(facetHelper.getDisplayName());
	                }
	            }
	            break;
	        }
	    }
	    
	    if (hostNames.size() == 1) {
	    	hostName= hostNames.get(0);
	    } else if (hostNames.size() > 1) {
	    	hostName= Constants.MULTIPLE_HOSTS;
	    }else if(hostNames.isEmpty()){
	    	hostName= "";
	    }
	    return hostName;
	}	

	private String replaceMacros(String message, Map<String, Object> configs) {
		
		message=replaceinKeys(message, configs,Constants.notificationMacroArray);
		message=replaceinKeys(message, configs,(String[])
				((Set)configs.get("additionalMacroKeys")).toArray(new String[((Set)configs.get("additionalMacroKeys")).size()]));
		return message;
	}
	
	protected String populateNotificationResultTable(String macro,String message, Map<String, Object> configs) {
		if(message.contains("${" + macro.toUpperCase() + "}")){
			String queryNames =  configs.get("queryName")!=null?configs.get("queryName").toString():null;
			String[] arrQueryNames = queryNames!=null?queryNames.split(","):null;
			
			if(arrQueryNames!=null ) {
				StringBuilder sbNotificationTable = new StringBuilder("<table border='1'><tr><th>Saved Search</th><th>Condition</th><th>Result Count</th><th>URL</th></tr>");
				for (int i = 0; i < arrQueryNames.length; i++) {
					String queryName= configs.get("queryName["+i+"]")!=null?configs.get("queryName["+i+"]").toString():"";
					String limit= configs.get("limit["+i+"]")!=null?configs.get("limit["+i+"]").toString():"";
					String operator="";
					String operatorSign="";
					boolean  isReportType= configs.get("conditionOperator")!=null && configs.get("conditionOperator").toString().equals("-");
					if(isReportType) {
						operatorSign= "-";
						limit="";
					} else {
						operator= configs.get("conditionOperator["+i+"]")!=null?configs.get("conditionOperator["+i+"]").toString():"";
						if  (operator.equals("EQ")) {
		    				operatorSign = "=";
		    			} else if  (operator.equals("GT")) {
		    				operatorSign = "&gt;";
		    			} else if  (operator.equals("LT")) {
		    				operatorSign = "&lt;";
		    			}
					}		
					String count= configs.get("count["+i+"]")!=null?configs.get("count["+i+"]").toString():"";
					String url= configs.get("URL["+i+"]")!=null?configs.get("URL["+i+"]").toString():"";
					sbNotificationTable.append("<tr>");
					sbNotificationTable.append("<td>").append(queryName).append("</td>");
					sbNotificationTable.append("<td>").append(operatorSign).append(limit).append("</td>");
					sbNotificationTable.append("<td>").append(count).append("</td>");
					sbNotificationTable.append("<td>").append(url).append("</td>");
					sbNotificationTable.append("</tr>");
				}
				sbNotificationTable.append("</table>");
				String replaceMent = String.valueOf(sbNotificationTable);
				if(replaceMent != null && replaceMent.length() != 0){
					message = message.replace("${" + macro.toUpperCase() + "}", replaceMent);
				}
			}
		} 
		return message;
	}
		
	private String replaceinKeys(String message,Map<String,Object> configs, String keys[]){
		List<String> dateField = Arrays.asList(new String[]{"startTime","endTime"});
		for (String macro :keys ) {
			macro = macro.trim();
			if(dateField.contains(macro) || (-1!=macro.indexOf("startTime")) || (-1!=macro.indexOf("endTime"))) {
				String dateFormat = NotificationManager.getInstance()
						.getNotificationUtils().getDateFormat();
				String timeZone = NotificationManager.getInstance()
						.getNotificationUtils().getTimeZone();
				Long time = (Long)configs.get(macro);
				if(time!= null && time != 0)
					message = message.replace("${" + macro.toUpperCase() + "}", convertLongToString(time, dateFormat, timeZone));
			} else {
				
				if( configs.get(macro) instanceof Integer){
					String replaceMent = String.valueOf(configs.get(macro));
					if(replaceMent != null && replaceMent.length() != 0){
						message = message.replace("${" + macro.toUpperCase() + "}", replaceMent);
					}
				}else if(configs.get(macro) instanceof Results){
				
				}
			    else{	
					String replaceMent = (String) configs.get(macro);
					if(replaceMent != null && replaceMent.length() != 0){
						message = message.replace("${" + macro.toUpperCase() + "}", replaceMent);
					}
				}	
			}
			if(macro.equals("resultTable")){
				message = populateNotificationResultTable(macro,message,configs);
			}
			if(macro.equals("host")){
				String replaceMent = (String) configs.get(Constants.HOST);
				message = message.replace("${" + macro.toUpperCase() + "}", replaceMent);
			}
		}
		return message;
	}

	private String convertLongToString(long time, String format, String timeZone) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(time);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		return formatter.format(calender.getTime());
	}

	public boolean isHostMacroUsedInTemplate(Notification notify){
		boolean isHostMacroUsed=false;
		if(notify.getNotificationActions()!=null && !notify.getNotificationActions().isEmpty()){
			List<INotificationActions> actions = notify
					.getNotificationActions();
			for (INotificationActions action : actions) {
				if (action instanceof NotificationAction) {
					
					//always fetch host for bppm notification
					if(null!=((NotificationAction) action).getConfiguration().get("fetchHost") &&
							true==Boolean.parseBoolean(((NotificationAction) action).getConfiguration().get("fetchHost").toString())){
						       return true;
					}
					
					if(null!=((NotificationAction) action).getConfiguration().get("FieldsForMacroReplacement")){
						String[] fieldNames = ((String)((NotificationAction) action).getConfiguration().get("FieldsForMacroReplacement")).split(",");
						for(String fieldName : fieldNames) {	
							if(-1!=((NotificationAction)action).getConfiguration().get(fieldName.trim()).toString().indexOf("${"+Constants.HOST+"}")){
								return true;
							}
						}
					}
				}
			}
		}
		return isHostMacroUsed;
	}
	
protected void saveNotificationAlert(NotificationAlert alert, Notification notify, List<EvaluationJob> evaluationJobs){
		
		// create notification Condition Grid
		List<NotificationAlertResultGrid> arrNotificationResults= new ArrayList<NotificationAlertResultGrid>(evaluationJobs.size());
		for (EvaluationJob evaluationJob : evaluationJobs) {
			NotificationAlertResultGrid notificationAlertResultGrid = new NotificationAlertResultGrid();
			notificationAlertResultGrid.setSequenceId(evaluationJob.getSequenceId());
			String queryName = "";
			String userName = "";
			if(evaluationJob.getTotalCompareCondition().getSavedQueryObject()!=null){
				queryName = evaluationJob.getTotalCompareCondition().getSavedQueryObject().getQueryName();
				String userId = evaluationJob.getTotalCompareCondition().getSavedQueryObject().getUserId();
				if(Utils.containsIgnoreCase(evaluationJob.getTotalCompareCondition().getSavedQueryObject().getFullName(),"[")){
					notificationAlertResultGrid.setQueryName(evaluationJob.getTotalCompareCondition().getSavedQueryObject().getFullName());
				}else{
					userName = notificationUtils.getUserName(userId);
					notificationAlertResultGrid.setQueryName(queryName+" ["+userName+"]");
				}
			}else{
				queryName = evaluationJob.getTotalCompareCondition().getName();
				notificationAlertResultGrid.setQueryName(queryName);
			}
			notificationAlertResultGrid.setQueryString(evaluationJob.getQuery().getQuery());
			notificationAlertResultGrid.setResult(String.valueOf(evaluationJob.getResults().getTotalRecords()));
			if (com.bmc.ola.enums.NotificationType.ALERT.equals(notify
					.getNotificationType())) {
				notificationAlertResultGrid.setCondition(evaluationJob.getTotalCompareCondition().getOperator().name()+"_"+evaluationJob.getTotalCompareCondition().getLimit());	
			}else{
				notificationAlertResultGrid.setCondition("-");
			}
			arrNotificationResults.add(notificationAlertResultGrid);
		}
		String resultGridAsJSON=null;
		try {
			resultGridAsJSON = new ObjectMapper().writeValueAsString(arrNotificationResults);
		} catch (JsonGenerationException e) {
			logger.error("Error in generating JSON for saving NotificationAlert for  id {}",notify.getNotificationId());
		} catch (JsonMappingException e) {
			logger.error("Error in mapping JSON for saving NotificationAlert for  id {}",notify.getNotificationId() );	
		} catch (IOException e) {
			logger.error("Error in IO for saving NotificationAlert for  id {}",notify.getNotificationId() );
		}
		alert.setResultGridAsJSON(resultGridAsJSON);
		alert.setNotificationId(notify.getNotificationId());
		notificationUtils.addAlert(alert);
	}
}
