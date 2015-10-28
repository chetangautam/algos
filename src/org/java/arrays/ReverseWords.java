package org.java.arrays;

public class ReverseWords {

	public static void main(String[] args) {
		
		String str = "  I  will  do it   ";
		System.out.println(reverseWords(str));
	}

	public static String reverseWords(String str) {
		
		String reversedWhole = reverseString(str);
		int st = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<str.length(); ++i) {
			if (reversedWhole.charAt(i)==' ') {
					String s = reverseString(reversedWhole.substring(st, i));
					sb.append(s).append(" ");
					st = i+1;
			}
		}
		String s = reverseString(reversedWhole.substring(st, reversedWhole.length()));
		sb.append(s);
		return sb.toString();

    }

	private static String reverseString(String str) {
		if (str.length()<=1) {
			return str;
		}
		if (str.length()==2) {
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(1)).append(str.charAt(0));
			return sb.toString();
		}
		char[] arr = str.toCharArray();
		int length = arr.length;
		if (length%2==0) {
			length = length/2;
		} else {
			length = (length/2)+1;
		}
		for (int i=0; i<length; ++i) {
			char c = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = c;
		}
		return new String(arr);
	}

}
