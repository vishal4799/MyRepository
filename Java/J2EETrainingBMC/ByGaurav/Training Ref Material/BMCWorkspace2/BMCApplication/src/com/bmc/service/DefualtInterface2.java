package com.bmc.service;
@FunctionalInterface
public interface DefualtInterface2 {
	
	public void abstractMethod();
	public default void  defaultMethod(){
		System.out.println("--This is default Method of interface2--");
		
	}

}
