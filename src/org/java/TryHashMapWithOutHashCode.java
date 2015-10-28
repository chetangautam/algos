package org.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TryHashMapWithOutHashCode {

	public static void main(String[] args) {
		/*
		 * HashMap adding without hashCode
		 */
		/*******************************************/
		HashMap<Dog, Integer> dogs = new HashMap<Dog, Integer>();
		Dog dog1 = new Dog("white");
		Dog dog2 = new Dog("black");
		Dog dog3 = new Dog("brown");
		Dog dog4 = new Dog("white");
		dogs.put(dog1, 5);
		dogs.put(dog2, 15);
		dogs.put(dog3, 25);
		dogs.put(dog4, 35);
		//print using for each loop
		for(Entry<Dog, Integer> e: dogs.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		System.out.println("---");
		// print using iterator
		Iterator<Entry<Dog, Integer>> entryIt = dogs.entrySet().iterator();
		while(entryIt.hasNext()) {
			Entry<Dog, Integer> e = entryIt.next();
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		System.out.println("----------------------");
		/*******************************************/
	}

}
