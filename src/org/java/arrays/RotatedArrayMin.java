package org.java.arrays;

public class RotatedArrayMin {

	public static void main(String[] args) {

		int [] arr = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		rotate(arr,4);
		minBinarySearch(arr, 0, arr.length-1);
		rotate(arr,2);
		minBinarySearch(arr, 0, arr.length-1);
		rotate(arr,5);
		minBinarySearch(arr, 0, arr.length-1);
		rotate(arr,3);
		minBinarySearch(arr, 0, arr.length-1);
		rotate(arr,8);
		minBinarySearch(arr, 0, arr.length-1);
		min(arr);
		int [] arr2 = {2,2,2,2,2,2,2};
		rotate(arr2,4);
		minBinarySearch(arr2, 0, arr2.length-1);
	}

	private static void minBinarySearch(int[] arr, int st, int end) {
		if (st==end) {
			System.out.println(arr[st]);
			return;
		}
		if (st+1==end) {
			System.out.println(Math.min(arr[st], arr[end]));
			return;
		}
		if (arr[st] <= arr[end]) {
			System.out.println(arr[st]);
			return;
		}
		int mid = (end-st)/2+st;
		if (arr[mid] <= arr[end]) {
			minBinarySearch(arr, st, mid);
			return;
		}
		minBinarySearch(arr, mid, end);
		return;

	}

	public static void min(int[] arr) {
		for(int i=1; i<arr.length; ++i) {
			if (arr[i]<arr[i-1]) {
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(arr[0]);
	}

	private static void rotate(int[] arr, int rotateCount) {
		reverse(arr, 0, arr.length-1-rotateCount);
		reverse(arr, arr.length-rotateCount, arr.length-1);
		reverse(arr, 0, arr.length-1);
	}

	private static void reverse(int[] arr, int st, int end) {
		if (st == end) {
			return;
		}
		if (st+1==end) {
			int temp = arr[st];
			arr[st] = arr[end];
			arr[end] = temp;
			return;
		}
		int mid = ((end+st)%2==1) ? (end+st)/2+1: (end+st)/2;
		for(int i=st; i<mid; i++) {
			int temp = arr[i];
			arr[i] = arr[end+st-i];
			arr[end+st-i] = temp;
		}
	}
}
