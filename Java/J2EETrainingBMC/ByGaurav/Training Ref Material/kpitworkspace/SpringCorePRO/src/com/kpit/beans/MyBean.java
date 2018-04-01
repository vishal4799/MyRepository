package com.kpit.beans;

public class MyBean {
	
	public void init(){
		System.out.println("--MyBean initialized--");
	}
	
	public void destroy(){
		System.out.println("--MyBean destroyed--");

		
	}
	
	public MyBean(){
		
		System.out.println("--MyBean Constructor called--");
	}
	
	public void x(){
		
		System.out.println("--x called--");
	}

}
