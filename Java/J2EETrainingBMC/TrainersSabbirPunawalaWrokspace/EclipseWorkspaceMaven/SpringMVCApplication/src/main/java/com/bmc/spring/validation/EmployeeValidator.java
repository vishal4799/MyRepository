package com.bmc.spring.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bmc.spring.entities.Employee;

@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(Employee.class);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
		Employee e=(Employee)arg0;
		

		if(e.getEmpSalary()<0){
			
			arg1.rejectValue("empSalary", "error.employee.empSalary");
			//arg1.rejectValue("empSalary", "no error code", "Salary cannot be negative");

		}
		List<String> listDesignation=new ArrayList<String>();
		listDesignation.add("GET");
		listDesignation.add("SE");
		listDesignation.add("SSE");
		
		if(!listDesignation.contains(e.getEmpDesignation())){
			arg1.rejectValue("empDesignation", "error.employee.empDesignation");
			//arg1.rejectValue("empDesignation", "no error code", "Invalid designation");
			
		}
		
		
		
	}

}
