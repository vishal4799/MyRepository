package com.bmc.demo;

import java.util.Scanner;

public class ScannerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String data="2.5,7.9,11.2,4.5";
		//Utitlity class introduced in Java 5
		//parses data into actual primitive type
		Scanner scanner=new Scanner(data);
		scanner.useDelimiter(",");
		float sum=0.0f;
		while(scanner.hasNextFloat()){
			
			float value=scanner.nextFloat();
			sum+=value;
			
			
		}

		System.out.println("Sum is:"+sum);
		
		String data1="Rakesh:34000,Kumar:78000";
		Scanner scanner1=new Scanner(data1);
		scanner1.useDelimiter(",");
		while(scanner1.hasNext()){
			
			String employeeData=scanner1.next();
			Scanner scannerData=new Scanner(employeeData);
			scannerData.useDelimiter(":");
			if(scannerData.hasNext()){
				System.out.println("Name:"+scannerData.next());
			}
			if(scannerData.hasNextInt()){
				System.out.println("Salary:"+scannerData.nextInt());
			}
			
		}
		
		
		
	}

}
