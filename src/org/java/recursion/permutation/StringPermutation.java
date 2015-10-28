package org.java.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {

		String str = "abcd";

		List<String> permutations = getPermutationsUsingCharArray(str);
		for(String s: permutations) {
			System.out.println(s);
		}
		System.out.println();

		permutations.clear();
		permutations = getPermutationsUsingString(str);
		for(String s: permutations) {
			System.out.println(s);
		}
	}

	private static List<String> getPermutationsUsingString(String str) {
		List<String> perms = new ArrayList<String>();
		getPermutationsHelper(str, perms, 0);
		return perms;
	}

	private static void getPermutationsHelper(String str, List<String> perms, int i) {
		if(i>=str.length()) {
			perms.add(str);
			return;
		}
		for(int index=i; index<str.length(); ++index) {
			if (index != i) {
				str = str.substring(0, i) + str.charAt(index) + str.substring(i+1, index) + str.charAt(i) + str.substring(index+1);
			}
			getPermutationsHelper(str, perms, i+1);
		}
	}

	private static List<String> getPermutationsUsingCharArray(String str) {
		List<String> perms = new ArrayList<String>();
		char[] arr = str.toCharArray();
		getPermutationsHelper(arr, perms, 0);
		return perms;
	}

	private static void getPermutationsHelper(char[] arr, List<String> perms, int i) {
		if(i>=arr.length) {
			String perm = new String(arr);
			perms.add(perm);
			return;
		}
		for(int index=i; index<arr.length;++index) {
			swap(arr, index, i);
			getPermutationsHelper(arr, perms, i+1);
			swap(arr, index, i);
		}
	}

	private static void swap(char[] arr, int j, int i) {
		if(i==j) {
			return;
		}
		char c=arr[i];
		arr[i]=arr[j];
		arr[j]=c;
	}

}
