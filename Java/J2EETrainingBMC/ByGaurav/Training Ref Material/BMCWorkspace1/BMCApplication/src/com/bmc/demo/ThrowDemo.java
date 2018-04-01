package com.bmc.demo;

public class ThrowDemo {

	/**
	 * @param args
	
	*/
	
	public void processString(String param){
		
		
		if(param.matches("@")){
			//Exception explicitly thrown
			//Since it is runtime exception(unchecked), compiler will not put check
		throw new RuntimeException("String contains special characters");	
			
		}
		//if string contains special characters , no point in executing below statement
		System.out.println("Upper Case:"+param.toUpperCase());
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThrowDemo obj=new ThrowDemo();
		obj.processString("@");
		
	}

}
