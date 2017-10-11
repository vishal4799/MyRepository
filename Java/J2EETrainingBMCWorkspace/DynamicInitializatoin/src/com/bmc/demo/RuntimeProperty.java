package com.bmc.demo;

public class RuntimeProperty {

	public static void main(String[] args) {
		System.out.println("rmiserverip:"+System.getProperty("rmiserverip"));
		System.out.println("port:"+System.getProperty("port"));
		System.out.println("JNDI Name:"+System.getProperty("jndi"));
	}
}
