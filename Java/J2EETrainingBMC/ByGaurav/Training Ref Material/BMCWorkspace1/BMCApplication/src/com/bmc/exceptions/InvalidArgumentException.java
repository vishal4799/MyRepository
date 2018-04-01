package com.bmc.exceptions;

public class InvalidArgumentException extends BMCException{
	
	String message;
	
	public InvalidArgumentException(String message){
		super(message);
	}

}
