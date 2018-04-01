package com.bmc.service;

public class StringFormattingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double price=23.5;
		int quantity=3;
		String item="Blue";
		//The cost of 003 blue shirt is $23.5
		
		System.out.printf("The cost of %03d of %s shirt is $%2.5f\n",quantity,item,price);
		
		System.out.format("The cost of %03d of %s shirt is $%2.5f\n",quantity,item,price);
		
		String formattedString=String.format("The cost of %03d of %s shirt is $%2.5f\n",quantity,item,price);

	}

}
