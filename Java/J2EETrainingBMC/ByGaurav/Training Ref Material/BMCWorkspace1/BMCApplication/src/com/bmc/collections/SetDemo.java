package com.bmc.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.Set is unordered no guarantee object will be added at what index position
		//index position is computed based on hash value
		//2.Set do not allow duplicate objects
		//3.Internally Set uses Map to determine duplicate objects
		//Map<String> map=new HashMap<String>();
		Set<String> set=new HashSet<String>();
		
		System.out.println(set.add("sabbir"));//add returns boolean
		System.out.println(set.add("sabbir"));//returns false,already present
		System.out.println(set.add("amit"));
		
		for(Iterator<String> iterator=set.iterator();iterator.hasNext();){
			System.out.println(iterator.next().toUpperCase());
			
		}
		
		
	}

}
