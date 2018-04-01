package com.bmc.demo;

public class VariableArgumentDemo {
	public static int sum(int...n){
		int sum = 0;
		for(int i:n){
			sum +=i;
		}
		return sum;
	}
	public static int print(Object...n){
		int sum = 0;
		System.out.println(n.toString());
//		for(Object i:n){
//			sum +=i;
//		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10,20,30,40));
		System.out.println(print(10,20));
		System.out.println(print(10,20,30,40));
	}
	

}
