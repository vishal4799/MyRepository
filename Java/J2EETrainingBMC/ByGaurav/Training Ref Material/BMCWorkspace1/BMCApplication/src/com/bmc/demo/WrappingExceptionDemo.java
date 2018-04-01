package com.bmc.demo;

import com.bmc.exceptions.BMCGenericException;
import com.bmc.helper.BMCFactory;

public class WrappingExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
		BMCFactory.createInstance("bmc.xyz.MyClass");
}catch(BMCGenericException e){
	
	System.out.println("Cause of exception:"+e.getCause());
}
		
	}

}
