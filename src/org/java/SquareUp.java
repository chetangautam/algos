package org.java;

public class SquareUp {

	public static void main(String[] args) {
		System.out.println(squareUp2(3));
	}

	public static int[] squareUp(int n) {
		int[] arr = new int[n * n];
		if (n == 0)
			return arr;
		int s = 0;
		for (int i = 0; i < n;) {
			s++;
			int a = 1;
			for (int j = n - 1; j >= 0; --j) {
				arr[(i * n) + j] = (a <= s) ? a : 0;
				a++;
			}
			i++;
		}
		return arr;
	}

	public static int[] squareUp2(int n) {
		int[] arr = new int[n * n];
		if (n == 0)
			return arr;
		int s = 0;
		for (int i = 0; i < n;) {
			s++;
			int a = s;
			for (int j = 0; j < n; ++j) {
				if ((n - j) > s) {
					arr[(i * n) + j] = 0;
				} else {
					arr[(i * n) + j] = a;
					a--;
				}
			}
			i++;
		}
		return arr;
	}

}
