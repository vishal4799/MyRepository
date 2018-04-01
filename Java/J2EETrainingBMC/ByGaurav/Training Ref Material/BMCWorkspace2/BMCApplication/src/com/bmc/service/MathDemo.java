package com.bmc.service;
import static java.lang.Math.*;

public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prior Java 5
		
		double d=Math.cos(10)*Math.sin(30)/Math.tan(30);
		
		//Java 5
		//No need for specifying reference of class to invoke
		//static members of class
		double d1=PI*sin(20)/cos(20);

	}

}
