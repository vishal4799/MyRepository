package com.kpit.beans;

public class MyBean1 {
	
	
	public static MyBean1 createInstance(){
		System.out.println("--createInstance()--");
		MyBean1 mybean1=new MyBean1();
		return mybean1;
	}
	
	public void x(){
		System.out.println("--x method called--");
	}

}
