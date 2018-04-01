package com.bmc.collection;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CacheString<String> cacheStrings=new CacheString<String>();
		cacheStrings.setData("Sabbir");
		cacheStrings.setData("Amit");
		cacheStrings.setData("rohit");
		
		List<String> listString=cacheStrings.getData();
		cacheStrings.print(listString);
		//cacheStrings.setData(10);
		
		List<Integer> listInteger=new ArrayList<Integer>();
		listInteger.add(10);
		listInteger.add(20);
		
		//cacheStrings.print(listInteger);
		
		CacheAny<String> cacheString=new CacheAny<String>();
		cacheString.setData("Sabbir");
		cacheString.setData("Amit");
		cacheString.setData("rohit");
		
		//cacheString.print(listString);
		//cacheString.print(listInteger);
		
		CacheAny<Employee> cacheEmployee=new CacheAny<Employee>();
		cacheEmployee.setData(new Employee(1,"BMC",101,"amit",4500,"Trainer"));
		
		CacheAny cacheAny=new CacheAny();
		cacheAny.print(listInteger);
		cacheAny.print(listString);
		

	}

}
