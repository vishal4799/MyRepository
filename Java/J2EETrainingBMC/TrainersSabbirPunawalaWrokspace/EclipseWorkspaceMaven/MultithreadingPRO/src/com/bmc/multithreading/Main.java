package com.bmc.multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
	public static void main(String[] args) {
		final int threadCount = 5;
		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
		final Task task = new LockUnlockDemo();
		String personNames[]={"sabbir","sumeet","sachin","rohit","priya"};
		for (int i=0; i< threadCount; i++) {
			
				service.execute(new Worker(task,personNames[i]));

			
		}
		service.shutdown();
	}
} 