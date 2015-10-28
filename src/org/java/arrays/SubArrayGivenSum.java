package org.java.arrays;

import java.util.HashMap;

public class SubArrayGivenSum {

	/*
	 * 	 
	Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Ouptut: Sum found between indexes 2 and 4

	Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
	Ouptut: Sum found between indexes 1 and 4

	Input: arr[] = {1, 4}, sum = 0
	Output: No subarray found
	 * 
	 */

	public static void main(String[] args) {

		int[] arr1 = {1, 4, 20, 3, 10, 5};
		int[] arr2 = {1, 4, 0, 0, 3, 10, 5};
		int[] arr3 = {1, 4};

		int[] indeces1 = new int[2];
		int[] indeces2 = new int[2];
		int[] indeces3 = new int[2];

		print(arr1, 33, indeces1);
		print(arr2, 7, indeces2);
		print(arr3, 0, indeces3);

		System.out.println();
		
		printUsingFastMethod(arr1, 33, indeces1);
		printUsingFastMethod(arr2, 7, indeces2);
		printUsingFastMethod(arr3, 0, indeces3);

		System.out.println();

		printAfterRecurCall(arr1, 33, indeces1);
		printAfterRecurCall(arr2, 7, indeces2);
		printAfterRecurCall(arr3, 0, indeces3);
	}

	private static void print(int[] arr, int sum, int[] indeces) {
		indeces[0] = -1;
		indeces[1] = -1;
		if (foundSubArray_On2(arr, sum, indeces)) {
			for (int i : indeces) {
				System.out.print(i);
				System.out.print(" ");
			}
		} else {
			System.out.print("No Subarray found.");
		}
		System.out.println();
	}

	private static void printUsingFastMethod(int[] arr, int sum, int[] indeces) {
		indeces[0] = -1;
		indeces[1] = -1;
		if (foundSubArray_On(arr, sum, indeces)) {
			for (int i : indeces) {
				System.out.print(i);
				System.out.print(" ");
			}
		} else {
			System.out.print("No Subarray found.");
		}
		System.out.println();
	}

	private static void printAfterRecurCall(int[] arr, int sum, int[] indeces) {
		indeces[0] = -1;
		indeces[1] = -1;
		if (foundSubArrayRecur_On2(arr, sum, indeces)) {
			for (int i : indeces) {
				System.out.print(i);
				System.out.print(" ");
			}
		} else {
			System.out.print("No Subarray found.");
		}
		System.out.println();
	}

	private static boolean foundSubArray_On2(int[] arr, int sum, int[] indeces) {
		int total = 0;
		for(int i=0; i<arr.length; ++i) {
			for(int j=i; j<arr.length; ++j) {
				total+=arr[j];
				if (total==sum) {
					indeces[0] = i;
					indeces[1] = j;
					return true;
				}
			}
			total=0;
		}
		return false;
	}

	private static boolean foundSubArray_On(int[] arr, int sum, int[] indeces) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int total = 0;
		for(int i=0; i<arr.length; ++i) {

			total+=arr[i];
			Integer startIndex = hm.get(total-sum);
			if (startIndex != null) {
				indeces[0] = startIndex+1;
				indeces[1] = i;
				return true;
			}
			hm.put(total, i);
		}
		return false;
	}


	private static boolean foundSubArrayRecur_On2(int[] arr, int sum, int[] indeces) {
		return foundSubArrayRecur_On2_helper(arr, sum, indeces, 0);
	}

	// TODO fix this method
	private static boolean foundSubArrayRecur_On2_helper(int[] arr, int sum, int[] indeces, int i) {
		if (i >= arr.length) {
			return false;
		}
		if (sum-arr[i] == 0) {
			indeces[1] = i;
			return true;
		}
		if (i==0) {
			return foundSubArrayRecur_On2_helper(arr, sum-arr[i], indeces, i+1) || foundSubArrayRecur_On2_helper(arr, sum, indeces, i+1);
		} else {
			return foundSubArrayRecur_On2_helper(arr, sum-arr[i], indeces, i+1) || foundSubArrayRecur_On2_helper(arr, sum+arr[i-1], indeces, i+1);
		}
	}

	
}
