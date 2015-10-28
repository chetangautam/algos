package org.java.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class PascalTriangle {

	public static void main(String[] args) {

		printPascalTraingle(1);
		System.out.println();
		printPascalTraingle(2);
		System.out.println();
		printPascalTraingle(3);
		System.out.println();
		printPascalTraingle(4);
		System.out.println();
		printPascalTraingle(5);
		System.out.println();
		printPascalTraingle(6);
		System.out.println();
		printPascalTraingle(7);
		System.out.println();

	}

	private static void printPascalTraingle(int n) {
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue1.add(1);
		for (int i=0; i < n; ++i) {
			System.out.print(queue1.peek() + " ");
			queue2.add(queue1.peek());
			while (!queue1.isEmpty()) {
				if (queue1.size()>1) {
					int elementToInsert = queue1.poll() + queue1.peek();
					queue2.add(elementToInsert);
					System.out.print(queue1.peek() + " ");
				} else {
					int lastElem = queue1.poll();
					queue2.add(lastElem);
				}
			}
			System.out.println();
			// Swap queues
			Queue<Integer> temp = queue1;
			queue1 = queue2;
			queue2 = temp;
		}
	}

}
