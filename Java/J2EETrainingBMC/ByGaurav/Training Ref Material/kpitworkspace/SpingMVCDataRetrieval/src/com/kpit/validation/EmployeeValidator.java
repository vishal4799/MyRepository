package com.kpit.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kpit.entities.Employee;
@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(Employee.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
		Employee employee=(Employee)arg0;
		
		if(employee.getEmpSalary()<5000){
			
			arg1.rejectValue("empSalary", "error.employee.empSalary");
		}
		
		List<String> designations=new ArrayList<>();
		designations.add("SE");
		designations.add("SSE");
		
		if(!designations.contains(employee.getEmpDesignation())){
			arg1.rejectValue("empDesignation", "error.employee.empDesignation");

		}
		
	}
	
	

}
