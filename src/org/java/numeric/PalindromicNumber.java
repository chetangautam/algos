package org.java.numeric;

import java.util.Stack;

public class PalindromicNumber {

	public static void main(String[] args) {

		System.out.println(nextPalinNum(1));
		System.out.println(nextPalinNum(23545));
		System.out.println(nextPalinNum(99));
		System.out.println(nextPalinNum(6789876));
		System.out.println(nextPalinNum(8998));
		System.out.println(nextPalinNum(783322));
		System.out.println(nextPalinNum(78322));
		long num = 94187978322L;
		System.out.println(nextPalinNum(num));
	}

	private static long nextPalinNum(long num) {

		String sNum = getString(num); // String.valueOf(num);
		int length = sNum.length();

		String sLeftHalf = null;
		String sRightHalf = null;

		if (length%2==0) {
			sLeftHalf = sNum.substring(0, length/2);
			sRightHalf = sNum.substring(length/2);
		} else {
			sLeftHalf = sNum.substring(0, length/2+1);
			sRightHalf = sNum.substring(length/2);
		}

		String sReverseLeftHalf = getReverse(sLeftHalf);
		long reverseLeftHalf = getLong(sReverseLeftHalf);
		long rightHalf = getLong(sRightHalf);

		if (reverseLeftHalf>rightHalf) {
			// just copy and return here
			return createNextPalin(length, length/2, sLeftHalf);
		} else {
			int lenLeftHalf = sLeftHalf.length();

			long leftHalf = getLong(sLeftHalf); // Long.valueOf(sHalfNum);

			leftHalf++;

			String sLeftHalfAug = getString(leftHalf); // String.valueOf(halfNum);

			int lenAugAfterHalf = sLeftHalfAug.length();

			int finalLength = (lenAugAfterHalf==lenLeftHalf)? length: length+1;

			return createNextPalin(finalLength, lenAugAfterHalf, sLeftHalfAug);
		}

	}

	private static long createNextPalin(int length, int halfLength, String sLeftHalf) {
		char[] finalNum = new char[length];
		for (int i=0; i<halfLength; ++i) {
			finalNum[i] = sLeftHalf.charAt(i);
			finalNum[length-1-i] = sLeftHalf.charAt(i);
		}
		// couldnt find good fix - so below line
		finalNum[sLeftHalf.length()-1] = sLeftHalf.charAt(sLeftHalf.length()-1);
		return Long.valueOf(new String(finalNum));
	}

	private static String getReverse(String str) {
		String retVal = "";
		for(int i=0; i<str.length(); ++i) {
			retVal = str.charAt(i) + retVal;
		}
		return retVal;
	}

	/*
	 * only positive considered
	 */
	public static String getString(long num) {
		Stack<Integer> stack = new Stack<Integer>();
		while(num>0) {
			int remainder = (int) (num%10);
			stack.push(remainder);
			num/=10;
		}
		StringBuilder sb = new StringBuilder();
		while(stack.size()>0) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}


	/*
	 * only positive considered
	 */
	public static long getLong(String str) {
		long res = Character.digit(str.charAt(0),10);
		for (int i= 1; i<str.length(); ++i) {
			res *= 10;
			res += Character.digit(str.charAt(i),10);
		}
		return res;
	}
}
