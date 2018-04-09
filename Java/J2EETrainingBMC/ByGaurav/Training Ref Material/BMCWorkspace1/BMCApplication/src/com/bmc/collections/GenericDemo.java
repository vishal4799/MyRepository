package com.bmc.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> strList=new ArrayList<String>();
		strList.add("sabbir");//allowed
		//strList.add(10);//not allowed, checked operation
		strList.add("rakesh");
		strList.add("rakesh");//Duplicate allowed
		
		//no type casting required, type safe
		for(String strObject:strList){
			strObject.toUpperCase();
		}
		
		Iterator<String> iterator=strList.iterator();
		while(iterator.hasNext()){
			iterator.next().toLowerCase();
		}
		
	}

}