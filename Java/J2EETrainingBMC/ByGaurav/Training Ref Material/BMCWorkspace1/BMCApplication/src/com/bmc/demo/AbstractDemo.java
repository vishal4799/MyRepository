package com.bmc.demo;

import com.bmc.helper.FactoryAbstractEmployeeService;
import com.bmc.helper.UtilityAbstractEmployeeService;
import com.bmc.service.AbstractEmployeeService;
import com.bmc.service.AccountantService;
import com.bmc.service.ProgrammerService;

public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//it gets revealed to client which class provides implementation
		
		AbstractEmployeeService service=null;
		service=new ProgrammerService();
		service.empCode();
		
		service=new AccountantService();
		service.empCode();
		//Hide implementation details
		
		AbstractEmployeeService service1=FactoryAbstractEmployeeService.createAbstractEmployeeService('a');
		System.out.println(service1.empCode());
		//through subclass we call method of superclass
		service1.print(service1);
		
		//Logical
	
		UtilityAbstractEmployeeService.InternalServices.print(service1);

	}

}
