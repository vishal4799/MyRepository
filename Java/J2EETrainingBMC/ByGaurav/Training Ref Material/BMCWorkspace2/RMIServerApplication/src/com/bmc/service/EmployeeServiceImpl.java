package com.bmc.service;

import java.sql.SQLException;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		Employee employee=new Employee();
		try {
			employee=employeeDAO.findEmployeeById(empId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee ;
	}

}
