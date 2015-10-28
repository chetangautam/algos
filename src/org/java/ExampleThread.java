package org.java;

public class ExampleThread extends Thread {

	private int delay;

	public ExampleThread(String label, int d) {
		super("Thread '" + label + "'");
		this.delay = d;
	}

	public void run() {
		for(int count=1, row=1; row<20; row++, count++) {
			System.out.format("Line #%d from %s\n", count, getName());
			try {
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
