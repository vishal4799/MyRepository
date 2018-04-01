package com.bmc.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url=new URL("http://www.bmc.com/index.html");
		System.out.println("Protocol:"+url.getProtocol());
		System.out.println("Host:"+url.getHost());
		System.out.println("Path:"+url.getPath());
		
		URLConnection urlConnection=url.openConnection();
		InputStream is=urlConnection.getInputStream();
		int k=0;
		while((k=is.read())!=-1){
			
			System.out.print((char)k);
			
		}
		
		

	}

}
