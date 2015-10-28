package org.java;

import java.util.Scanner;

public class NutsBolts {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		String nutsInp = in.next();
		String boltsInp = in.next();
		String[] nuts = nutsInp.split(",");
		String[] bolts = boltsInp.split(",");
		in.close();
		assert (nuts.length == bolts.length);
		quickSort(nuts, bolts, 0, nuts.length-1);
		for (int i = 0; i < nuts.length; ++i) {
			System.out.println(nuts[i] + bolts[i]);
		}
	}

	public static void quickSort(String[] n, String[] b, int low, int high) {
		if (low < high) {
			int pivot = getPivot(n, b, low, high);
			quickSort(n, b, 0, pivot - 1);
			quickSort(n, b, pivot + 1, high);
		}
	}

	public static int getPivot(String[] n, String[] b, int low, int high) {
		int pivot = low;
		int i = 0;
		int saveHigh = high;
		while (i <= high) {
			if (Integer.valueOf(b[pivot].substring(1)) >= Integer.valueOf(n[i].substring(1))) {
				swap(n, i, pivot);
				pivot = i;
				++i;
			} else if (Integer.valueOf(b[pivot].substring(1)) < Integer.valueOf(n[high].substring(1))) {
				--high;
			} else {
				swap(n, i, high);
			}
		}
		i = 0;
		high = saveHigh;
		while(i <= high) {
			if (Integer.valueOf(n[pivot].substring(1)) >= Integer.valueOf(b[i].substring(1))) {
				swap(b, i, pivot);
				pivot = i;
				++i;
			} else if (Integer.valueOf(n[pivot].substring(1)) < Integer.valueOf(b[high].substring(1))) {
				--high;
			} else {
				swap(b, i, high);
			}
		}
		return pivot;
	}

	public static void swap(String[] arr, int i, int j) {
		String temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
