package com.bmc.helper;

import com.bmc.entities.Accountant;
import com.bmc.entities.Programmer;
import com.bmc.service.AbstractEmployeeService;
import com.bmc.service.AccountantService;
import com.bmc.service.ProgrammerService;

public abstract class UtilityAbstractEmployeeService extends AbstractEmployeeService {

	
	//Inner Class
	public static class InternalServices{
		
		
		public static void  print(AbstractEmployeeService service){
			
			if(service instanceof ProgrammerService){
				//downcasting
				ProgrammerService programmerService=(ProgrammerService)service;
				service.print(programmerService);
			}
			if(service instanceof AccountantService){
				//downcasting
				AccountantService accountantService=(AccountantService)service;
				service.print(accountantService);

			}	
		
	}
	
		
		
		
		
	}

	
	
}
