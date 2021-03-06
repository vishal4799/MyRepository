package com.bmc.collections;

import java.util.SortedSet;
import java.util.TreeSet;

import com.bmc.entities.Employee;

public class SortedSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Since String class implements Comparable interface
		//logic for comparison is in compareTo(), String objects will be sorted
		//in ascending order lexographically
		SortedSet<String> sortedSet= new TreeSet<String>();
		sortedSet.add("Chirag");
		sortedSet.add("amit");
		sortedSet.add("akash");
		sortedSet.add("rohit");
		//String representation of sortedSet
		System.out.println(sortedSet);
		
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
		
		//Employee class must implement java.lang.Comparable and provide
		//logic for comparision in compareTo()
		
		SortedSet<Employee> sortedSetEmployee=new TreeSet<Employee>();
		sortedSetEmployee.add(e1);//Comparable c1=(Comparable)e1;
		sortedSetEmployee.add(e2);//c2.compareTo(c1)
		sortedSetEmployee.add(e3);
		
		System.out.println(sortedSetEmployee);
		
		
		

	}

}
