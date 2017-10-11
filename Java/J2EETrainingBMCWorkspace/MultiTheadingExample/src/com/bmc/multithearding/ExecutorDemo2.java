package com.bmc.multithearding;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo2 {
	
	class SumTask implements Callable<Integer>{
		private int count;
		public SumTask(int count){
			this.count = count;
		}
		public int sum(){
			int sum = 0;
			for(int i = 1;i<=count;i++){
				sum+=i;
			}
			return sum;
		}
		@Override
		public Integer call() throws Exception {
			int sum = sum();
			System.out.println("sum is :"+sum+":ThreadId:"+Thread.currentThread().getId());
			return sum;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int NOTHREADS = 5;
		ExecutorService service = Executors.newFixedThreadPool(NOTHREADS);
		Set<Future<Integer>> set = new HashSet<>();
		for (int i = 0; i <= NOTHREADS; i++) {
			Future<Integer> future =service.submit(new ExecutorDemo2().new SumTask(i*i));
			set.add(future);
		}
		for (Future<Integer> future : set) {
			try {
				System.out.println("computed value:"+ future.get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.awaitTermination(5, TimeUnit.SECONDS);
		service.shutdown();
	}

}
