package com.bmc.demo;

import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("DBConnection");//no need of extn and also path as it's already in classpath
		System.out.println("Driver: "+bundle.getString("driver"));
	}

}
