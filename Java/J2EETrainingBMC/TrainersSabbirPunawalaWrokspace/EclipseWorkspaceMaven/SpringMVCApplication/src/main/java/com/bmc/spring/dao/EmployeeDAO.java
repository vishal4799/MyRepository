package com.bmc.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.bmc.spring.entities.Employee;
public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException,SQLException;
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException,SQLException;
	public List<String> getLocationNames() throws ClassNotFoundException,SQLException;
	
	public int generateEmpId() throws ClassNotFoundException,SQLException;

}
