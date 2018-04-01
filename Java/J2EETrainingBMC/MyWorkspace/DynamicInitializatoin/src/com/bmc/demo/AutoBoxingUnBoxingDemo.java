package com.bmc.demo;

public class AutoBoxingUnBoxingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//before 5
		
		int i=10;
		
		Integer o=new Integer(i);//Boxing
		
		i=o.intValue();//unboxing
		
		
		//Java 5
		
		Integer o1=i;//Autoboxing
		
		i=o1;//AutoUnboxing
		
		

	}

}
