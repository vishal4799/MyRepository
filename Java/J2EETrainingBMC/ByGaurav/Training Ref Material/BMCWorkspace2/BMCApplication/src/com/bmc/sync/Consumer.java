package com.bmc.sync;
public class Consumer implements Runnable {
	
	private Queue queue;
	
	public Consumer(Queue queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
  while(true){
	  
	  queue.get();
  }
	
	}
	

}
