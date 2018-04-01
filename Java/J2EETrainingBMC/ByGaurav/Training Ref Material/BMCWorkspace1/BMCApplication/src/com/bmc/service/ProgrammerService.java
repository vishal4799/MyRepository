package com.bmc.service;

import com.bmc.entities.Programmer;

//if subclass extends abstract class
//each any every abstract method implementation must be provided
//if subclass choose not provide implemenation of abstract method
//must be declared abstract
public class ProgrammerService extends AbstractEmployeeService {
	
	//salary will come from db	
	

	public double getSalary(Programmer programmer) {
		return programmer.getEmpSalary();
	}



	@Override
	public String empCode() {
		// TODO Auto-generated method stub
		//some logic to generate primary key number
		//protected member can be accessed by all subclasses
		//tax=30;//refers to tax of super class
		
		return "SE"+1001;
	}

}
