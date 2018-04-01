package com.bmc.service;

import com.bmc.entities.Accountant;
import com.bmc.entities.Employee;
import com.bmc.entities.Programmer;

//Abstract classes are used to enforce rules-Business Rules
//Abstract class cannot be instantiated
//Abstract can have abstract as well as concrete method

public abstract class AbstractEmployeeService {
	
	//Method which do not have body should be marked abstract
	//if one of method is marked as abstract, class must be marked abstract
	//Business Rule-Each and every employee should have implementation of empCode()
	//i.e every subclass must provide implementation of abstract method
	public abstract String empCode();
	
	//protected double tax=10;
	
	//apart from abstract method, abstract class can have concrete method
	//Method to print empcode()
	
	//Generalized Method
	//Method common to all sub classes
	//Resusability
	public void print(AbstractEmployeeService service){
		System.out.println("Emp Code:"+service.empCode());
		
	}
	
	//Abstract class can have static method

	public static double computeTax(AbstractEmployeeService service,Employee employee){
		
		double tax=0;
		if(service instanceof ProgrammerService){
			//downcasting
			ProgrammerService programmerService=(ProgrammerService)service;
			Programmer programmer=(Programmer)employee;
			tax= programmerService.getSalary(programmer)*0.10;
		}
		if(service instanceof AccountantService){
			//downcasting
			AccountantService accountantService=(AccountantService)service;
			Accountant accountant=(Accountant)employee;
			tax= accountantService.getSalary(accountant)*0.20;
		}
		
		return tax;
		
	}
	

	

}
