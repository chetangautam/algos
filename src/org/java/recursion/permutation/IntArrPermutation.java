package org.java.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class IntArrPermutation {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		List<int[]> perms = getPermutations(arr);
		for(int[] p: perms) {
			for(int i: p) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static List<int[]> getPermutations(int[] arr) {
		if(arr==null || arr.length == 0) {
			return null;
		}
		List<int[]> perms = new ArrayList<int[]>();
		getPermutationHelper(arr, 0, perms);
		return perms;
	}

	private static void getPermutationHelper(int[] arr, int i, List<int[]> perms) {
		if(i > arr.length - 1) {
			int[] perm = new int[arr.length];
			for(int index=0; index<arr.length; ++index) {
				perm[index] = arr[index];
			}
			perms.add(perm);
			return;
		}
		for (int index=i; index<arr.length; ++index) {
			swap(arr, index, i);
			getPermutationHelper(arr, i+1, perms);
			swap(arr, index, i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if(i==j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
