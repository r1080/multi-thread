package edu.pc;

public abstract class ProducerConsumer {
	
	int capacity = 0;
	
	abstract public void producer() throws InterruptedException;
	abstract public void consumer() throws InterruptedException;
		
}
