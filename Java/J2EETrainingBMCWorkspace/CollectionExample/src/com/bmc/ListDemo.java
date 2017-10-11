package com.bmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.bmc.Employee;

public class ListDemo {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"1vishal",1000,"dev1"));
		list.add(new Employee(2,"2vishal",2000,"dev2"));
		list.add(new Employee(3,"3vishal",3000,"dev3"));
		list.add(new Employee(4,"3vishal",4000,"dev4"));
		list.add(new Employee(5,"3vishal",5000,"dev5"));
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			if(emp.getId() == 1)
				emp.setSalary(100);//no error
			else if (emp.getId() == 2)
				list.remove(i);//no error
		}
		System.out.println("list1:"+list.toString());
		System.out.println();
		list.add(new Employee(2,"2vishal",2000,"dev2"));
		
		for (Employee o : list) {
			//System.out.println(o);
			o.setSalary(o.getSalary()*10);
			if(o.getSalary() == 20000)
				list.remove(o);//throws concurrentModificationException
			System.out.println(o.toString());
		}
		System.out.println("list2:"+list.toString());
		System.out.println();
//		Iterator iterator = list.iterator();//iterator object will stay in memory until GC run
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//			iterator.remove();//no error
//		}
		//iterator1 object will discarded immediatly after in for. that's y for is better against while
		for (Iterator<Employee> iterator1 = list.iterator(); iterator1.hasNext();) {
			Employee object = iterator1.next();
			//object++;//wont actually modify actual list
			//iterator.remove();
		}
		System.out.println(list.toString());
		
		
	}
}
