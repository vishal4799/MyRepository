package com.bmc.helper;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.JDBCEmployeeDAOImpl;

public class FactoryEmployeeDAO {
	
	public static EmployeeDAO createEmployeeDAO(){
		
		EmployeeDAO employeeDAO=new JDBCEmployeeDAOImpl();
		return employeeDAO;
		
	}

}
