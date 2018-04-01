package com.bmc.demo;

public class WrapperClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Before JSE 5.0
		//Boxing
		int i=20;
		Integer o=new Integer(i);
		//o++;//not allowed, Java do not support Operator Overloading
		//UnBoxing
		int j=o.intValue();
		j++;//Arithmetic operator can work with primitive types
		
		//JSE 5.0
		//AutoBoxing
		int k=23;
		Integer intObj=k;//Automatically primitive value will be
		//wrapped into reference type
		intObj++;
		//AutoUnboxing
		k=intObj;//Automatically primitive value can be unwrapped from
		//reference type
		
		String str="10";//10 is in double quotes-String literal
		//parse string into int
		//parseInt() is static method in Integer
		int strInt=Integer.parseInt(str);
		strInt++;
		//if str instead of having number has character
		//throws NumberFormatException
		
		int number=1001;
		String strNumber=String.valueOf(number);//converts number to String
		

	}

}
