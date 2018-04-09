package com.bmc.demo;

import com.bmc.entities.Employee;

public class EmployeeEqualsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee();
		e1.setEmpId(101);
		e1.setEmpName("sabbir");
		e1.setEmpSalary(45000);
		e1.setEmpDesignation("Trainer");
		
		Employee e2=new Employee();
		e2.setEmpId(101);
		e2.setEmpName("sabbir");
		e2.setEmpSalary(45000);
		e2.setEmpDesignation("Trainer");
		
		if(e1==e2){
			System.out.println("e1==e2");
		}
		//Equals check for content
		if(e1.equals(e2)){
			
			System.out.println("e1.equals(e2)");
		}

		System.out.println("Hash Code of e1:"+e1.hashCode());
		System.out.println("Hash Code of e2:"+e2.hashCode());
	}

}