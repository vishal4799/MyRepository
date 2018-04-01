package com.bmc.test;

import java.sql.SQLException;

import com.bmc.dao.EmployeeDAO;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class PersistEmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO=FactoryEmployeeDAO.createEmployeeDAO();
		
		Employee dummy=new Employee();
		dummy.setEmpId(102);
		dummy.setEmpName("Rohit");
		dummy.setEmpSalary(45000);
		dummy.setEmpDesignation("Trainer");
		boolean result=false;
		try {
			result=employeeDAO.persistEmployee(dummy);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Recorded inserted:"+result);

	}

}
