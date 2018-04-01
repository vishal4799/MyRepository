package com.bmc.multithearding;

import java.util.ArrayList;
import java.util.List;


public class StreamDemo {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"1vishal",1000,"dev1"));
		list.add(new Employee(2,"2vishal",2000,"dev2"));
		list.add(new Employee(3,"3vishal",3000,"dev3"));
		list.add(new Employee(4,"3vishal",4000,"dev4"));
		list.add(new Employee(5,"3vishal",5000,"dev5"));
		
		long count = list.stream().filter((e)-> e.getName().startsWith("3")).count();
		System.out.println("count of emp start with 3:"+count);
		long count1 = list.parallelStream().filter((e)->e.getName().startsWith("3")).filter((e)->e.getSalary() > 3000).count();
		System.out.println("count of emp start with 3 and sal > 3000:"+count1);
		
	}

}
