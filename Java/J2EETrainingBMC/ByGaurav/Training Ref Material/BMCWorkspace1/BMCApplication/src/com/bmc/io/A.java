package com.bmc.io;

import java.io.Serializable;

public class A implements Serializable{
	
	public A(){}

	int a;
	public A(int a){
		this.a=a;
	}
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	
}
