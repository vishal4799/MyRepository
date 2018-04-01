package com.bmc.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Employee> map = new HashMap<Integer,Employee>();
		map.put(1, new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		map.put(2, new Employee(1,"BMC",102,"amit",56000,"Trainer"));
		map.put(3, new Employee(1,"BMC",103,"chirag",78000,"Trainer"));
		map.put(4, new Employee(1,"BMC",104,"rakesh",90000,"Trainer"));
		map.put(5, new Employee(1,"BMC",105,"suresh",40000,"Trainer"));
		map.put(6, new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		map.put(1, new Employee(1,"BMC",107,"NewValue",35000,"Trainer"));
//before Java 8
		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		
		// Java 8
		map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));

		Employee eCheck=new Employee(1,"BMC",101,"sabbir",35000,"Trainer");
		map.forEach((k,v)->{
			System.out.println("Key : " + k + " Value : " + v);
			if(eCheck.equals(v)){
				System.out.println("Employee Found:");
			}
		});
		
	}

}
