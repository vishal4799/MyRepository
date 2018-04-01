package com.bmc.service;

import com.bmc.entities.Accountant;

public class AccountantService extends AbstractEmployeeService {

	public double getSalary(Accountant accountant){
		return accountant.getEmpSalary();
	}
	
	
	@Override
	public String empCode() {
		// TODO Auto-generated method stub
		return "AC"+9011;
	}
	

}
