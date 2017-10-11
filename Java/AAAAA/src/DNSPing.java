import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSPing {

	public static void main(String[] args) throws UnknownHostException, IOException {
	    String ipAddress = "127.0.0.1";
	    InetAddress inet = InetAddress.getByName(ipAddress);

	    System.out.println("Sending Ping Request to " + ipAddress);
	    System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

	    ipAddress = "10.155.154.147";
	    ipAddress = "in-mohskhan-w1";
	    ipAddress = "in-mohskhan-w1";
	    inet = InetAddress.getByName(ipAddress);

	    System.out.println("Sending Ping Request to " + ipAddress);
	    System.out.println(inet.isReachable(50000) ? "Host is reachable" : "Host is NOT reachable");
	}
}
