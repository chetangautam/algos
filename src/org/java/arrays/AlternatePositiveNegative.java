package org.java.arrays;

public class AlternatePositiveNegative {

	public static void main(String[] args) {

		int [] arr = {2, 3, (-4), (-9), (-1), (-7), 1, (-5), (-6)};
		int [] arr2 = {2, 3, 9, 1, (-4), (-9), (-1), (-7), (-5), (-6)};

		alternatePosNeg(arr);
		print(arr);

		alternatePosNeg(arr2);
		print(arr2);

	}

	public static void print(int[] arr) {
		for(int i: arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}


	public static void alternatePosNeg(int[] arr) {
		if (null==arr|| arr.length<=1) {
			return;
		}

		boolean canProgress = true;

		for (int i =0; i<arr.length-1 && canProgress; ++i) {

			int j=i+1;

			if (i%2==0) {
				if (arr[i] >= 0) {
					continue;
				} else {
					for (; j<arr.length && canProgress; ++j) {
						if (arr[j] >= 0) {
							swap(arr, i, j);
							break;
						}
					}
				}
			} else {
				if (arr[i] < 0) {
					continue;
				} else {
					for (; j<arr.length && canProgress; ++j) {
						if (arr[j] < 0) {
							swap(arr, i, j);
							break;
						}
					}
				}
			}

			if (j==arr.length) {
				canProgress = false;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if (i==j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
