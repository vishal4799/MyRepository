package com.bmc.collections;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//combination of List and Set
		//objects will be ordered--List
		//no duplicates--Set
		LinkedHashSet listSet=new LinkedHashSet();
		listSet.add(10);
		listSet.add(20);
		listSet.add(30);
		listSet.add(20);
		
		System.out.println(listSet);

	}

}
