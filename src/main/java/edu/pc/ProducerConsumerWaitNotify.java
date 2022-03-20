package edu.pc;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerWaitNotify extends ProducerConsumer {

	private final Object lock = new Object();
	private LinkedList<Integer> list = new LinkedList<>();

	public ProducerConsumerWaitNotify(int capacity) {
		super.capacity = capacity;
	}

	@Override
	public void producer() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				int i = 0;
				if (list.size() < capacity) {
					list.add(i++);
					System.out.println("Producer Added: " + i + "  List Size is " + list.size());
					Thread.sleep(2000);
				} else {
					lock.wait();
				}
				lock.notify();
			}
		}

	}

	@Override
	public void consumer() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				int i = 0;
				if (list.size() != 0) {
					System.out.println("Consumer Removed: " + list.removeFirst() + "  List Size is " + list.size());
					Thread.sleep(2000);
				} else {
					lock.notify();
				}
				lock.wait();
			}

		}
	}
}
