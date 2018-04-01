package com.bmc.exceptions;
//instead of creating different exception handling classes for different business scenario
//One class can suffice the need of handling exception
public class BMCGenericException extends RuntimeException {
	
	String message;
	//Throwable is super class of all exceptions
	//wrap object of other exception into BMCGenericException
	
	public BMCGenericException(String message,Throwable t){
		super(message,t);
		
	}
	
}
