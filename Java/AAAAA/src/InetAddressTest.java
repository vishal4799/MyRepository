import org.apache.commons.lang3.StringUtils;

public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String ipAddress = "clm-pun-022429.bmc.com";
		String canonicalHostName = "clm-pun-022429";
        if(!StringUtils.isBlank(canonicalHostName) && !ipAddress.startsWith(canonicalHostName)){
        	ipAddress = canonicalHostName;
    	}
        // get hostname using lookup.
        System.out.println(ipAddress);
	}

}
