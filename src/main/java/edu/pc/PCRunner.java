package edu.pc;

public class PCRunner {

	public static void main(String[] args) {
		
		//ProducerConsumer processor = new ProducerConsumerBlockingQueue(7);
		ProducerConsumer processor = new ProducerConsumerWaitNotify(7);
		
		Thread producer = new Thread(() -> {
			try {
				processor.producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread consumer = new Thread(() -> {
			try {
				processor.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();
	}

}
