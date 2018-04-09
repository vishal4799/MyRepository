package com.bmc.test;

import java.sql.SQLException;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		Employee employee=new Employee();
		employee.setEmpId(1008);
		employee.setEmpName("Rakesh");
		employee.setEmpSalary(56000);
		employee.setEmpDesignation("Trainer");
		try {
			employeeDAO.persistEmployee(employee);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}