package com.bmc.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedMap<Integer,String> map=new TreeMap<Integer,String>();
		map.put(1, "sabbir");
		map.put(4, "amit");
		map.put(3, "rakesh");
		map.put(2, "rohit");
		
		System.out.println(map);
		

	}

}
