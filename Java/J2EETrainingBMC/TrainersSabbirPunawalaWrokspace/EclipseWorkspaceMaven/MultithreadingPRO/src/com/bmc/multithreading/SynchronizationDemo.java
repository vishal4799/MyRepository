package com.bmc.multithreading;

public class SynchronizationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATM atm=new ATM("ICICI Bank","Yerwada");
		
		Person person1=new Person("Sabbir",atm);
		Person person2=new Person("Amit",atm);
		Person person3=new Person("Priya",atm);
		Person person4=new Person("Sumeet",atm);

		
		
		Thread worker1=new Thread(person1);
		Thread worker2=new Thread(person2);
		Thread worker3=new Thread(person3);
		Thread worker4=new Thread(person4);
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();

		
		

	}

}
