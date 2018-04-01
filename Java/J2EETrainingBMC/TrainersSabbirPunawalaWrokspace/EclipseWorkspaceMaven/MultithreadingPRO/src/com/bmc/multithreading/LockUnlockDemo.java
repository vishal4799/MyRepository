package com.bmc.multithreading;
import java.util.concurrent.locks.ReentrantLock;
public class LockUnlockDemo implements Task {
	final ReentrantLock reentrantLock = new ReentrantLock();	
	@Override
	public void doTransactionTask(String personName) {
	    reentrantLock.lock();
	    try { 
	    	 System.out.println(personName + " entered ATM Cabin.");
	    	 System.out.println(personName+" doing transaction...");
	    	 Thread.sleep(2000);
	    } catch (InterruptedException e) {
	         e.printStackTrace();
	    } finally {
	    	 System.out.println(personName + " exited ATM Cabin");
		 reentrantLock.unlock();
            }
	}
} 