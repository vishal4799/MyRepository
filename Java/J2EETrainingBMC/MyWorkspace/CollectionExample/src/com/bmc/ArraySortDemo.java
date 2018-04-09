package com.bmc;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortDemo {

	public static void main(String[] args) {
		String names[]=new String[]{"sachin", "shabbir", "summeett"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));//names.toString doesnt return elements, will print oject details
		Arrays.sort(names, new MyStringComparator());//by length
		System.out.println("by len:"+Arrays.toString(names));
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		});
		System.out.println(Arrays.toString(names));
		Arrays.sort(names, (s1,s2)->{
			if(s1.length() < s2.length()){
				return 1;
			} else if(s1.length() > s2.length()){
				return -1;
			} else{
				return 0;
			}
		});
		System.out.println(Arrays.toString(names));
		Comparator<Object> c= (s1,s2)->{
			if(s1 instanceof String && s1 instanceof String){
				String ss1 = (String)s1;
				String ss2 = (String)s2;
				if(ss1.length() < ss2.length()){
					return 1;
				} else if(ss1.length() > ss2.length()){
					return -1;
				} 
			}
			return 0;
		};
		
		Arrays.sort(names, c);
		System.out.println(Arrays.toString(names));
		
	}
}