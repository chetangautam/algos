package org.java.sorting;


public class InsertionSort {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int N = in.nextInt();
//		int[] ar = new int[N];
//		for (int i = 0; i < N; ++i) {
//			ar[i] = in.nextInt();
//		}
//		in.close();
		int[] ar = {4, 8, 1, 3, 5, 3, 2, 6, 0};
		insertionSort(ar);
		for (int i : ar) {
			System.out.println(i);
		}
	}

	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = value;
		}
	}

}
