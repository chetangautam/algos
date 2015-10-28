package org.java.sorting;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = {45, 25, 46, 48, 28, 6, 13, 5, 36, 44, 7, 4, 11, 30, 24, 34, 15, 31, 38, 49};
		int[] arr1 = {4, 5, 3, 7, 2};
		int[] arr2 = {4, 3, 3, 1, 2};
		int[] arr3 = {5, 8, 1, 3, 7, 9, 2};

//		quicksort(arr);
//		print(arr);
//		quicksort(arr1);
//		print(arr1);
//		quicksort(arr2);
//		print(arr2);
		quicksort(arr3);
		print(arr3);
	}


	private static void quicksort(int[] arr) {
		quicksortHelper(arr, 0, arr.length-1);
	}


	private static void quicksortHelper(int[] arr, int i, int j) {
		if (i<j) {
			int pivot = partition(arr, i, j);
			quicksortHelper(arr, i, pivot-1);
			if (pivot-i>1) {
				for(int index=i;index<pivot;++index) {
					System.out.print(arr[index]);
					System.out.print(" ");
				}
				System.out.println();
			}
			quicksortHelper(arr, pivot+1, j);
			if (j-pivot>2) {
				for(int index=pivot+1;index<=j;++index) {
					System.out.print(arr[index]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

	private static int inOrderPartition(int[] arr, int low, int high) {
		int pivotValue=arr[low];
		int pivot=low;
		low++;
		while (low<high) {
			if (arr[low]<=pivotValue) {
				swap(arr, pivot, low);
				pivot = low;
				low++;
			} else {
				swap(arr, low, high);
				high--;
			}
		}
		return pivot;
	}

	private static int partition(int[] arr, int low, int high) {
		int pivotValue=arr[low];
		int pivot=low;
		low++;
		while(low<=high) {
			while(low<=high && arr[low]<pivotValue) {
				low++;
			}
			swap(arr, pivot, low-1);
			pivot = low-1;
			while(low<=high && arr[high]>pivotValue) {
				high--;
			}
			if(low>high) {
				break;
			}
			swap(arr, low, high);
			high--;
		}
		return pivot;
	}


	private static void swap(int[] arr, int i, int j) {
		if(i==j) {
			return;
		}
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
