package com.bmc.dao;
//Declaration of CRUD operation for Domain Class-Employee

import java.sql.SQLException;
import java.util.List;

import com.bmc.entities.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException;
	public Employee getEmployee(int id) throws ClassNotFoundException, SQLException;
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	public boolean updateEmployeeSalaryById(int id, int newSalary) throws ClassNotFoundException, SQLException;
	public boolean deleteEmployee(int id) throws ClassNotFoundException, SQLException;
	public int computeTax(int id) throws ClassNotFoundException, SQLException;
}