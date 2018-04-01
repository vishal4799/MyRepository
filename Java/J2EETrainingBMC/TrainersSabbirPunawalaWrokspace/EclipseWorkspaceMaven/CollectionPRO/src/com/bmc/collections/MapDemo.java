package com.bmc.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer,String> map=new HashMap<>();

		System.out.println(map.put(1, "sabbir"));
		System.out.println(map.put(2, "Amit"));
		System.out.println(map.put(1, "Rakesh"));
		
		Set<Map.Entry<Integer,String>> set=map.entrySet();
		
		Iterator<Map.Entry<Integer,String>> iterator=set.iterator();
		while(iterator.hasNext()){
			
			Map.Entry<Integer,String> me=iterator.next();
			System.out.println("Key:"+me.getKey());
			System.out.println("Value:"+me.getValue());
		}
		
		
		Set<Integer> setKeys=map.keySet();
		Iterator<Integer> iteratorInteger=setKeys.iterator();
		while(iteratorInteger.hasNext()){
			System.out.println(map.get(iteratorInteger.next()));
		}
		map.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
		
		});
		
		
		//Stream is interface introducted in Java 8
		//Stream is wrapper around datasources like collections,file IO,
		//database
		//It do not change underlying data
		//internally it creates pipeline for every operation to be performed
		
		
		 Map<Integer, String> collect = map.entrySet().stream()
	                .filter(m -> m.getKey() == 2)
	                .collect(Collectors.toMap(
	                		p -> p.getKey(), p -> p.getValue()));

	        System.out.println(collect); 
		
	}

}
