package com.bmc.demo;

import java.io.EOFException;
import java.io.IOException;

public class SubClass  extends SuperClass{
	
	//1.subclass can choose not to include throws
	//2.subclass choose to include throws
	//exception has to be same or subclass of exception handling class
	//exception cannot be supertype of exception handling class
	//mentioned in superclass method
	@Override
	public void x()throws EOFException{
		
	}

}
