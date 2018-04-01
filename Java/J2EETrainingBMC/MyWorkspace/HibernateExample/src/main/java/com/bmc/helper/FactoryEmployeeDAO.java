package com.bmc.helper;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.EmployeeDAOImpl;

public class FactoryEmployeeDAO {
	public static EmployeeDAO createEmployeeDAO(){
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO;
	}
}
