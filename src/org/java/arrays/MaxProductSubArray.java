package org.java.arrays;

public class MaxProductSubArray {

	public static void main(String[] args) {

		int[] arr = {(-2), 1, (-3), 4, (-1), 2, 0, 1, (-5), 4};
		int[] arr2 = {(-2), (-3), (-4), (-1), (-5)};
		int[] arr3 = {(-2), (-3), (-4), 0, (-1),  (-8)};
		int[] arr4 = {6, (-3), 10, 4, 1, 0, 2};
		
		System.out.println(getMaxProductSubArray(arr));
		print(getMaxProductSubArrayIndeces(arr));

		System.out.println(getMaxProductSubArray(arr2));
		print(getMaxProductSubArrayIndeces(arr2));

		System.out.println(getMaxProductSubArray(arr3));
		print(getMaxProductSubArrayIndeces(arr3));

		System.out.println(getMaxProductSubArray(arr4));
		print(getMaxProductSubArrayIndeces(arr4));
	}

	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	private static int getMaxProductSubArray(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		int candidate1Product = 0;
		int candidate2Product = 0;
		boolean isNegativeSeenBefore = false;
		for(int i=0; i<arr.length; ++i) {
			if (arr[i] == 0) {
				candidate1Product = 0;
				candidate2Product = 0;
				isNegativeSeenBefore = false;
				continue;
			}
			if (isNegativeSeenBefore && candidate2Product == 0) {
				candidate2Product = 1;
			}
			if (arr[i] < 0) {
				isNegativeSeenBefore = true;
			}
			if (candidate1Product == 0) {
				candidate1Product = 1;
			}

			candidate1Product *= arr[i];
			candidate2Product *= arr[i];

			maxProduct = Math.max(maxProduct, candidate1Product);
			maxProduct = Math.max(maxProduct, candidate2Product);
		}
		return maxProduct;
	}

	private static int[] getMaxProductSubArrayIndeces(int[] arr) {
		int[] indecesMaxProductSubArray = new int[2];
		int maxProduct = Integer.MIN_VALUE;
		int candidate1BeginIndex = 0;
		int candidate2BeginIndex = 0;
		int candidate1Product = 0;
		int candidate2Product = 0;
		boolean isNegativeSeenBefore = false;

		for(int i=0; i<arr.length; ++i) {
			if (arr[i] == 0) {
				candidate1Product = 0;
				candidate2Product = 0;
				isNegativeSeenBefore = false;
				continue;
			}
			if (isNegativeSeenBefore && candidate2Product == 0) {
				candidate2Product = 1;
				candidate2BeginIndex = i;
			}
			if (arr[i] < 0) {
				isNegativeSeenBefore = true;
			}
			if (candidate1Product == 0) {
				candidate1Product = 1;
				candidate1BeginIndex = i;
			}

			candidate1Product *= arr[i];
			candidate2Product *= arr[i];

			if (candidate1Product >= maxProduct) {
				indecesMaxProductSubArray[0] = candidate1BeginIndex;
				indecesMaxProductSubArray[1] = i;
				maxProduct = candidate1Product;
			} else if (candidate2Product >= maxProduct) {
				indecesMaxProductSubArray[0] = candidate2BeginIndex;
				indecesMaxProductSubArray[1] = i;
				maxProduct = candidate2Product;
			}

		}
		return indecesMaxProductSubArray;
	}

}
