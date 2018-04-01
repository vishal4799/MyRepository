package com.bmc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"BMC",101,"sabbir",35000,"Trainer"));
		empList.add(new Employee(1,"BMC",102,"amit",56000,"Trainer"));
		empList.add(new Employee(1,"BMC",103,"chirag",78000,"Trainer"));
		empList.add(new Employee(1,"BMC",104,"rakesh",90000,"Trainer"));
		
		//Before Java 8
		for(Employee e: empList){
			System.out.println(e);
		}
		//Java 8
		empList.forEach((n)->System.out.println(n));
		
		
		//Before Java 8
		
		Comparator<Employee> sortByEmpName = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getEmpName().compareTo(e2.getEmpName());
			}
		};
		
		 Collections.sort(empList,sortByEmpName);
	        System.out.println(empList);
		
		//Java 8

		Comparator<Employee> sortByEmpName8 =(Employee e1, Employee e2)->e1.getEmpName().compareTo(e2.getEmpName());
		
        Collections.sort(empList,sortByEmpName8);
        System.out.println(empList);
        
        //External Iterator
        Iterator<Employee> iterator=empList.iterator();
        
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }
        
        for(Iterator<Employee> iterator1=empList.iterator();iterator1.hasNext();){
        	System.out.println(iterator1.next());
        }
        //Move forward as well as backward
        
        ListIterator<Employee> listIterator=empList.listIterator();
        //forward
        
        while(listIterator.hasNext()){
        	
        	listIterator.next();
        }
        
        //backward
        
        while(listIterator.hasPrevious()){
        	
        	System.out.println(listIterator.previous());
        }
        
       
        
	}

}
