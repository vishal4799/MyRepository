package com.kpit.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.dao.EmployeeDAO;
import com.kpit.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeFacade {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empList=null;
		try {
			empList=employeeDAO.getAllEmployees();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public boolean persistEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			result=employeeDAO.persistEmployee(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
