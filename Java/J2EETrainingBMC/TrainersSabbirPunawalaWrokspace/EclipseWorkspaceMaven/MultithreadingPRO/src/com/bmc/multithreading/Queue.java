package com.bmc.multithreading;

public class Queue {
	
	private int n;
	private boolean valueset=false;
	
	public synchronized void put(int n){
		
		if(valueset){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.n=n;
		valueset=true;
		System.out.println("Producer put:"+n);
		notify(); 
		
	}
	
	public synchronized int get(){
		if(!valueset){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Consumer got:"+n);
		valueset=false;
		notify();
		return n;
	}

}
