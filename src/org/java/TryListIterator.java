package org.java;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TryListIterator {

	public static void main(String[] args) {
		/*
		 * ListIterator on LinkedList moving in both direction
		 * ListIterator does not work on Set
		 */
		List<String> animals = new LinkedList<String>();
		animals.add("dog");
		animals.add("cat");
		animals.add("goat");
		ListIterator<String> animalsIter = animals.listIterator();
		while(animalsIter.hasNext()) {
			System.out.println(animalsIter.next());
		}
		while(animalsIter.hasPrevious()) {
			System.out.println(animalsIter.previous());
		}
	}

}
