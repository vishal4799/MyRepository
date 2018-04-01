package com.bmc.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo1 {
	
	class SumTask implements Runnable{
		
		private int count;
		
		public SumTask(int count){
			this.count=count;
		}
		
		public int sum(){
			int sum=0;
			for(int i=1;i<=count;i++){
				sum+=i;
			}
			return sum;
		}
		
		@Override
		public void run(){
			System.out.println("Final sum:"+sum()+":"+Thread.currentThread().getId());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int NOTHREADS=10;
		ExecutorService service=Executors.newFixedThreadPool(NOTHREADS);
		for(int i=1;i<=30;i++){
			service.execute(new ExecutorDemo1().new SumTask(i*i));
		}
		
		service.awaitTermination(30, TimeUnit.SECONDS);
		service.shutdown();
		

		
	}

}
