package com.bmc.truesight.rest.consumption.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import com.bmc.truesight.rest.consumption.to.ItdaConsumptionResponseTO;



public class ItdaConsumptionService implements Runnable{

	public static Map<String, ItdaConsumptionResponseTO> tenantWiseITDAConsumptionData = new HashMap<String, ItdaConsumptionResponseTO>();
	
	public String tenant;
	HttpGet request;
	public ItdaConsumptionService(String tenant){
		this.tenant = tenant;
		
		request = new HttpGet(createURI(protocol, host, port, start, end));
			//getRequest.addHeader("accept", "application/json");
			request.addHeader("Authorization","_a057cf8f-0843-49e4-8bd1-a83a9aab5cb7");
			request.addHeader("Content-Type","application/json");
			request.addHeader("Accept","application/json");
			//getRequest.addHeader("Accept","application/x-java-serialized-object");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(request);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));

			String output,output2="";
			System.out.println("Output from Server for thread...."+this.tenant+" \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				output2 = output;
				Thread.sleep(1000);
			}
			
			ItdaConsumptionResponseTO ci = new ItdaConsumptionResponseTO();
			ObjectMapper mapper = new ObjectMapper();
			ci = mapper.readValue("{"+output2.substring(43), ItdaConsumptionResponseTO.class);
			httpClient.getConnectionManager().shutdown();
			addConsumptionData(ci);
		  } catch (ClientProtocolException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void addConsumptionData(ItdaConsumptionResponseTO ci){
		ItdaConsumptionService.tenantWiseITDAConsumptionData.put(this.tenant, ci);
	}
	public String createURI(String protocol, String host, String port, long start, long end){
		return protocol+"://"+host+":"+port+"/olaengine/rest/olaapi/v1.0/license/consumption/collector?start="+start+"&end="+end;
	}
	
}

@Override
public Object getItdaConsumption2 (
		Object bodyObject , 
        String authorization     
)throws RESTInvocationException{ 

    LOGGER.info("getItdaConsumption started");
    Object response=null;
    String tenantName;
    long startTime, endTime;
	try{
		ItdaConsumptionValidationService service = new ItdaConsumptionValidationService();
		ItdaConsumptionRequestTO request = service.populateBodyObject(bodyObject);
		ConsumptionDataServiceImpl dataService = new ConsumptionDataServiceImpl();
		tenantName = request.getTenantName();
		startTime = request.getStartTime(); 
		endTime = request.getEndTime();
		LinkedHashMap<String, LinkedHashSet<String>> tenantWiseItda = dataService.getRegisterITDAServerList(tenantName, startTime, endTime);
		
    	String[] args = {};
		Thread[] threads = new Thread[args.length];
		for (int i = 0; i < args.length; i++) {
			System.out.println("Consumption data collection started for Tenant:"+args[i]);
			threads[i] = new Thread(new ITDAConsumptionService(args[i]),"ThreadForTenant:"+args[i]);
			threads[i].start();
		}
		// Wait for all of the threads to finish.
		for (Thread thread : threads){
			thread.join();
		}
		System.out.println("Final Result:\n"+tenantWiseITDAConsumptionData);    
			
	}catch(RESTInvocationException restInvocationException){
        LOGGER.error("Invocation exception while processing request",restInvocationException);
        throw restInvocationException;
    }catch(ValidationException validationException){
    	LOGGER.error("getEventConsumption:ValidationException exception while processing request",validationException);
    	ClientResponseTO resp = new ClientResponseTO();
        resp.setStatusCode(validationException.getErrorCode());
        resp.setStatusMsg(validationException.getMessage());
        resp.setResponseTimeStamp(System.currentTimeMillis());
        throw new RESTInvocationException(Integer.parseInt(Util.getStatus(validationException.getErrorCode())),
        		resp);
    }catch(Exception exception){
        LOGGER.error("General exception while processing request",exception);
        throw new RESTInvocationException(500,"Internal Server Error");
    }
    LOGGER.info("getEventConsumption finished");
    return response;
}
