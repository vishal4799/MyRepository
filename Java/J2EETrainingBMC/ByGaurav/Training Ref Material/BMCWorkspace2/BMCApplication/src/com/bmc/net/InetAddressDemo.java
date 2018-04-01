package com.bmc.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		InetAddress address=InetAddress.getLocalHost();
		System.out.println("Host Name:"+address.getHostName());
		System.out.println("IP Address:"+address.getHostAddress());
		System.out.println("Loop back address:"+address.getLoopbackAddress());
		
		

	}

}
