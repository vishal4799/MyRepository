package com.bmc.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
	
		
		for(int i=0;i<list.size();i++){
			int k=(Integer)list.get(i);
			System.out.println(k++);
		}
		
		for(Integer o:list){
			int k=(Integer)o;
			System.out.println(k--);
			//list.remove(o); //throws ConcurrentModicationException
		}
		
		list.forEach((n)->{System.out.println(n);});
		
		Iterator iterator=list.iterator();
		
		while(iterator.hasNext()){
			
			int o=(Integer)iterator.next();
			System.out.println(o--);
			iterator.remove();
			
		}
		System.out.println(list);
		
		//Recommended
		for(Iterator iterator1=list.iterator();iterator1.hasNext();){
			
			
			
		}
		
		List list1=new ArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		
		ListIterator listiterator=list1.listIterator();
		
		while(listiterator.hasNext()){
			listiterator.next();
		}
		
		while(listiterator.hasPrevious()){
			System.out.println(listiterator.previous());
		}
		
		
		
		
		

	}

}
