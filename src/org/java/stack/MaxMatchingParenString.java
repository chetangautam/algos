package org.java.stack;

import java.util.Stack;

/*
assert maxLenMatchingParen("()")==2);
assert maxLenMatchingParen("((())") == 4);
assert maxLenMatchingParen("()(())") == 4);
assert maxLenMatchingParen("(((((")==0);
assert maxLenMatchingParen(")))")==0);
assert maxLenMatchingParen("())")==2);
assert maxLenMatchingParen("(()")==2);
assert maxLenMatchingParen("((((())(((()")==4);

 */
public class MaxMatchingParenString {

	public static void main(String[] args) {

		System.out.println(longestValidParentheses("(()))()"));

		assert maxLenMatchingParen("()") == 2;
		assert maxLenMatchingParen("((())") == 4;
		assert maxLenMatchingParen("()(())") == 8;
		assert maxLenMatchingParen("(((((")==0;
		assert maxLenMatchingParen(")))")==0;
		assert maxLenMatchingParen("())")==2;
		assert maxLenMatchingParen("(()")==2;
		assert maxLenMatchingParen("((((())(((()")==4;
		assert maxLenMatchingParen("()()()")==2;
		assert maxLenMatchingParen("((((())(((()")==4;
		assert maxLenMatchingParen("")==0;
	}

    static int maxLenMatchingParen(String str) {

        Stack<Character> stack = new Stack<Character>();
        int finalTotal = 0;
        int total = 0;
        for(int i=0; i<str.length(); ++i) {
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                total = 0;
            } else if(str.charAt(i) == ')') {
                if (stack.size()>0) {
                    total+=2;
                    finalTotal = Math.max(finalTotal, total);
                    stack.pop();
                } else {
                    total = 0;
                }
            }
        }
        return finalTotal;
    }

	public static int longestValidParentheses(String s) {
		int maxLen = 0, last = -1;
		Stack<Integer> lefts = new Stack<Integer>();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				lefts.push(i);
			} else {
				if (lefts.isEmpty()) {
					// no matching left
					last = i;
				} else {
					// find a matching pair
					lefts.pop();
					if (lefts.isEmpty()) {
						maxLen = Math.max(maxLen, i - last);
					} else {
						maxLen = Math.max(maxLen, i - lefts.peek());
					}
				}
			}
		}
		return maxLen;
	}
}
