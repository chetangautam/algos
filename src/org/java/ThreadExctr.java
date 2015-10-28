package org.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExctr implements Runnable {

	private int id;

	public ThreadExctr(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		System.out.println("Starting thread id: " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Ending thread id: " + id);
	}

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for (int i =0; i<5; ++i) {
			executor.submit(new ThreadExctr(i));
		}

		System.out.println("All tasks submitted");
		executor.shutdown();

		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		}
		System.out.println("Done");
	}

}
