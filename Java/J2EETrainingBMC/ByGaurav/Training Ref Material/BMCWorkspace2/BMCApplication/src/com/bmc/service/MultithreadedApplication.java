package com.bmc.service;

public class MultithreadedApplication {
	
	class SumTask extends Thread{
		@Override
		public void run(){
			System.out.println("Sum is:"+sum());
			
		}
		
		public double sum(){
			double sum=0;
			for(int i=0;i<10;i++){
				sum+=i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread worker1=new Thread(new MultithreadedApplication().new SumTask());
		worker1.start();
		
		Thread worker2=new Thread(){
			
			public void run(){
				System.out.println("Product is:"+product());
			}
			public double product(){
				double product=1;
				for(int i=1;i<10;i++){
					product*=i;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return product;
			}
		};

		worker2.start();
	}

}
