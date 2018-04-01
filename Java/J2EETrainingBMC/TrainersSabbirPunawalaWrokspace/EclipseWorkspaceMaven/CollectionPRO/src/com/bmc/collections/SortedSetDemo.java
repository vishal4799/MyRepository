package com.bmc.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedSet<String> set=new TreeSet<>();
		set.add("amit");
		set.add("ankit");
		set.add("raj");
		set.add("Rajesh");
		
		System.out.println(set);
		SortedSet<Employee> setEmployee=new TreeSet<>();
		Employee e1=new Employee(101,"sabbir",65000,"Trainer");
		Employee e2=new Employee(102,"amit",95000,"Trainer");
		Employee e3=new Employee(103,"chirag",55000,"Trainer");
		Employee e4=new Employee(104,"rohit",35000,"Trainer");
		
		setEmployee.add(e1);
		setEmployee.add(e2);
		setEmployee.add(e3);
		setEmployee.add(e4);
		
		System.out.println(setEmployee);

		

	}

}
