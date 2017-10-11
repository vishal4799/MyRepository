package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bmc.ola.types.license.ConsumptionInfo;
import com.bmc.sms.wscommon.client.ClientResponseTO;

public class ApacheHttpClientGet {
	
	public static Map<String, ConsumptionInfo> tenantWiseITDAConsumptionData = new HashMap<String, ConsumptionInfo>();

	public static void main(String[] args) throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
//		ApacheHttpClientGet.print();
		
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
		
	}
	
	static void print() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Emp obj;// = new Org();
		//Object to JSON in file
		obj = mapper.readValue("{\"id\":\"1\",\"i\":\"0\"}", Org.class);
		obj.getId();
		Org org = (Org)obj;
		org.getI();
		System.out.println(obj.toString());
	}

}

class Org extends Emp{
	String i;

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}
	
}

class Emp implements Serializable{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

class ITDAConsumptionService implements Runnable{

	public String tenant;
	public ITDAConsumptionService(String tenant){
		this.tenant = tenant;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
				"http://clm-pun-022429.bmc.com:9797/olaengine/rest/olaapi/v1.0/license/consumption/collector?start=0&end=1496137828000");
			//getRequest.addHeader("accept", "application/json");
			getRequest.addHeader("Authorization","_4ff9193a-31c4-4e1e-b5fe-97485faf67ff");
			getRequest.addHeader("Content-Type","application/json");
			getRequest.addHeader("Accept","application/json");
			//getRequest.addHeader("Accept","application/x-java-serialized-object");
			HttpResponse response = httpClient.execute(getRequest);

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
			
			ClientResponseTO ci = new ConsumptionInfo();
			ObjectMapper mapper = new ObjectMapper();
			//Object obj = new Object();
			//Object to JSON in file
			ci = mapper.readValue("{"+output2.substring(43), ClientResponseTO.class);
			httpClient.getConnectionManager().shutdown();
			//addConsumptionData(ci);
		  } catch (ClientProtocolException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void addConsumptionData(ConsumptionInfo ci){
		ApacheHttpClientGet.tenantWiseITDAConsumptionData.put(this.tenant, ci);
	}
	
}