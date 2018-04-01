package com.bmc.demo;

import com.bmc.entities.Square;

public class ToStringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Square square=new Square(10);
		System.out.println(square);//implictly toString() called
		

	}

}
