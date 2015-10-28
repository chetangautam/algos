package org.java;


public class Palindrome {

	// Never a foot too far, even. -> yes
	// test -> no
	// a -> yes
	// racecar -> yes
	public static void main(String[] args) {

		String str = "Never a foot too far, even.";
		System.out.println(isPalindrome(str));
	}

	static boolean isPalindrome(String strInput) {

		if (strInput == null) {
			return false;
		}
		if (strInput.length() == 0 || strInput.length() == 1) {
			return true;
		}
		if (!Character.isLetter((strInput.charAt(0)))) {
			return isPalindrome(strInput.substring(1));
		}
		if (!Character.isLetter(strInput.charAt(strInput.length() - 1))) {
			return isPalindrome(strInput.substring(0, strInput.length() - 1));
		}
		if (Character.toLowerCase(strInput.charAt(0)) == Character
				.toLowerCase(strInput.charAt(strInput.length() - 1))) {
			return isPalindrome(strInput.substring(1, strInput.length() - 1));
		} else {
			return false;
		}

	}
}
