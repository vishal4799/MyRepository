package com.bmc.demo;

import com.bmc.service.Calculator;

public class MethodOverloadingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator=new Calculator();
		calculator.add(10,20);//method with two parameters of type int
		calculator.add(10,20,30);//method with three parameters
		
		calculator.add(10,20,30,40,50,60);//variable length argument list

	}

}
