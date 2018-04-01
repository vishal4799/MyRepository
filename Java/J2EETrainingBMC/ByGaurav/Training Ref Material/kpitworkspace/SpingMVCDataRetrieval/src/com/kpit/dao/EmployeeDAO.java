package com.kpit.dao;

import java.sql.SQLException;
import java.util.List;

import com.kpit.entities.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException,SQLException;
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException,SQLException;
	

}
