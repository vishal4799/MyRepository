package com.bmc.demo;

import java.util.Arrays;

public class CommandLineDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Enhanced for-loop -Java 5
		for(String arg:args){
			System.out.println(arg);
		}
		
		//primitive type array
		
		int intArray[];
		
		//initialization
		 intArray=new int[4];
		 intArray[0]=1;
		 intArray[1]=2;
		 intArray[2]=3;
		 intArray[3]=4;
		 
		 for(int n:intArray){
			 System.out.println(n);
		 }
		 
		 int intArray1[]={10,20,30,40};
		 
		 int intArray2[]=new int[]{11,22,33,44};
		 
		 int multiArray[][]=new int[3][3];
		 
		 Arrays.sort(intArray2);
		 
		 
		 
		
		
	}

}
