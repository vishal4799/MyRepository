package com.bmc.multithreading;
public class Worker implements Runnable {
	private Task task;
	private String personName;
	public Worker(Task task,String personName) {
		this.task = task;
		this.personName=personName;
	}
	@Override
	public void run() {
		System.out.println(personName+" waiting in queue ");
		task.doTransactionTask(personName);
	}
} 