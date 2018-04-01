package com.bmc.helper;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.MemoryEmployeeDAOImpl;

public class FactoryEmployeeDAO {

	
	public static EmployeeDAO createEmployeeDAO(){
		
		//Reference variable of class can be implictly casted
		//to reference variable of interface, provided class
		//implements that interface
		EmployeeDAO employeeDAO=new MemoryEmployeeDAOImpl();
		return employeeDAO;
		
	}
}
