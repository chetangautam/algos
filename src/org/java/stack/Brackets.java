package org.java.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/*
Input
-----
({}[])
(({()})))
({(){}()})()({(){}()})(){()}
{}()))(()()({}}{}
}}}}
))))
{{{
(((
[]{}(){()}((())){{{}}}{()()}{{}{}}
[[]][][]

Output
------
true
false
true
false
false
false
false
false
true
true
 */
public class Brackets {

	public static void main(String[] args) {
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(
					System.in));
			List<String> input = new ArrayList<String>();
			String str = is.readLine();
			while (str != null) {
				input.add(str);
				str = is.readLine();
			}
			List<Boolean> output = new ArrayList<Boolean>();
			for (String s : input) {
				if (s.length() == 0) {
					output.add(true);
				} else {
					output.add(process(s));
				}
			}
			for (Boolean b : output) {
				System.out.println(b);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean process(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i <s.length(); ++i) {
			if(s.charAt(i)== '(') {
				stack.push('(');
			} else if (s.charAt(i)== '{') {
				stack.push('{');
			} else if (s.charAt(i)== '[') {
				stack.push('[');
			} else if (s.charAt(i)== ')') {
				if(stack.size()==0) return false;
				Character c = stack.peek();
				if (c != '(') return false;
				stack.pop();
			} else if (s.charAt(i)== '}') {
				if(stack.size()==0) return false;
				Character c = stack.peek();
				if (c != '{') return false;
				stack.pop();
			} else if (s.charAt(i)== ']') {
				if(stack.size()==0) return false;
				Character c = stack.peek();
				if (c != '[') return false;
				stack.pop();
			}
		}
		if (stack.size() != 0)
			return false;
		else
			return true;
	}

}
