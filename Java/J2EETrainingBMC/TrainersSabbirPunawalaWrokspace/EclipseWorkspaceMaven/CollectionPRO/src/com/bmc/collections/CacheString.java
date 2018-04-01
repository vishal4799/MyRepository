package com.bmc.collections;

import java.util.ArrayList;
import java.util.List;

public class CacheString {
	
	private String data;
	
	private List<String> list=new ArrayList<>();
	
	
	public void add(String data){
		//perform computation of data
		list.add(data);
	}
	
	public List<String> getData(){
		
		return list;
	}
	
	

}
