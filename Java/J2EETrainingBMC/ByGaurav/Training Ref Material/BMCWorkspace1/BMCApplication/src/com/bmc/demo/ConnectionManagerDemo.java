package com.bmc.demo;

import com.bmc.helper.ConnectionManager;

public class ConnectionManagerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static method can be called by giving ref of class
		ConnectionManager manager=ConnectionManager.createInstance();
		manager.openConnection();
		manager.closeConnection();

	}

}
