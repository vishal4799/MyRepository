package com.bmc.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CacheAny<T> {
	
	List<T> list=new ArrayList<T>();
	
	public void setData(T data){
		list.add(data);
	}

	public List<T> getData(){
		return list;
	}
	
	public void print(List<? extends Comparator> list){
		
		
		Iterator<?> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}
