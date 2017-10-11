import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

	  try {

		//URL url = new URL("http://in-vmakwana-w2.adprod.bmc.com:8443/tspsstub");
		URL url = new URL("http://clm-pun-022429.bmc.com:9797//olaengine/rest/olaapi/v1.0/license/consumption/collector?start=0&end=1496137828000");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "_19baf547-b873-40a4-8ace-616f125fadbe");
		conn.setRequestProperty("Accept", "application/json");
		//conn.setRequestProperty("Accept", "application/x-java-serialized-object");
		conn.setRequestProperty("Content-Type", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}

}