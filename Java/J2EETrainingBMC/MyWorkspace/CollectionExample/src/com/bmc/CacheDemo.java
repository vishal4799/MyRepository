package com.bmc;

import java.util.ArrayList;
import java.util.List;

public class CacheDemo {
	
	public static void main(String[] args){
		CacheString cacheString=new CacheString();
		cacheString.add("sabbir");
		List<String> list = cacheString.getData();
		
		CacheAny<Integer> ci = new CacheAny<>();
		ci.add(10);
		List<Integer> listi = ci.get();
		
		CacheAny<Float> cf = new CacheAny<>();
		cf.add(12.5f);
		List<Float> listf = cf.get();
		
		CacheAny<String> cs = new CacheAny<>();
		cs.add("vishal");
		List<String> lists = cs.get();
		
		CacheAny<Employee> ce = new CacheAny<>();
		List<Employee> liste = ce.get();
		CacheAny.print(listi);
		CacheAny.print(listf);
		CacheAny.print(lists);//works only when there's not ? extends Number
		//CacheAny.print(liste);//doesn't work as employee class isnt serializable

		
	}
}
