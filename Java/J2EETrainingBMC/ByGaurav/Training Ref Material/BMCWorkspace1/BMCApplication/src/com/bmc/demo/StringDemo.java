package com.bmc.demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Entry made in String Pool
		String str1="Hello";
		//Hello already exist in String Pool i.e only one entry
		String str2="Hello";
		if(str1==str2){
			//Both reference variable point to same memory location
			//in String Pool
			System.out.println("str1==str2");
		}
		
		//Not Recommended
		//Hello will be stored in Object Pool
		
		String strObj1=new String("Hello");
		String strObj2=new String("Hello");
		
		if(strObj1==strObj2){
			//Reference variable in handler pool are pointing to different
			//memory location
			System.out.println("strObj1==strObj2");
		}
      
		//to check if content of object is same
		if(strObj1.equals(strObj2)){
			System.out.println("strObj1 content same as strObj2");
		}
		
		
		String data="Hello I am java Programmer";
		char dataArray[]=new char[data.length()];//length() size of string
		data.getChars(0, data.length(), dataArray, 0);
		for(char ch:dataArray){
			System.out.println(ch);
		}
		
		System.out.println(data.substring(0, 5));
		//String is immutable
		String input=" sabbir ";
		System.out.println("Before trimming:"+input.length());
		String output =input.trim();//removes leading as well trailing whitespaces
		System.out.println("After trimming:"+output.length());
		
		String colors="Orange,White,Green";
		String color[]=colors.split(",");
		for(String clr:color){
			System.out.println(clr);
		}
		String newString=colors.replace("White", "Blue");
		System.out.println(newString);
		
	}

}
