package com.bmc.demo;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.JdbcEmployeeDAOImpl;
import com.bmc.helper.FactoryEmployeeDAO;

public class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//client of dao layer
		//incorrect implementation
		//Implementation details are revealed
		JdbcEmployeeDAOImpl impl=new JdbcEmployeeDAOImpl();
		impl.findEmployeeById(101);
		//Internal method of dao layer also gets exposed
		impl.internalToDAOLayer();
		
		//correct implementation
		//Hides implementation details from client program
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		employeeDAO.findEmployeeById(101);
		
		//employeeDAO.internalToDAOLayer();//not exposed
		
		

	}

}
