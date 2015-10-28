package org.java;

public class FirstThreadingExample {

	public static void main(String[] args) {

		ExampleThread mt = new ExampleThread("A", 31);
		ExampleThread mt1 = new ExampleThread("B", 25);
		ExampleThread mt2 = new ExampleThread("C", 10);
		mt.start();
		mt1.start();
		mt2.start();
	}

}
