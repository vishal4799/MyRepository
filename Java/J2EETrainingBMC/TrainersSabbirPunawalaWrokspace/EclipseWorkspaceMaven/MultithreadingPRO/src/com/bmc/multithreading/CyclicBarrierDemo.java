package com.bmc.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	class BarrierRunnable1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Barrier 1 executed");
		}
		
		
	}
	
	class BarrierRunnable2 implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Barrier 2 executed");
		}
	}
	
	class MyRunnable implements Runnable{
		
		private CyclicBarrier barrier1;
		private CyclicBarrier barrier2;
		
		public MyRunnable(CyclicBarrier barrier1,CyclicBarrier barrier2){
			this.barrier1=barrier1;
			this.barrier2=barrier2;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Thread waiting at cyclic barrier 1:"+ Thread.currentThread().getId());

			try {
				barrier1.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread has crossed  cyclic barrier 1:"+ Thread.currentThread().getId());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread has reached before cyclic barrier 2:"+ Thread.currentThread().getId());

			try {
				barrier2.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CyclicBarrierDemo outer=new CyclicBarrierDemo();
		
		CyclicBarrier barrier1=new CyclicBarrier(3,outer.new BarrierRunnable1());
		CyclicBarrier barrier2=new CyclicBarrier(3,outer.new BarrierRunnable2());
		

		Thread worker1=new Thread(outer.new MyRunnable(barrier1,barrier2));
		Thread worker2=new Thread(outer.new MyRunnable(barrier1,barrier2));
		Thread worker3=new Thread(outer.new MyRunnable(barrier1,barrier2));
		Thread worker4=new Thread(outer.new MyRunnable(barrier1,barrier2));
		Thread worker5=new Thread(outer.new MyRunnable(barrier1,barrier2));
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
		worker5.start();
		
		

	}

}
