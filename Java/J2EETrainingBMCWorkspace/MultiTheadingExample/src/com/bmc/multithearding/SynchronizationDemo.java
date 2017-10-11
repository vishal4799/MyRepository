package com.bmc.multithearding;

public class SynchronizationDemo {

	public static void main(String[] args) {
		ATM atm = new ATM("ICICI", "yerwada");
		
		Thread worker1 = new Thread(new Person("Vishal", atm));
		Thread worker2 = new Thread(new Person("Vishal1", atm));
		Thread worker3 = new Thread(new Person("Vishal2", atm));
		Thread worker4 = new Thread(new Person("Vishal3", atm));
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
	}

}
