package com.bmc.service;

public class Calculator {
	
	public int add(int a,int b){
		return a+b;
	}
	//Method overloading
	public int add(int a,int b,int c){
		return a+b+c;
	}
	//Method overloading
	public float add(float a,float b){
		return a+b;
	}
	
	//Before Java 5
	/*
	public int add(int[] n){
		int sum=0;
		for(int values:n){
			sum+=values;
		}
		return sum;
	}
	*/
	/* Not method overloading
	public float add(int a,int b){
		
	}
*/
	//Java 5 variable length argument list
	//parameter is of type int[]
	//variable length argument should be last in parameter list
	public int add(int ... n){
		
		int sum=0;
		for(int values:n){
			sum+=values;
		}
		return sum;
		
	}
	
}
