package org.java.arrays;

public class ArrayProduct {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		arrayProduct(arr);
		int[] arr2 = {1,2,3,4,0,6,0};
		arrayProduct(arr2);
	}

	private static void arrayProduct(int[] arr) {
		int[] products = new int[arr.length];
		int p = 1;
		for (int i=0; i<arr.length; ++i) {
			products[i] = p;
			p *= arr[i];
		}
		p = 1;
		for (int i=arr.length-1; i>=0; --i) {
			products[i] *= p;
			p *= arr[i];
		}
		for (int i : products) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
