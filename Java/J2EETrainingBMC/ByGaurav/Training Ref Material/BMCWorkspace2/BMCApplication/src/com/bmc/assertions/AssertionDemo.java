package com.bmc.assertions;

import java.util.Scanner;

public class AssertionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter Salary:");
		int salary=scanner.nextInt();
		assert salary>0:"Salary cannot be negative";
		//provided salary>0
		System.out.println("Tax:"+salary*0.1);
		

	}

}
