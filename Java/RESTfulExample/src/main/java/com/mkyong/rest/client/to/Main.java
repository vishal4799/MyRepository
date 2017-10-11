package com.mkyong.rest.client.to;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonString = "{\"statusCode\":\"200\",\"statusMessage\":\"Ok\",\"total_collectors\":8,\"total_messages\":170906,\"collector_consumption\":[{\"collector_name\":\"arhttpchange\",\"messagess\":7140},{\"collector_name\":\"bppm\",\"messagess\":116084},{\"collector_name\":\"apa_upload\",\"messagess\":24},{\"collector_name\":\"arhttpincident\",\"messagess\":1920},{\"collector_name\":\"uploadfilecol\",\"messagess\":12},{\"collector_name\":\"apa_archange\",\"messagess\":2104},{\"collector_name\":\"apa_arincidnet\",\"messagess\":1184},{\"collector_name\":\"apa_bppm\",\"messagess\":42438}]}";
		formatToObject(jsonString, ItdaConsumptionResponseTO.class);
	}
	public static ItdaConsumptionResponseTO formatToObject( String jsonString, Class<ItdaConsumptionResponseTO> expectedJavaClass )
	    {
	        if (jsonString != null)
	        {
	    		ObjectMapper jsonObjectMapper = new ObjectMapper();

	    		ItdaConsumptionResponseTO data = null;
	    		try {

//	    			if(LOGGER.isDebugEnabled()) {
//	    				LOGGER.debug("Input JSON : "+jsonString);
//	    			}

	    			data = jsonObjectMapper.readValue(jsonString, expectedJavaClass);
	    			return data;
	    		} catch (IOException e) {
	    			System.out.println("");
	    		} finally {
//	    			if(LOGGER.isTraceEnabled()) {
//	    				LOGGER.trace("getValidatabaleTO() end.");
//	    			}
	    		}
	        }
			return null;
	    }
}
