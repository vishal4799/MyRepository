package com.bmc.service;

import java.util.ArrayList;
import java.util.List;

public class MethodReference  {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		List<Integer> list=new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		list.forEach(System.out::println);
		
		
		
	}

}
