package com.bmc.multithearding;

public class Consumer implements Runnable{
	
	private Queue queue;
	public Consumer(Queue queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		while(true){
			queue.get();
		}
	}
}
