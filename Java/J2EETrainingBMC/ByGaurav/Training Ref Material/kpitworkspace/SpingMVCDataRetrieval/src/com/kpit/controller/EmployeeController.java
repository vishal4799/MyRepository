package com.kpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kpit.entities.Employee;
import com.kpit.service.EmployeeFacade;
import com.kpit.validation.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeFacade facade;
	@Autowired
	private EmployeeValidator validator;
	
	@RequestMapping(value="getEmployee.htm",method=RequestMethod.GET)
	public ModelAndView getEmployee(){
		
		List<Employee> empList=facade.getAllEmployees();
		ModelAndView mv=new ModelAndView();
		mv.addObject("empList",empList);
		mv.setViewName("emp");
		return mv;
		
	}

	@RequestMapping(value="register.htm",method=RequestMethod.GET)
	public String loadForm(){
		
		return "form";
	}
	
	@ModelAttribute("employee")
	public Employee defaultEmployee(){
		
		Employee employee=new Employee();
		employee.setEmpId(0);
		employee.setEmpName("Type full name");
		employee.setEmpSalary(0.0);
		employee.setEmpDesignation("SE,SSE");
		return employee;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("message",e.getMessage());
		mv.setViewName("error");
		return mv;
	}
	
	@RequestMapping(value="registerProcess.htm",method=RequestMethod.POST)

	public ModelAndView registerProcess(@ModelAttribute("employee") Employee employee,Errors error){
		ModelAndView mv=new ModelAndView();
		
		ValidationUtils.invokeValidator(validator, employee, error);
		
		if(error.hasErrors()){
			
			mv.setViewName("form");
		}else{
			
			boolean result=facade.persistEmployee(employee);
			
			if(result){
				mv.addObject("status","Registration Successful");
				mv.setViewName("form");
			}
			else{
				mv.addObject("status","Registration UnSuccessful");
				mv.setViewName("form");

			}
		}
		
		return mv;
		
		
	}
	
}
