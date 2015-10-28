package org.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TryHashMapWithHashCode {

	public static void main(String[] args) {

		/*
		 * HashMap adding with hashCode
		 */
		/*******************************************/
		HashMap<Cat, Integer> cats = new HashMap<Cat, Integer>();
		Cat cat1 = new Cat("white");
		Cat cat2 = new Cat("black");
		Cat cat3 = new Cat("brown");
		Cat cat4 = new Cat("white");
		cats.put(cat1, 5);
		cats.put(cat2, 15);
		cats.put(cat3, 25);
		cats.put(cat4, 35);
		for(Entry<Cat, Integer> e: cats.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		System.out.println("----------------------");
		/*******************************************/

		/*
		 * LinkedHashMap adding with hashCode
		 */
		/*******************************************/
		LinkedHashMap<Cat, Integer> catsLHM = new LinkedHashMap<Cat, Integer>();
		catsLHM.put(cat1, 5);
		catsLHM.put(cat2, 15);
		catsLHM.put(cat3, 25);
		catsLHM.put(cat4, 35);
		for(Entry<Cat, Integer> e: catsLHM.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		System.out.println("----------------------");
		/*******************************************/

	}

}
