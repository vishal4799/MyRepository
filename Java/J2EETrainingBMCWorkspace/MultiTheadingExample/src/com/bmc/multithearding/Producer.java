package com.bmc.multithearding;

public class Producer implements Runnable{
	
	private Queue queue;
	public Producer(Queue queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		int i=0;
		while(true){
			queue.put(i++);
		}
	}
}
