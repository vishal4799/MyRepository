package com.bmc.multithreaded;

public class MultithreadedApplication {

	/**
	 * @param args
	 */
	
	//Named Inner class
	
	class SumTask extends Thread{
		
		public double sum(){
			double sum=0;
			
			for(int i=1;i<=10;i++){
				sum+=i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Sum done so far:"+sum);
			}
			
			return sum;
		}
		
		@Override
		public void run(){
			System.out.println("Total sum:"+sum());
			
		}
		
		
	}
	
	class ProductTask implements Runnable{
		
		public double product(){
			double product=1;
			
			for(int i=1;i<=10;i++){
				product*=i;
				System.out.println("Product done so far:"+product);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return product;
		}

		public void run() {
			// TODO Auto-generated method stub
		
				// TODO Auto-generated method stub
				System.out.println("Total product is:"+product());
				
			
			
			
			
		}

		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
		
		MultithreadedApplication application=new MultithreadedApplication();
		Thread worker1=new Thread(application.new SumTask(),"Sum Worker");
		Thread worker2=new Thread(application.new ProductTask(),"Product Worker");
		
		Thread worker3=new Thread(){
			
			public double div(){
				double div=1;
				
				for(int i=1;i<=10;i++){
					div/=i;
					System.out.println("Division done so far:"+div);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return div;
			}
			
			
			@Override
			public void run(){
				System.out.println("Total div is:"+div());
				
			}
			
			
		};

		worker1.start();
		worker2.start();
		worker3.start();
		}
		
	}

}