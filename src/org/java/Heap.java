package org.java;

public class Heap {

	public static void main(String[] args) {

		int[] arr = {3, 5, 6, 2, 9, 7, 3, 4, 8, 1};
		minHeapify(arr);
		System.out.println(getMin(arr));
		maxHeapify(arr);
		System.out.println(getMax(arr));
	
	}

	private static void maxHeapify(int[] arr) {
		for(int i=0, twiceI = 2*i; twiceI+1<arr.length; ++i, twiceI = 2*i) {
			if(arr[i] <= arr[twiceI+1]) {
				if(twiceI+2<arr.length) {
					if(arr[twiceI+1] >= arr[twiceI+2]) {
						swapAndAdjust(arr, i, twiceI+1, false);
					} else {
						swapAndAdjust(arr, i, twiceI+2, false);
					}
				} else {
					swapAndAdjust(arr, i, twiceI+1, false);
				}
			} else if (twiceI+2<arr.length && arr[i] < arr[twiceI+2]) {
				if(arr[twiceI+1] >= arr[twiceI+2]) {
					swapAndAdjust(arr, i, twiceI+1, false);
				} else {
					swapAndAdjust(arr, i, twiceI+2, false);
				}
			}
		}
	}

	private static int getMax(int[] arr) {
		return arr[0];
	}

	private static int getMin(int[] arr) {
		return arr[0];
	}

	private static void minHeapify(int[] arr) {
		for(int i=0, twiceI = 2*i; twiceI+1<arr.length; ++i, twiceI = 2*i) {
			if(arr[i] > arr[twiceI+1]) {
				if(twiceI+2<arr.length) {
					if(arr[twiceI+1] <= arr[twiceI+2]) {
						swapAndAdjust(arr, i, twiceI+1, true);
					} else {
						swapAndAdjust(arr, i, twiceI+2, true);
					}
				} else {
					swapAndAdjust(arr, i, twiceI+1, true);
				}
			} else if (twiceI+2<arr.length && arr[i] > arr[twiceI+2]) {
				if(arr[twiceI+1] <= arr[twiceI+2]) {
					swapAndAdjust(arr, i, twiceI+1, true);
				} else {
					swapAndAdjust(arr, i, twiceI+2, true);
				}
			}
		}
	}

	private static void swapAndAdjust(int[] arr, int i, int twiceI, boolean forMinHeap) {
		swap(arr, i, twiceI);
		adjust(arr, i, forMinHeap);
	}

	private static void adjust(int[] arr, int i, boolean forMinHeap) {
		if(i<=0) {
			return;
		}
		if(forMinHeap) {
			if (arr[i]<=arr[i/2]) {
				swap(arr, i, i/2);
				adjust(arr, i/2, true);
			}
		} else {
			if (arr[i]>=arr[i/2]) {
				swap(arr, i, i/2);
				adjust(arr, i/2, false);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		assert(i>=0 && i<arr.length);
		assert(i>=0 && j<arr.length);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
