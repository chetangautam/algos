package org.java.arrays;

public class ReadArraySpirally {

	public static void main(String[] args) {

		int[][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
			};
		readAndPrintSpirally(arr1);

		int[][] arr2 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
			};
		readAndPrintSpirally(arr2);

		int[][] arr3 = {
				{1,2,3,4,5,6,7},
				{8,9,10,11,12,13,14},
				{15,16,17,18,19,20,21},
				{22,23,24,25,26,27,28}
			};
		readAndPrintSpirally(arr3);

		int[][] arr4 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20},
				{21,22,23,24},
				{25,26,27,28}
			};
		readAndPrintSpirally(arr4);
	}

	private static void readAndPrintSpirally(int[][] arr) {

		int n = arr.length;
		int m = arr[0].length;

		int colStart = 0;
		int rowStart = 0;
		int colEnd = m-1;
		int rowEnd = n-1;
		

		while (rowStart<=rowEnd && colStart<=colEnd) {
			for (int i=rowStart, j=colStart; j<=colEnd; ++j) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			rowStart++;

			for (int i=rowStart, j=colEnd;i<=rowEnd; ++i) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			colEnd--;

			for (int i=rowEnd, j=colEnd;j>=colStart; --j) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			rowEnd--;

			for (int i=rowEnd, j=colStart;i>=rowStart; --i) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			colStart++;
		}
		System.out.println();
	}

}
