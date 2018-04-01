package com.bmc.fork;

import java.util.ArrayList;
import java.util.List;

import com.bmc.multithreading.Employee;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> list=new ArrayList<>();
		
		list.add(new Employee(1,"Sabbir",45000,"Trainer"));
		list.add(new Employee(2,"Amit",65000,"Trainer"));
		list.add(new Employee(3,"Rohit",95000,"Trainer"));
		list.add(new Employee(4,"Sachin",15000,"Trainer"));
		list.add(new Employee(5,"Rakesh",85000,"Trainer"));
		
		long count=list.stream().filter((e)->e.getEmpName().startsWith("R")).count();
		System.out.println("Count:"+count);
		
		long count1=list.parallelStream().filter((e)->e.getEmpName().startsWith("S")).
		filter((e)->e.getEmpSalary()>5000).count();
		
		
		
		
	}

}
