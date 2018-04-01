package com.bmc.demo;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//During runtime following properties will be passed
		//One property will have name-value pair
		//Based on name , we can fetch value
		//serverip=192.168.0.1
		//port=8080
		//To specify runtime property with interpreter Java
		//use option -D
		
		//retrieve property serverip
		String ip=System.getProperty("serverip");
		String port=System.getProperty("port");
		//utitlizing information, connection with server will be
		//established
		System.out.println("ip:"+ip);
		System.out.println("port:"+port);

	}

}
