package com.bmc.multithearding;

public class Person implements Runnable {

	private String personName;
	private ATM atm;
	
	public Person(String personName, ATM atm) {
		this.personName = personName;
		this.atm = atm;
	}

	@Override
	public void run() {
		System.out.println(personName+" is waiting in queue ");
		synchronized (atm) {
			System.out.println(personName+" entered ATM Cabin ");
			try {
				System.out.println(personName+" doing Transaction....");
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			System.out.println(personName+" quits ATM Cabin");
		}
		System.out.println(personName+", other person's threads hold their execution.. waiting for u to finish. ");
	}

}