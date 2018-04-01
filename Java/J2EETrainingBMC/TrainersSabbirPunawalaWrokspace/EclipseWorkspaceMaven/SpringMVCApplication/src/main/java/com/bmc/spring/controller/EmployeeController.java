package com.bmc.spring.controller;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bmc.spring.entities.Employee;
import com.bmc.spring.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(value="displayemp.htm",method=RequestMethod.GET)
	public ModelAndView retrieveAllEmployee(){
		
		ModelAndView mv=new ModelAndView();
		List<Employee> empList=employeeService.getAllEmployees();
		mv.addObject("empList",empList);
		mv.setViewName("/displayemployee");
		return mv;
		
	}

	@RequestMapping(value="loadform.htm",method=RequestMethod.GET)
	public String loadForm(){
		

		
		
		return "registerform";
		
	}
	
	@RequestMapping(value="registerProcess.htm",method=RequestMethod.POST)
	public ModelAndView registerForm(@ModelAttribute("employee") Employee employee,Errors errors){
		ModelAndView mv=new ModelAndView();
		

		
		ValidationUtils.invokeValidator(validator, employee, errors);
		
		if(errors.hasErrors()){
			
			mv.setViewName("registerform");
		}else{
			
			boolean result=employeeService.persistEmployee(employee);
			if(result){
				mv.addObject("status","Registration Successful");
				mv.setViewName("registerform");
			}else{
				mv.addObject("status","Registration Unsuccessful");
				mv.setViewName("registerform");
			}
		}
		
		
		return mv;
		
		
	}
	
	
	
	@ModelAttribute("employee")
	public Employee defaultEmployeeObject(){
		Employee employee=new Employee();
		employee.setEmpId(employeeService.retrieveEmpId());
		employee.setEmpName("Please enter FirstName LastName");
		employee.setEmpSalary(0.0);
		employee.setEmpDesignation("Please enter GET,SE,SSE");
		return employee;
	}
	@ModelAttribute("locationList")
	public List<String> locationList(){
		return employeeService.getLocationName();
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exceptionHandler(Exception exception){
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("message",exception.getMessage());
		mv.setViewName("error");
        return mv;		
		
	}
}

