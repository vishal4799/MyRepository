package com.bmc.service;

public class MyWorker {
	
	public static void execute(WorkerInterface worker){
		worker.doSomeWork();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		execute(
				()->{
					System.out.println("First statement");
					System.out.println("Second statement");
					
				});
				

	}

}
