package com.bmc.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bmc.entities.Employee;
import com.bmc.service.EmployeeComparatorByName;
import com.bmc.service.EmployeeComparatorBySalary;

public class ComparatorDemo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Sorting of list based on comparators
		
		Employee e1=new Employee();
		e1.setEmpId(101);
		e1.setEmpName("Sabbir");
		e1.setEmpSalary(45000);
		e1.setEmpDesignation("Trainer");
		

		Employee e2=new Employee();
		e2.setEmpId(100);
		e2.setEmpName("amit");
		e2.setEmpSalary(35000);
		e2.setEmpDesignation("Developer");
		

		Employee e3=new Employee();
		e3.setEmpId(99);
		e3.setEmpName("Gaurav");
		e3.setEmpSalary(49000);
		e3.setEmpDesignation("Accountant");
		
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		
		//utitlity class
		Collections.sort(employeeList, new EmployeeComparatorBySalary());
		System.out.println(employeeList);
		
		Collections.sort(employeeList,new EmployeeComparatorByName());
		System.out.println(employeeList);
	}

}
