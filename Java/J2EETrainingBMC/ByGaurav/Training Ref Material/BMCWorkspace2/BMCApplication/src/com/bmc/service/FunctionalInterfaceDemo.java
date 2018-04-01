package com.bmc.service;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator cAdd=(double a,double b)->a+b;
		System.out.println("Add:"+cAdd.compute(10, 20));
		Calculator cSub=(double a,double b)->a-b;
		System.out.println("Sub:"+cSub.compute(10, 20));
		Calculator cDiv=(double a,double b)->a/b;
		System.out.println("Div:"+cDiv.compute(30,10));
		

	}

}
