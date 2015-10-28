package org.java;

import java.util.HashSet;
import java.util.TreeSet;

public class DuplicateInteger {

	public static void main(String[] args) {
		/*
		 * return array of unique integers using HashSet and ordered using TreeSet
		 */
		int[] intArrayWithDuplicates = {1,3,5,2,34,6,2,3};
		HashSet<Integer> nonDuplicateHashSet = new HashSet<Integer>();
		TreeSet<Integer> nonDuplicateTreeSet = new TreeSet<Integer>();

		for(int i = 0; i < intArrayWithDuplicates.length; ++i) {
			nonDuplicateHashSet.add(intArrayWithDuplicates[i]);
			nonDuplicateTreeSet.add(intArrayWithDuplicates[i]);
		}

		Object[] objArrayFromHashSet = nonDuplicateHashSet.toArray();
		int[] intArrayWithoutDuplicatesFromHS = new int[objArrayFromHashSet.length];
		int j=0;
		for(Object obj1: objArrayFromHashSet) {
			intArrayWithoutDuplicatesFromHS[j] = (Integer)obj1;
			++j;
		}
		for(int num: intArrayWithoutDuplicatesFromHS) System.out.println(num);
		System.out.println("---");

		Object[] objArrayFromTreeSet = nonDuplicateTreeSet.toArray();
		int[] intArrayWithoutDuplicatesFromTS = new int[objArrayFromTreeSet.length];
		j=0;
		for(Object obj1: objArrayFromTreeSet) {
			intArrayWithoutDuplicatesFromTS[j] = (Integer)obj1;
			++j;
		}
		for(int num: intArrayWithoutDuplicatesFromTS) System.out.println(num);
		System.out.println("---");
		System.out.println("----------------------");
		/*******************************************/
	}

}
