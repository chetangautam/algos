package org.java.arrays;

public class TwoDimArraySearch {

	public static void main(String[] args) {
		int[][] mat = {
				{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		search(mat, 29);
		search(mat, 45);
		search(mat, 49);
		search(mat, 27);
	}

	private static void search(int[][] arr, int num) {
		int n = arr.length;
		int m = arr[0].length;

		int i = 0, j = m-1;

		while( i>=0 && i<n && j>=0 && j<m) {
			if (num == arr[i][j]) {
				System.out.println(num + " found at " + i + "," + j);
				return;
			} else if (num > arr[i][j]) {
				++i;
			} else {
				--j;
			}
		}
		System.out.println("Not found!");
	}

}
