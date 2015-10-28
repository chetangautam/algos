package org.java;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tot = in.nextInt();
		for (int i = 0; i < tot; ++i) {
			int n = in.nextInt();
			flip1(n);
			flip2(n);
			flip3(n);
			System.out.println("====");			
		}
		in.close();
	}

	public static void flip1(int n) {
		char[] arr = new char[32];
		for (int k = 0; k < 32; ++k)
			arr[k] = '1';

		String s = Integer.toBinaryString(n);
		char[] arr1 = s.toCharArray();

		for (int j = arr1.length - 1, k = 31; k >= 0; --j, --k) {
			if (j >= 0) {
				if (arr1[j] == '0') {
					arr[k] = '1';
				} else {
					arr[k] = '0';
				}
			}
		}

		String s1 = new String(arr);
		System.out.println(Long.valueOf(s1, 2));
	}

	public static void flip2(int n) {
		long val = (long)Integer.MAX_VALUE - (long)n;
		System.out.println(val);
	}

	public static void flip3(long n) {
		System.out.println(4294967295l-n);
	}
}


