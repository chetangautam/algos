package org.java.arrays;

public class MaxSumSubArray {

	public static void main(String[] args) {

		int[] arr = {(-2), 1, (-3), 4, (-1), 2, 1, (-5), 4};
		System.out.println(getMaxSubArraySum(arr));

		int[] arr2 = {(-2), (-3), (-4), (-1),  (-5)};
		System.out.println(getMaxSubArraySum(arr2));

	}

	private static int getMaxSubArraySum(int[] arr) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		for (int i=0; i<arr.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere+arr[i], 0);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

}
