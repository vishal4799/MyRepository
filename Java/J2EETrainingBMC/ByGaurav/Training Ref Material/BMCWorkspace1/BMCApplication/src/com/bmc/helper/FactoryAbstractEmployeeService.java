package com.bmc.helper;

import com.bmc.exceptions.BMCException;
import com.bmc.service.AbstractEmployeeService;
import com.bmc.service.AccountantService;
import com.bmc.service.ProgrammerService;

public class FactoryAbstractEmployeeService {
	
	public static AbstractEmployeeService createAbstractEmployeeService(char type){
		AbstractEmployeeService service=null;
		if(type=='p'){
		service=new ProgrammerService();
		}else if(type=='a'){
			service=new AccountantService();
		}
		else{
			try{
			throw new BMCException("No service matching type specified");
			}catch(BMCException e){
				//log details in log file.
			}
		}
		return service;
	}

}
