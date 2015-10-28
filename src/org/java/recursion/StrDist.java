package org.java.recursion;

public class StrDist {

	public static void main(String[] args) {

		System.out.println(strDist("catcowcat", "cat") );
		System.out.println(strDist("xyx", "x") );
		System.out.println(strDist("xyx", "y") );
		System.out.println(strDist("xyx", "z") );
		System.out.println(strDist("z", "z") );
		System.out.println(strDist("x", "z") );
	}

	public static int strDist(String str, String sub) {
		int first = findFirst(str, sub, 0);
		int last = findLast(str, sub, str.length() - sub.length());
		return last - first;
	}

	public static int findFirst(String str, String sub, int i) {
		if (str == null || str.length() == 0 || i >= str.length()) {
			return -1;
		}
		if (str.substring(i, i+sub.length()).equals(sub)) {
			return i;
		} else {
			return findFirst(str, sub, i + 1);
		}
	}

	public static int findLast(String str, String sub, int i) {
		if (str == null || str.length() == 0 || i < 0) {
			return -1;
		}
		if (str.substring(i, i+sub.length()).equals(sub)) {
			return i + sub.length();
		} else {
			return findLast(str, sub, i - 1);
		}
	}

}
