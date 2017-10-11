package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {

		try {
			//GET
			// DefaultHttpClient httpClient = new DefaultHttpClient();
			// HttpGet getRequest = new HttpGet(
			// 	"http://clm-pun-022429.bmc.com:9797/olaengine/rest/olaapi/v1.0/license/consumption/collector?start=0&end=1496137828000");
			// //getRequest.addHeader("accept", "application/json");
			// getRequest.addHeader("Authorization","_4ff9193a-31c4-4e1e-b5fe-97485faf67ff");
			// getRequest.addHeader("Content-Type","application/json");
			// getRequest.addHeader("Accept","application/json");
			// //getRequest.addHeader("Accept","application/x-java-serialized-object");
			// HttpResponse response = httpClient.execute(getRequest);
			//POST
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(
					"http://localhost:8080/RESTfulExample/json/product/post");

			StringEntity input = new StringEntity(
					"{\"qty\":100,\"name\":\"iPad 4\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}