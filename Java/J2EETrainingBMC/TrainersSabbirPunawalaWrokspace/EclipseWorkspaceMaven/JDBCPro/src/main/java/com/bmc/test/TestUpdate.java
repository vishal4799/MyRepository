package com.bmc.test;

import java.sql.SQLException;

import com.bmc.dao.EmployeeDAO;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		try {
			employeeDAO.updateEmployeeSalaryById(1001, 75000);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
