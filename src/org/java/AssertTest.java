package org.java;

public class AssertTest {

	public static void main(String[] args) {

		boolean toCheck1 = true;
		boolean toCheck2 = true;
		
		assert toCheck1 == toCheck2;
		System.out.println("Should never print!");
	}

}
