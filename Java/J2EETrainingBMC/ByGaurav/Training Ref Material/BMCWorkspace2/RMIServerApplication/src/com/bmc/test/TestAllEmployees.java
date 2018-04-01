package com.bmc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		List<Employee> empList=new ArrayList<Employee>();
				try {
					empList=employeeDAO.getAllEmployees();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Employee employee:empList){
					System.out.println(employee);
				}


	}

}
