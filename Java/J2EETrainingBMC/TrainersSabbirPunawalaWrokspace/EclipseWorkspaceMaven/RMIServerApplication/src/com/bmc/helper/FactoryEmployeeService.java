package com.bmc.helper;

import com.bmc.service.EmployeeService;
import com.bmc.service.EmployeeServiceImpl;

public class FactoryEmployeeService {
	
	public static EmployeeService createEmployeeService(){
		
		EmployeeService service=new EmployeeServiceImpl();
		return service;
	}

}
