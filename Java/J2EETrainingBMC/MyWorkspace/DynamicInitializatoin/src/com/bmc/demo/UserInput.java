package com.bmc.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("Please enter salary:");
		double salary = Double.parseDouble(br.readLine());
		System.out.println("sal : "+salary);
		*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter salary: ");
		
		if(scanner.hasNextDouble()){
			double salary = scanner.nextDouble();
			System.out.println("sal : "+salary);
		}
		scanner.close();
	}

}
