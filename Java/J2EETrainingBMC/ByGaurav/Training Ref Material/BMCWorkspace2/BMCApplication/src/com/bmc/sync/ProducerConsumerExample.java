package com.bmc.sync;
public class ProducerConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue queue=new Queue();
		
		Producer producer=new Producer(queue);
		Consumer consumer=new Consumer(queue);
		
		Thread worker_producer=new Thread(producer);
		Thread worker_consumer=new Thread(consumer);
		
		worker_producer.start();
		worker_consumer.start();
		
		
	}

}
