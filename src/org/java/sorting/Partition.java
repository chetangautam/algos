package org.java.sorting;

public class Partition {

	public static void main(String[] args) {
		lomuto();
		hoare();
	}


	public static void lomuto() {
		int[] arr = {45, 25, 46, 48, 28, 6, 13, 5, 36, 44, 7, 4, 11, 30, 24, 34, 15, 31, 38, 49};
		int[] arr1 = {4, 5, 3, 7, 2};
		int[] arr2 = {4, 3, 3, 1, 2};
		int[] arr3 = {5, 8, 1, 3, 7, 9, 2};
		int[] arr4 = {3, 2, 4, 7, 5};
		int[] arr5 = {3, 2};
		lomutoPartitionAndPrint(arr);
		lomutoPartitionAndPrint(arr1);
		lomutoPartitionAndPrint(arr2);
		lomutoPartitionAndPrint(arr3);
		lomutoPartitionAndPrint(arr4);
		lomutoPartitionAndPrint(arr5);
	}


	public static void hoare() {
		int[] arr = {45, 25, 46, 48, 28, 6, 13, 5, 36, 44, 7, 4, 11, 30, 24, 34, 15, 31, 38, 49};
		int[] arr1 = {4, 5, 3, 7, 2};
		int[] arr2 = {4, 3, 3, 1, 2};
		int[] arr3 = {5, 8, 1, 3, 7, 9, 2};
		int[] arr4 = {3, 2, 4, 7, 5};
		int[] arr5 = {3, 2};
		hoarePartitionAndPrint(arr);
		hoarePartitionAndPrint(arr1);
		hoarePartitionAndPrint(arr2);
		hoarePartitionAndPrint(arr3);
		hoarePartitionAndPrint(arr4);
		hoarePartitionAndPrint(arr5);
	}

	
	private static void hoarePartitionAndPrint(int[] arr) {
		hoarePartition(arr, 0, arr.length-1);
		print(arr);
	}

	
	private static void lomutoPartitionAndPrint(int[] arr) {
		lomutoPartition(arr, 0, arr.length-1);
		print(arr);
	}

	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	/*
	 * wiki function does not work.
	 */
	private static int partitionWiki(int[] arr, int low, int high) {
		int pivot = low;
		int pivotValue = arr[pivot];

		int i = low -1;
		int j = high + 1;

		while(true) {
			do {
				++i;
			} while(arr[i]<pivotValue);
			do {
				--j;
			} while(arr[j]>pivotValue);
			if (i<j) {
				swap(arr, i, j);
			} else {
				return j;
			}
		}
	}

	
	private static int lomutoPartition(int[] arr, int low, int high) {
		int pivotValue=arr[low];
		int pivot=low;
		low++;
		while (low<=high) {
			if (arr[low]<=pivotValue) {
				swap(arr, pivot, low);
				pivot++;
				low++;
			} else {
				swap(arr, low, high);
				high--;
			}
		}
		return pivot;
	}


	private static int hoarePartition(int[] arr, int low, int high) {
		int pivot = low;
		int pivotValue = arr[pivot];
		low++;

		while(low <= high) {

			while (low<=high && arr[low]<pivotValue) {
				low++;
			}
			swap(arr, pivot, low-1);
			pivot = low-1;

			while (low<=high && arr[high]>pivotValue) {
				high--;
			}
			if (low>high) {
				break;
			}
			swap(arr, low, high);
			high--;
		}
		return pivot;
	}

	private static void swap(int[] arr, int i, int j) {
		if(i == j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
