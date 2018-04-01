package com.bmc.demo;

import java.util.ResourceBundle;

public class ResourceBundleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Utitlity class ResourceBundle is used to read
		//properties file
		//based on key we can retrieve value
		ResourceBundle bundle=ResourceBundle.getBundle("serverinfo");
		String serverip=bundle.getString("serverip");
		String port=bundle.getString("port");
		System.out.println("serverip:"+serverip);
		System.out.println("port:"+port);
		
	}

}
