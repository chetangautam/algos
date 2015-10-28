package org.java.recursion;

public class ChangeXY {

	public static void main(String[] args) {
		System.out.println(changeXY("codxex"));
	}

	public static String changeXY(String str) {
		if (str.length() == 0)
			return "";
		char c = str.charAt(str.length() - 1);
		if (c == 'x') {
			return changeXY(str.substring(0, str.length()-1)) + "y";
		} else {
			return changeXY(str.substring(0, str.length()-1)) + String.valueOf(c);
		}
	}

}
