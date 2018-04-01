package com.bmc.service;

import java.util.Arrays;
import java.util.List;



public class MutableStringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb=new StringBuilder();
		sb.append(" Poonawala ");
		sb.insert(0, "Sabbir");
		System.out.println(sb);

		String str="data";
		System.out.println(str.trim());
		
		String str1="123";
		System.out.println("Matches:"+str1.matches(".*[0-9]"));
		
		char dst[]=new char[str.length()];
		str.getChars(0, str.length(), dst, 0);
		System.out.println(dst);
		
	    Arrays.asList(dst).forEach((n)->System.out.println(n));
	    
		
	}

}
