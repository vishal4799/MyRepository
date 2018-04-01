package com.bmc.service;

public class DefaultInterfaceImpl implements DefaultInterface1 ,DefualtInterface2{

	
	
	public void abstractMethod(){
		
	}
	public void defaultMethod(){
		
		DefaultInterface1.super.defaultMethod();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultInterface1 functionalInterface=new DefaultInterfaceImpl();
		functionalInterface.defaultMethod();
		
		

	}

}
