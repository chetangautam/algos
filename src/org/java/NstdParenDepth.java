package org.java;

public class NstdParenDepth {

	public static void main(String[] args) {
		System.out.println(nestedParenthesisDepth("abc(123(xyz))m(((n)))o("));
	}

	/**
	 * Count the maximum depth of parenthesis nesting, i.e.
	 * "abc(123(xyz))m(((n)))o" -> 3.
	 *
	 * @param input
	 *            any string
	 * @return deepest parenthesization level
	 * @throws IllegalArgumentException
	 *             if input is null or contains a mismatch "a)b(c" or "a(b"
	 */
	public static int nestedParenthesisDepth(String input)
			throws IllegalArgumentException {

		if (null == input) {
			throw new IllegalArgumentException();
		}

		int len = input.length();
		int maxDepth = 0, currentDepth = 0;
		int openParens = 0;
		for (int i = 0; i < len; ++i) {
			if (input.charAt(i) == '(') {
				openParens++;
				currentDepth++;
			} else if (input.charAt(i) == ')') {
				openParens--;
				maxDepth = Math.max(maxDepth, currentDepth);
				currentDepth = 0;
			}
			if (openParens < 0) {
				throw new IllegalArgumentException();
			}
		}
		if(openParens!=0) {
			throw new IllegalArgumentException();
		}
		return maxDepth;
	}
}
