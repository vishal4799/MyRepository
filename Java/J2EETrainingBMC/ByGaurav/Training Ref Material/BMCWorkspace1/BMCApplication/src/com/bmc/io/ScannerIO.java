package com.bmc.io;

import java.util.Scanner;

public class ScannerIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("ID:");
		while(scanner.hasNextLine()){
		
		if(scanner.hasNextInt()){
			
			System.out.println("Id you entered:"+scanner.nextInt());
		}
		   
        if(scanner.hasNext()){
        	System.out.println("Cannot be string");
        }
           
       if(scanner.hasNextDouble()){
			
			System.out.println("Salary you entered:"+scanner.nextDouble());
		}
       System.out.print("Salary:");
	}
	}
}
