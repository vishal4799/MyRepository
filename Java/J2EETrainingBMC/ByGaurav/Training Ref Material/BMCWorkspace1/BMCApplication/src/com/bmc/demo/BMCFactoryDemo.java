package com.bmc.demo;

import com.bmc.entities.Employee;
import com.bmc.helper.BMCFactory;
import com.bmc.service.EmployeeService;

public class BMCFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Upcasting- object of subclass can be implictly casted(converted)
		//into object of super class
		//Downcasting-Object of superclass has to be explictly casted
		//(converted) into object of subclass
		EmployeeService service=(EmployeeService)BMCFactory.createInstance("com.bmc.service.EmployeeService");
		
		Employee employee=(Employee)BMCFactory.createInstance("com.bmc.entities.Employee");
		employee.setEmpId(101);//ID and other values will come from db
		employee.setEmpName("Sabbir");
		employee.setEmpSalary(4500F);
		employee.setEmpDesignation("Trainer");
		
		System.out.println("Tax on salary is:"+service.computeTax(employee));
		
	}

}
