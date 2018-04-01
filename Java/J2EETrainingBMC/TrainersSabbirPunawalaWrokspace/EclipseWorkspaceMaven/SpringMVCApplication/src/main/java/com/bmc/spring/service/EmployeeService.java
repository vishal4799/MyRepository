package com.bmc.spring.service;
import java.util.List;

import com.bmc.spring.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public boolean persistEmployee(Employee employee);
	public List<String> getLocationName();
	public int retrieveEmpId();
	

}
