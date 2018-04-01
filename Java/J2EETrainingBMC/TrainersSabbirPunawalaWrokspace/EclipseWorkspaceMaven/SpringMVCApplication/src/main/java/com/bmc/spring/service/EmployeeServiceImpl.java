package com.bmc.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bmc.spring.dao.EmployeeDAO;
import com.bmc.spring.entities.Employee;
import com.bmc.spring.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired@Qualifier("JPAEmployeeDAO")
	private EmployeeDAO employeeDAO;
	

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empList=new ArrayList<Employee>();
		try {
			empList=employeeDAO.getAllEmployees();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}


	public boolean persistEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			result=employeeDAO.persistEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public List<String> getLocationName() {
		// TODO Auto-generated method stub
		List<String> locationList=new ArrayList<String>();
		try {
			locationList=employeeDAO.getLocationNames();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locationList;
	}


	public int retrieveEmpId() {
		// TODO Auto-generated method stub
		int empId=0;
		try {
			empId=employeeDAO.generateEmpId();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empId;
	}

}
