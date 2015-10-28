package org.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TryHashSet {

	public static void main(String[] args) {
		/*
		 * add null and value in set and traverse
		 */
		Set<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(null);
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(0);

		/*
		 * Iterate using iterator
		 */
		Iterator<Integer> it = hashSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("---");

		/*
		 * Iterate using foreach
		 */
		for(Integer i: hashSet) {
			System.out.println(i);
		}
		System.out.println("----------------------");
		/*******************************************/
	}

}
