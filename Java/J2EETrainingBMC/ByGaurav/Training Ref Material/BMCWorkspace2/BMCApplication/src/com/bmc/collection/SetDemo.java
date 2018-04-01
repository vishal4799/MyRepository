package com.bmc.collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> set=new HashSet<Integer>();
		System.out.println(set.add(10));
		System.out.println(set.add(20));
		System.out.println(set.add(30));
		System.out.println(set.add(10));
		set.forEach((n)->System.out.println(n));
		
		Set<Employee> setEmployee=new HashSet<Employee>();
		setEmployee.add(new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		setEmployee.add(new Employee(1,"BMC",102,"amit",56000,"Trainer"));
		setEmployee.add(new Employee(1,"BMC",103,"chirag",78000,"Trainer"));
		setEmployee.add(new Employee(1,"BMC",104,"rakesh",90000,"Trainer"));
		setEmployee.add(new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		setEmployee.forEach((e)->System.out.println(e));
		

	}

}
