package com.bmc.multithreading;

public class Person implements Runnable{
	
	private String personName;
	private ATM atm;
	
	public Person(String personName,ATM atm){
		this.personName=personName;
		this.atm=atm;
	}
	
	@Override
	public void run(){
		
		System.out.println(personName+" waiting in queue ");
		synchronized(atm){
			System.out.println(personName+" entered ATM Cabin ");
			try {
				System.out.println(personName+" performing transaction ");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(personName+ " quits ATM Cabin ");
			
		}
		
		
	}

}
