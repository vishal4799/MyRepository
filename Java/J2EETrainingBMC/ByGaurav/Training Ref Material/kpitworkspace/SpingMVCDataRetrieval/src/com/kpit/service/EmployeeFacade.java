package com.kpit.service;

import java.util.List;

import com.kpit.entities.Employee;

public interface EmployeeFacade {
	
	public List<Employee> getAllEmployees();
	public boolean persistEmployee(Employee employee);
	

}
