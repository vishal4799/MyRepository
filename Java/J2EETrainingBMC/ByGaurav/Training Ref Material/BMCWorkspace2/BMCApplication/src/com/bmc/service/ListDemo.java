package com.bmc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListDemo {
	
	
	public static void determineContent(List<Integer> list,Predicate<Integer> predicate){
		
		for(int i:list){
			
			predicate.test(i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list=new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		//Before Java 8
		
		for(int i:list){
			System.out.println(i);
			
		}
		
		//Java 8
		
		list.forEach((n)->System.out.println(n));
		
		determineContent(list,(n)->n%2==0);
		determineContent(list,(n)->n!=0);
		
	}

}
