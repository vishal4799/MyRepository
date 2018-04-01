package com.bmc.nio;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class PropertiesFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Console console=System.console();
		console.readLine();
		
		InputStream is=new FileInputStream("D:\\IO\\DB.properties");
		
		Properties properties=new Properties();
		properties.load(is);
		
		System.out.println("Driver is:"+properties.getProperty("driver"));
		
		String username=System.getProperty("username");
		System.out.println("Username is:"+username);
		
		Properties runtimeProperties=System.getProperties();
		
		Enumeration e=runtimeProperties.propertyNames();
		while(e.hasMoreElements()){
			
			String propertyName=(String)e.nextElement();
			System.out.println("Property Name:"+propertyName);
			System.out.println("Property Value:"+runtimeProperties.getProperty(propertyName));
		}
		
		

	}

}
