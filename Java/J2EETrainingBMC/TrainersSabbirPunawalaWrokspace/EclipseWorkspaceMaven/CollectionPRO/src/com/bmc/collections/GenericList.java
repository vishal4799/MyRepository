package com.bmc.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GenericList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee e1=new Employee(1,"sabbir",45000,"trainer");
		List  list=new ArrayList();
		list.add(e1);
		System.out.println(list);

		e1.setEmpName("Shabbir");
		System.out.println(list);
		
		Collections.synchronizedList(list);
		
		
		
		/*
		Integer o1=new Integer(10);
		Integer o2=new Integer(20);
		list.add(o1);
		list.add(o2);
		System.out.println(list);

		
		o1=new Integer(45);
		o2=new Integer(55);
		
		System.out.println(list);
		
		
		/*
		Integer o1=new Integer(10);
		Integer o2=new Integer(20);
		list.add(o1);
		list.add(o2);
		//list.add("str");
		System.out.println(list);
		o1=45;
		list.add(o1);
		int k=o1.intValue();
		++k;
		o2=new Integer(45);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		for(Integer o:list){
			System.out.println(o);
		}
		/*
		for(Integer o: list){
			int k=o;
			System.out.println(k++);
		}
		
		for(Iterator<Integer> iterator=list.iterator();iterator.hasNext();){
			//Integer iObjt=iterator.next();
			//iObjt+=3;
			
		}*/
		//System.out.println(list);
		

	}

}
