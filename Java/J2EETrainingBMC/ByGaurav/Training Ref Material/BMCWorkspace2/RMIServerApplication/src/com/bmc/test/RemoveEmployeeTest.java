package com.bmc.test;

import java.sql.SQLException;

import com.bmc.dao.EmployeeDAO;
import com.bmc.helper.FactoryEmployeeDAO;

public class RemoveEmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		boolean result=false;
		try {
			result=employeeDAO.removeEmployee(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee Deleted:"+result);

	}

}
