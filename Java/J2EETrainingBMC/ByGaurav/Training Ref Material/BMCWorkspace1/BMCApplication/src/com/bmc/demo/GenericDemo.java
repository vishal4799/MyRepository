package com.bmc.demo;

import com.bmc.exceptions.BMCGenericException;

public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str=null;//str value comes from DB
		if(str==null){
			
			throw new BMCGenericException("Str is null",new NullPointerException());
		}
		
       String str1="abc";
       
		if(str1.matches("[0-9]")){
			
			throw new BMCGenericException("String Cannot contain number",new NumberFormatException());
		}
		
	}

}
