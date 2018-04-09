package com.bmc.multithearding;

public class MultithreadedApplication {
	
	class SumTask extends Thread{
		public int sum(){
			int sum = 0;
			for(int i = 1;i<=10;i++){
				sum+=i;
				System.out.println("sum at a moment:"+sum);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return sum;
		}
		@Override
		public void run(){
			System.out.println("Final sum is :"+sum());
		}
	}
	
	class ProductTask implements Runnable{
		public double product(){
			double product = 1;
			for(int i = 1;i<=10;i++){
				product*=i;
				System.out.println("Product at a momemt:"+product);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return product;
		}
		@Override
		public void run() {
			System.out.println("Final product:"+product());
		}
	}
	
	public static void main(String[] args) {
		//1.Thread doesn't exist
		//2.Thread is born
		
		MultithreadedApplication application = new MultithreadedApplication();
		//3.register runnable target
		//worker1:inner class, with Thread class
		Thread worker1 = new Thread(application.new SumTask());
		//4. Runnable state
		worker1.start();
		//5.Thread is running
		try {
			worker1.join();//will instruct main thread to wait and let the finish worker1 and then join cpu again.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//worker2:inner class, with Runnable interface
		Thread worker2 = new Thread(application.new ProductTask());
		worker2.start();
		
		//worker3:anonymous class
		Thread worker3 = new Thread(){
			@Override
			public void run(){
				System.out.println("Final div:"+div());
			}
			public double div(){
				double div = 1;
				for(int i = 1;i<=10;i++){
					div/=i;
					System.out.println("Div at a moment"+div);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return div;
			}
		};
		
		worker3.start();
		//worker4:inner class, with Runnable interface
		Runnable r4 =()->{
			for(int i=1;i<=10;i++){
				System.out.println("Squre at a momemt:"+i*i);
				try {
					Thread.sleep(500);// it will sleep main thread
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//worker4.run();//it won't create new thread it's main thread only
		Thread worker4 = new Thread(r4);
		worker4.start();//it will separate thread than main.
	}

}