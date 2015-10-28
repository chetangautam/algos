package org.java;

public class MaxDifferenceArray {

	public static void main(String[] args) {

		// int[] arr = {5};

		int[] arr = {5, 6, 3, 7, 3, 6, 8, 3, 9, 2, 9};

		if(arr.length < 2) {
			throw new IllegalArgumentException();
		}
		System.out.println(findMaxDiff_slow(arr));
		System.out.println(findMaxDiff_medium(arr));
		System.out.println(findMaxDiff_fast(arr));
		
	}

	private static int findMaxDiff_slow(int[] arr) {

		int difference = 0;
		for(int i = 0; i <= arr.length - 2; ++i) {
			for (int j = i + 1; j <= arr.length -1; ++j) {
				difference = Math.max(difference, arr[j] - arr[i]);
			}
		}
		
		return difference;
	}

	private static int findMaxDiff_fast(int[] arr) {
		int difference = 0;
		int min = arr[0];
		for (int i = 1; i < arr.length-1; ++i) {
			min = Math.min(min, arr[i]);
			difference = Math.max(difference, arr[i+1]-min);
		}
		return difference;
	}

	private static int findMaxDiff_medium(int[] arr) {
		int length = arr.length;
		if (length == 2) {
			return arr[1] - arr[0];
		}
		int mid = length/2;
		int[] arr1 = new int[mid];
		int[] arr2 = new int[arr.length-mid];
		int min = arr[0];
		int max = arr[mid+1];

		for(int i = 0; i< arr.length; ++i) {
			if(i < mid) {
				arr1[i] = arr[i];
				min = Math.min(min, arr[i]);
			} else {
				arr2[i-mid] = arr[i];
				max = Math.max(max, arr[i]);
			}
		}
		int difference1 = findMaxDiff_slow(arr1);
		int difference2 = findMaxDiff_slow(arr2);

		return Math.max(Math.max(difference1, difference2), max - min);
	}
}
