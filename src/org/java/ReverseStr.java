package org.java;

public class ReverseStr {

	public static void main(String[] args) {
		System.out.println(reverse("Chocolate"));
	}

	public static String reverse(String str) {
		int len = str.length();
		if (len <= 1) return str;

		char[] arr = str.toCharArray();

		for (int i = 0; i < len/2; ++i) {
			char c = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = c;
		}
		return new String(arr);
	}

}

/*
String		index	length	Iterations	length/2
a			no		1		0			0
ab			0		2		1			1
abc			0		3		1			1
abcd		0,1		4		2			2
abcde		0,1		5		2			2
abcdef		0,1,2	6		3			3
abcdefg		0,1,2	7		3			3
*/
