package com.bmc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		empList.add(new Employee(1,"BMC",102,"amit",56000,"Trainer"));
		empList.add(new Employee(1,"BMC",103,"chirag",78000,"Trainer"));
		empList.add(new Employee(1,"BMC",104,"rakesh",90000,"Trainer"));
		
		empList.forEach(e -> e.setEmpSalary(e.getEmpSalary()+200));
		
		 Collections.sort(empList,Employee::compareByEmpName);
	        System.out.println(empList);
		
	}

}
