package com.bmc.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//two different types of collections
		//Homogenous
		//Empty Array
		List list1=new ArrayList();//unchecked and unsafe operation
		//Array with size 3
		List list2=new ArrayList(3);
		
		//will only contain string objects
		List stringObject=new ArrayList();
		stringObject.add("sabbir");
		//stringObject.add(10);//unchecked
		stringObject.add("amit");
		stringObject.add("mohit");
		
		//Heterogenous
		List differentTypeObject=new ArrayList();
		differentTypeObject.add("sabbir");
		differentTypeObject.add(12.4f);
		differentTypeObject.add(450000);
		//not recommended , error prone
		for(int i=0;i<stringObject.size();i++){
			String retrieveStringObject=(String)stringObject.get(i);
			
		}
		for(Object str:stringObject){
			
			String strData=(String)str;
			//stringObject.remove(0);//concurrent modification not allowed
		}
		//Not recommended unless iterator is used at multiple places
		Iterator iterator=stringObject.iterator();
		while(iterator.hasNext()){
			String strData=(String)iterator.next();
			//iterator.remove();concurrent operation allowed
		}
		
		for(Iterator iterator1=stringObject.iterator();iterator1.hasNext();){
			String strData=(String)iterator1.next();
			
		}
		//can move forward as well as backward
		ListIterator listIterator=differentTypeObject.listIterator();
		//move forward
		while(listIterator.hasNext()){
		
			Object ref=listIterator.next();
			//not good programming
			if(ref instanceof String){
				String stringData=(String)ref;
			}
			if(ref instanceof Float){
				Float floatData=(Float)ref;
			}
			if(ref instanceof Double){
				Double doubleData=(Double)ref;
			}
		}
		//move backward
		while(listIterator.hasPrevious()){
			listIterator.previous();
		}
		
		
	}

}
