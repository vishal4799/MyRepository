package com.bmc.dao;

import com.bmc.entities.Employee;

//Rules for performing CRUD operations for domain class-Employee
//C-create,R-Retrieve,U-Update,D-Delete
//Design to interface not to implementation

public interface EmployeeDAO {
	//by default method is abstract and public
	Employee findEmployeeById(int empId);
	boolean persistEmployee(Employee employee);
	boolean updateEmployeeSalaryById(int empId,double newSalary);
	boolean removeEmployee(int empId);

}
