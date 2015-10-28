package org.java;

public class SkipCharInStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missingCharBetter("hello", 3));

	}

	public static String missingChar(String str, int n) {
		int len = str.length();
		if (n == 0) {
			return str.substring(1, len);
		} else if (n == len - 1) {
			return str.substring(0, len - 1);
		} else {
			return (str.substring(0, n) + str.substring(n + 1, len));
		}
	}

	public static String missingCharBetter(String str, int n) {
		String str1 = "Hello";
		String str2 = str1.substring(0,0);
		System.out.println(str2);

		String front = str.substring(0, n);

		// Start this substring at n+1 to omit the char.
		// Can also be shortened to just str.substring(n+1)
		// which goes through the end of the string.
		String back = str.substring(n + 1, str.length());

		return front + back;
	}

}
