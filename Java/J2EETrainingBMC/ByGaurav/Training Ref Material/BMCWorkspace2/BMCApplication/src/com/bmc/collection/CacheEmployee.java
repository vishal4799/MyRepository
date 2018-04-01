package com.bmc.collection;

import java.util.ArrayList;
import java.util.List;

public class CacheEmployee<Employee> {
	
	
	List<Employee> list=new ArrayList<Employee>();
	
	public void setData(Employee employee){
		list.add(employee);
	}
	public List<Employee> getData(){
		
		return list;
	}

	public void print(List<Employee> list){
		
		for(Employee e: list){
			System.out.println(e);
		}
	}
}
