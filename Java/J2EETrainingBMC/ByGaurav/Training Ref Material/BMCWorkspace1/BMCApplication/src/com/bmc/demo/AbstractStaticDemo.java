package com.bmc.demo;

import com.bmc.entities.Employee;
import com.bmc.entities.Programmer;
import com.bmc.service.AbstractEmployeeService;
import com.bmc.service.ProgrammerService;

public class AbstractStaticDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Programmer will be populated by data coming 
		//from database table-Programmer
		Employee employee=new Programmer();
		employee.setEmpId(101);
		employee.setEmpSalary(34000);
		AbstractEmployeeService  service=new ProgrammerService();
		System.out.println("Tax is:"+AbstractEmployeeService.computeTax(service, employee));

	}

}