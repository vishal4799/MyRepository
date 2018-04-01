package com.bmc.test;

public class Calculator {
	
	public double add(double a,double b){
		if(a>999 || b>999){
			throw new RuntimeException("Out of Range");
		}
		return a+b;
	}

}
