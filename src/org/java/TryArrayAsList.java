package org.java;

import java.util.Arrays;
import java.util.List;

public class TryArrayAsList {

	public static void main(String[] args) {
		/*
		 * checking can we modify list returned by Arrays.aslist
		 */
		Integer[] numbers = {10,20,30};
		List<Integer> list = Arrays.asList(numbers);
		System.out.println(list.size());
		//list.clear(); // cannot clear - cannot remove, add
		System.out.println(Arrays.asList(numbers));
		System.out.println(Arrays.asList(numbers).size()); //size is 1
		System.out.println(list.get(0));
		// BUT can change element
		list.set(0, 40);
		System.out.println(list.get(0));
		System.out.println("----------------------");
		/*******************************************/
	}

}
