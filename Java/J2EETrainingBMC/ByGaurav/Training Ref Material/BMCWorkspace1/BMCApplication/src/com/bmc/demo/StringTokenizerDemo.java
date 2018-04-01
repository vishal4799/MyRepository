package com.bmc.demo;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data="Java is Object oriented programming language";
		StringTokenizer tokens=new StringTokenizer(data," ");
		while(tokens.hasMoreTokens()){
			System.out.println(tokens.nextToken());
			
		}

	}

}
