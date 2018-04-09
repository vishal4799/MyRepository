package com.bmc.helper;
//facilitates connection with database
//Only one instance is required throughout life cycle of application

public class ConnectionManager {
	//not accessible outside ConnectionManager
	//to restrict creation of object outside class
	private ConnectionManager(){}
	
	//static variable retains its value across different call
	//static variable are class level variable
	private static ConnectionManager manager=null;
	//Factory Method
	//if purpose of method is only to create object is called
	//factory method
	public static ConnectionManager createInstance(){
		
		if(manager==null){
			manager=new ConnectionManager();
		}
		
		return manager;
		
	}
	public void openConnection(){
		System.out.println("--logic for opening db connection");
	}
	public void closeConnection(){
		System.out.println("--logic for closing db connection");
	}

}