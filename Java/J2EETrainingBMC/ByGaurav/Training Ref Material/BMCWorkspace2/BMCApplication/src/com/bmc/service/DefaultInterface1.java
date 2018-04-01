package com.bmc.service;
@FunctionalInterface
public interface DefaultInterface1 {
	
	//abstract method
	void abstractMethod();
	
	public default void  defaultMethod(){
		System.out.println("--This is default Method--interface1 ");
		
	}

}
