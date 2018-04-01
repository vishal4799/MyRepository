package com.bmc.collection;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		empList.add(new Employee(1,"BMC",102,"amit",56000,"Trainer"));
		empList.add(new Employee(1,"BMC",103,"chirag",78000,"Trainer"));
		empList.add(new Employee(1,"BMC",104,"rakesh",90000,"Trainer"));
		empList.add(new Employee(1,"BMC",105,"suresh",40000,"Trainer"));
		//before Java 8
		long count = 0;
		for (Employee e : empList)
		  {
		    if (e.getEmpName().startsWith("s"))
		        ++count;
		  }
		System.out.println("Count:"+count);
		
		//Java 8
		
		long count8 = empList.stream()
                .filter(e -> e.getEmpName().startsWith("s"))
                .count();
		
		System.out.println("Count8:"+count8);
	}

}
