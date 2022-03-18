package edu.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerBlockingQueue {
	
	int capacity = 0;
	BlockingQueue<Integer> queue = null;
	
	ProducerConsumerBlockingQueue(int capacity){
		this.capacity = capacity;
		queue = new ArrayBlockingQueue<>(capacity);
	}
	
	public void producer() throws InterruptedException {
		int counter = 0;
		while(counter < 10) {
			if(queue.size() < capacity) {
			queue.add(counter++);
			//System.out.println("Added to Queue: " + queue.peek());
			System.out.println("Size Of Queue Producer: " + queue.size());
			TimeUnit.MILLISECONDS.sleep(2000);
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		int counter = 0;
		while(counter < 10) {
			if(queue.size() == capacity)
    		System.out.println("Remove from Queue: " + queue.take());
    		System.out.println("Size Of Queue Consumer: " + queue.size());
			TimeUnit.MILLISECONDS.sleep(500);
		}
	}
	
	
	

}
