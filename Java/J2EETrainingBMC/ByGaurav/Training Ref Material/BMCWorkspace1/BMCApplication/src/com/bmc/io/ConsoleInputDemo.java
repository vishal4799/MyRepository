package com.bmc.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bmc.entities.Employee;

public class ConsoleInputDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Converts binary data to character data
		//Bridge class between InputStream and Reader
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(ir);
		System.out.print("Emp Id:");
		//conversion required
		int empId=Integer.parseInt(buffer.readLine());
		
		System.out.print("Emp Name:");
		String empName=buffer.readLine();
		
		System.out.print("Emp Salary:");
		double empSalary=Double.parseDouble(buffer.readLine());
		

		System.out.print("Emp Designation:");
		String empDesignation=buffer.readLine();
		
		Employee e=new Employee();
		e.setEmpId(empId);
		e.setEmpName(empName);
		e.setEmpSalary(empSalary);
		e.setEmpDesignation(empDesignation);
		System.out.println(e);

	}

}
