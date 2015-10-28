package org.java.arrays;

public class MaxPossibleNumber {

	public static void main(String[] args) {

		int[] arr = {1,3,3,1};

		System.out.println(getMaxPossibleNumber(arr));
	}

	private static int getMaxPossibleNumber(int[] arr) {
		int[] maxNumber = new int[1];
		maxNumber[0] = Integer.MIN_VALUE;
		maxNumber[0] = Math.max(maxNumber[0], getMaxPossibleNumberHelper(arr, maxNumber));
		return maxNumber[0];
	}

	private static int getMaxPossibleNumberHelper(int[] arr, int[] maxNumber) {
	}

}
