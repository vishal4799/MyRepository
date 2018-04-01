package com.bmc.dao;

import java.sql.SQLException;
import java.util.List;

import com.bmc.entities.Employee;

public interface EmployeeDAO {
	
	public Employee findEmployeeById(int empId) throws ClassNotFoundException,SQLException;
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException,SQLException;
	public boolean updateEmployeeSalaryById(int empId,double newSalary) throws ClassNotFoundException,SQLException;
	public boolean removeEmployee(int empId) throws ClassNotFoundException,SQLException;
	public List<Employee> getAllEmployees() throws ClassNotFoundException,SQLException;
 
}
