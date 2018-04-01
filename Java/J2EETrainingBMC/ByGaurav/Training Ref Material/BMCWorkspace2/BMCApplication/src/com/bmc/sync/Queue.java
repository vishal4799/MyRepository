package com.bmc.sync;
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
		System.out.println("Put:"+n);
		valueset=true;
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
		
		System.out.println("Got:"+n);
		valueset=false;
		notify();
		return n;
	}

}
