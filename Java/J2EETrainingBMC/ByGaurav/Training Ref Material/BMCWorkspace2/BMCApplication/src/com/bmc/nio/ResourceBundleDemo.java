package com.bmc.nio;

import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle resourceBundle=ResourceBundle.getBundle("DBInfo");
		String driver=resourceBundle.getString("driver");
		System.out.println("Driver is:"+driver);
		// Class.forName(driver);

	}

}
