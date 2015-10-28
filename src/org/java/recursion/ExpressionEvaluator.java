package org.java.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {

	public static void main(String[] args) {

		String str = "222";
		int target = 24;
		String[] answers = expressionEval(str, target);
		for(String s: answers) {
			System.out.println(s);
		}
	}

	private static String[] expressionEval(String str, int target) {
		List<String> ans = new ArrayList<String>();
		exprEvalHelper(str, str.length()-1, ans, "");
		List<String> retVal = new ArrayList<String>();
		for(int i=0; i<ans.size(); ++i) {
			if (target == eval(ans.get(i))) {
				retVal.add(ans.get(i));
			}
		}
        String[] expression = new String[retVal.size()];
        int i=0;
        for(String s: retVal) {
            expression[i]=s;
            ++i;
        }
		return expression;
	}

	private static int eval(String string) {
		Stack<Integer> stack = new Stack<Integer>();
		String s = "";
		boolean isPrevMultiply = false;
		for(int i=0; i<string.length(); ++i) {
			if( string.charAt(i)=='*') {
				if(stack.size()==0) {
					stack.push(Integer.valueOf(s));
				} else {
					pushInStack(stack, s, isPrevMultiply);
				}
				isPrevMultiply = true;
				s="";
			} else if (string.charAt(i) == '+') {
				pushInStack(stack, s, isPrevMultiply);
				isPrevMultiply = false;
				s="";
			} else {
				s+=string.charAt(i);
			}
		}
		pushInStack(stack, s, isPrevMultiply);
		return getTotalFromStack(stack);
	}

	private static void pushInStack(Stack<Integer> stack, String s,
			boolean isPrevMultiply) {
		if (isPrevMultiply) {
			handleMultiply(stack, s);
		} else {
			stack.push(Integer.valueOf(s));
		}
	}

	private static int getTotalFromStack(Stack<Integer> stack) {
		int result = 0;
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	private static void handleMultiply(Stack<Integer> stack, String s) {
		int num = stack.pop();
		num *= Integer.valueOf(s);
		stack.push(num);
	}

	private static void exprEvalHelper(String str,  int i, List<String> ans, String s) {
		if(i<0) {
			ans.add(s);
			return;
		}
		if (s.length()==0) {
			String s1 = str.charAt(i) + s;
			exprEvalHelper(str, i-1, ans, s1);
		} else {
			String s1 = str.charAt(i) + s;
			String s2 = str.charAt(i)+ "*" + s;
			String s3 = str.charAt(i)+ "+" + s;
			exprEvalHelper(str, i-1, ans, s1);
			exprEvalHelper(str, i-1, ans, s2);
			exprEvalHelper(str, i-1, ans, s3);
		}
		
	}

}
