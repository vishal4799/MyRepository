package com.bmc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("vishal");l.add("rakesh");l.add("sabbir");l.add("amit");l.add("sachin");
		
		Collections.sort(l);
		Collections.sort(l, (s1,s2)->{return s1.compareTo(s2);});
		System.out.println(l);
		
		Employee e1 = new Employee(1,"1vishal",1000,"dev1");
		Employee e2 = new Employee(2,"2vishal",2000,"dev2");
		Employee e3 = new Employee(3,"3vishal",3000,"dev3");
		Employee e4 = new Employee(4,"4vishal",4000,"dev4");
		
		List<Employee> le = new ArrayList<>();
		le.add(e1);le.add(e2);le.add(e3);le.add(e4);
		
		Collections.sort(le, (ee1,ee2)->{
			if(ee1.getId() < ee2.getId()){
				return -1;
			} else if(ee1.getId() > ee2.getId()){
				return 1;
			}
			return 0;
		});
		le.forEach(System.out::println);
	}

}
