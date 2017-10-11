package com.bmc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestAllEmployee {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		try {
			System.out.println("<==== get all emps =====>");
			//System.out.println(employeeDAO.getAllEmployees());
			List<Employee> employees = employeeDAO.getAllEmployees();
			employees.forEach(e -> System.out.println(e));
			System.out.println("\n<==== get emp by id =====>");
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter empid: ");
			int id = scanner.nextInt();
			System.out.println("Employee2:"+employeeDAO.getEmployee(id).toString());
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
