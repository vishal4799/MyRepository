package com.bmc.truesight.wscommon.itda.to;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.codehaus.jackson.map.ObjectMapper;

import com.bmc.truesight.wscommon.tsws.ValidationException;
import com.bmc.truesight.wscommon.util.Messages;

public class Main extends Observable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonString = "{\"statusCode\":\"200\",\"statusMessage\":\"Ok\",\"total_collectors\":8,\"total_messages\":170906,\"collector_consumption\":[{\"collector_name\":\"arhttpchange\",\"messagess\":7140},{\"collector_name\":\"bppm\",\"messagess\":116084},{\"collector_name\":\"apa_upload\",\"messagess\":24},{\"collector_name\":\"arhttpincident\",\"messagess\":1920},{\"collector_name\":\"uploadfilecol\",\"messagess\":12},{\"collector_name\":\"apa_archange\",\"messagess\":2104},{\"collector_name\":\"apa_arincidnet\",\"messagess\":1184},{\"collector_name\":\"apa_bppm\",\"messagess\":42438}]}";
	}
	public ItdaConsumptionResponseTO formatToObject( String jsonString, Class<ItdaConsumptionResponseTO> expectedJavaClass )
	        throws IllegalArgumentException
	    {
	        if (jsonString != null)
	        {	notifyObservers();
	        	addObserver(null);
	    		ObjectMapper jsonObjectMapper = new ObjectMapper();

	    		ItdaConsumptionResponseTO data = null;
	    		try {

//	    			if(LOGGER.isDebugEnabled()) {
//	    				LOGGER.debug("Input JSON : "+jsonString);
//	    			}

	    			data = jsonObjectMapper.readValue(jsonString, expectedJavaClass);
	    			return data;
	    		} catch (IOException e) {
//	    			LOGGER.error("Exception while parsing input JSON. Input Object(Map): "+ " Converted JSON: "+ jsonString, e);
	    			throw new ValidationException(Messages.MSG_INCORRECT_INPUT_FORMAT_ERROR,e,new String[]{"Input JSON"});
	    		} finally {
//	    			if(LOGGER.isTraceEnabled()) {
//	    				LOGGER.trace("getValidatabaleTO() end.");
//	    			}
	    		}
	        }
	        throw new IllegalArgumentException("Formatting of Null JSON String is not supported");
	    }
}
class Student implements Observer 
{
    @Override
    public void update(Observable o, Object arg) 
    {
        System.out.println("Message board changed: " + arg);
    }
}