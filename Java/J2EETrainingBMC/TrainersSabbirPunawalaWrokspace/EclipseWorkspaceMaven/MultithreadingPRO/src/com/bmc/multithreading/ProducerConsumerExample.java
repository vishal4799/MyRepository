package com.bmc.multithreading;

public class ProducerConsumerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue=new Queue();
		
		Thread producer=new Thread(new Producer(queue));
		Thread consumer=new Thread(new Consumer(queue));
		
		producer.start();
		consumer.start();
		
		

	}

}
