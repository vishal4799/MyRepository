package com.bmc.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestEmployeeById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please enter emp id:");
		
		int empId=scanner.nextInt();
				
		
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		try {
			Employee employee=employeeDAO.getEmployee(empId);
			System.out.println(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
