package com.bmc.service;

import java.util.Comparator;

import com.bmc.entities.Employee;

public class EmployeeComparatorByName implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		
		
		char ch1=(char)returnFirstChar(o1.getEmpName());
		char ch2=(char)returnFirstChar(o2.getEmpName());
		
		if(ch1>ch2){
			return 1;
		}else if(ch1<ch2){
			return -1;
		}
		else{
		return 0;
		}
	}
	
	
	public int returnFirstChar(String name){
		
		char ch=name.trim().charAt(0);
		return ch;
		
	}

}
