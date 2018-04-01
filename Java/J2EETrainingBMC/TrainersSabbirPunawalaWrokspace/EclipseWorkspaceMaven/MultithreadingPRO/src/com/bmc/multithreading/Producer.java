package com.bmc.multithreading;

public class Producer implements Runnable {
	
	private Queue queue;
	
	public Producer(Queue queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i=0;
		while(true){
			queue.put(i++);
		}
		
	}
	
	

}
