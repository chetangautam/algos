package org.java.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartion {

	public static void main(String[] args) {
		String str = "ababa";

		ArrayList<ArrayList<String>> pals = getAllPalindromes(str);
		for (ArrayList<String> p : pals) {
			for (String s : p) {
				System.out.print(s);
				System.out.print("|");
			}
			System.out.println();
		}
	}

	private static ArrayList<ArrayList<String>> getAllPalindromes(String str) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> partition = new ArrayList<String>();
		getAllPalindromesHelper(str, 0, partition, result);
		return result;
	}

	private static void getAllPalindromesHelper(String s, int start, List<String> partition, List<ArrayList<String>> result ) {
		if(start==s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for(int i=start+1; i<=s.length(); ++i) {
			String str = s.substring(start, i);
			if(isPalin(str)) {
				partition.add(str);
				getAllPalindromesHelper(s, i, partition, result);
				partition.remove(partition.size()-1);
			}
		}
	}

	private static boolean isPalin(String s) {
		if(s.length()==1|| s.length()==0) {
			return true;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return isPalin(s.substring(1,s.length()-1));
		} else {
			return false;
		}
	}

//	private static List<String> getAllSubStrings(String str) {
//		List<String> palindromes = new ArrayList<String>();
//		subStringHelper(str, palindromes);
//		return palindromes;
//	}
//
//	private static void subStringHelper(String str, List<String> palindromes) {
//
//		char[] arr = str.toCharArray();
//		List<String> substrings = new ArrayList<String>();
//		for(int i=0; i<str.length(); ++i) {
//			for (int j=i; j<str.length(); ++j) {
//				//populateSubstrings(arr, i, j, substrings, 0);
//				String s = new String(arr, i, j-i+1);
//				substrings.add(s);
//			}
//		}
//		for (String s : substrings) {
//			if(isPalin(s)) {
//				palindromes.add(s);
//			}
//		}
//	}

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	 
		if (s == null || s.length() == 0) {
			return result;
		}
	 
		ArrayList<String> partition = new ArrayList<String>();//track each possible partition
		addPalindrome(s, 0, partition, result);
	 
		return result;
	}
	 
	private static void addPalindrome(String s, int start, ArrayList<String> partition,
			ArrayList<ArrayList<String>> result) {
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
	 
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str); 
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}
	 
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
	 
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
	 
			left++;
			right--;
		}
	 
		return true;
	}
}
