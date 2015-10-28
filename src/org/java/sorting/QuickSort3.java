package org.java.sorting;

public class QuickSort3 {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int tot = in.nextInt();
		int[] arr = new int[tot];
		for (int i = 0; i < tot; ++i) {
			arr[i] = in.nextInt();
		}*/
		int[] arr = {1, 3, 9, 8, 2, 7, 5};
		sort(arr);
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			print(arr);
			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = high;
		int pivotValue = arr[pivot];
		high--;
		for (int index = low; index <= high; index++) {
			if (arr[low] < pivotValue) {
				low++;
			} else {
				for (int i = index + 1; i <= high; ++i) {
					if (arr[i] < pivotValue) {
						swap(arr, i, low);
						low++;
						break;
					}
				}
			}
		}
		swap(arr, low, pivot);
		return low;
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
