package org.java.arrays;

public class Create2DArraySpirally {

	public static void main(String[] args) {
		System.out.println(createSprialMatrix(5));
	}

	public static int[][] createSprialMatrix(int n)
			throws IllegalArgumentException {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		int[][] arr = new int[n][n];

		int i, j, colCtr, rowCtr, num = 0;

		for (i = 0, j = n; j > 0 && i < j; --j, ++i) {

			rowCtr = i;
			for (colCtr = i; colCtr < j; ++colCtr) {
				arr[rowCtr][colCtr] = num++;
			}
			--colCtr;

			for (rowCtr++; rowCtr < j; ++rowCtr) {
				arr[rowCtr][colCtr] = num++;
			}
			--rowCtr;

			for (--colCtr; colCtr >= i; --colCtr) {
				arr[rowCtr][colCtr] = num++;
			}
			++colCtr;

			for (--rowCtr; rowCtr > n - j; --rowCtr) {
				arr[rowCtr][colCtr] = num++;
			}
		}

		return arr;
	}

}
