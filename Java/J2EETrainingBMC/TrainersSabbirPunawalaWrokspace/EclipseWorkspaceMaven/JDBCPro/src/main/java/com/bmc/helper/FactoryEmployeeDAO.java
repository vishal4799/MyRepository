package com.bmc.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.HibernateEmployeeDAOImpl;
import com.bmc.dao.JDBCEmployeeDAOImpl;
import com.bmc.dao.SpringJDBCEmployeeDAOImpl;

public class FactoryEmployeeDAO {
	
	
	
	public static EmployeeDAO createEmployeeDAO(){
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO employeeDAO=(EmployeeDAO)ioc.getBean("springJDBCEmployeeDAOImpl");
		return employeeDAO;
		
	}

}
