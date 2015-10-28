package org.java.recursion;

import java.util.ArrayList;
import java.util.Stack;

// TODO does not work for (()()) types

public class WellFormedBrackets {

	public static void main(String[] args) {

		String s = "((()))(()())(())()()";
		//String s = "(()())";
		ArrayList<String> wellFormedBrackets = wellformedBracket(s);
		for (String str : wellFormedBrackets) {
			System.out.println(str);
		}
	}

	private static ArrayList<String> wellformedBracket(String s) {
		ArrayList<String> wellFormedBrackets = new ArrayList<String>();
		Stack<Character> stack = new Stack<Character>();
		wellFormedBracketsHelper(s, stack, wellFormedBrackets, "");
		return wellFormedBrackets;
	}

	public static void wellFormedBracketsHelper(String str, Stack<Character> stack, ArrayList<String> wellFormedBrackets, String bracket) {
		if (str==null || str.length()==0) {
			wellFormedBrackets.add(bracket);
			return;
		}
		char c = str.charAt(0);
		if (c == '(') {
			if (bracket.length() != 0) {
				wellFormedBrackets.add(bracket);
				bracket = "";
			}
			stack.push(c);
			wellFormedBracketsHelper(str.substring(1), stack, wellFormedBrackets, bracket);
		} else if (c == ')') {
			if (stack.size() == 0) {
//				wellFormedBrackets.add(bracket);
				wellFormedBracketsHelper(str.substring(1), stack, wellFormedBrackets, "");
			} else {
				stack.pop();
				wellFormedBracketsHelper(str.substring(1), stack, wellFormedBrackets, "("+bracket+")");
			}
		}
	}
}
