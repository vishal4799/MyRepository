package com.bmc.service;

import com.bmc.entities.Employee;

//business logic for Domain class Employee

public class EmployeeService {
	//computes tax on employee salary
	public double computeTax(Employee employee){
		return employee.getEmpSalary()*0.10;//0.10 will come from DB
		
	}

}
