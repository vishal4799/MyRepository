package com.bmc.collection;

import java.util.ArrayList;
import java.util.List;

public class CacheString<String> {
	
	List<String> list=new ArrayList<String>();
	
	public void setData(String data){
		list.add(data);
		
	}
	
	public List<String> getData(){
		return list;
	}
	public void print(List<String> list){
		
		for(String data:list){
			System.out.println(data);
		}
		
	}
	

}
