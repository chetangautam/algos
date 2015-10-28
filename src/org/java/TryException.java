package org.java;

public class TryException {

	public void process() {
		System.out.println("inside process");
		throw new IllegalArgumentException();
	}

}
