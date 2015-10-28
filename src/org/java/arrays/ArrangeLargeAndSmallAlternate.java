package org.java.arrays;

public class ArrangeLargeAndSmallAlternate {

	public static void main(String[] args) {

		int[] arr = {4, 5, 6, 2, 9, 8, 7, 10};
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		int[] arr3 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr4 = {11, 10, 9, 8, 7, 1, 2, 3, 4, 5, 6};
		arrange(arr);
		print(arr);
		arrange(arr2);
		print(arr2);
		arrange(arr3);
		print(arr3);
		arrange(arr4);
		print(arr4);
	}

	private static void arrange(int[] arr) {
		for(int i=1; i < arr.length; ++i) {
			if (i%2==0) {
				if (arr[i]<arr[i-1]) {
					swap(arr, i, i-1);
				}
			} else {
				if (arr[i]>arr[i-1]) {
					swap(arr, i, i-1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if (i == j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

}
