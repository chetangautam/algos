package org.java;

import java.util.Stack;

public class ReversePolish {

	private String[] problem = null;
	private String operators = "+*-/";
	private Stack<Double> stack = null;

	public ReversePolish() {
		problem = new String[] {"2", "1", "+", "3", "*", "10", "/"};
		stack = new Stack<Double>();
	}

	public Double getResult() {
		for(String token: problem) {
			if(!operators.contains(token)) {
				stack.push(Double.valueOf(token));
			} else {
				Double numA = stack.pop();
				Double numB = stack.pop();
				switch (token.charAt(0)) {
					case '+':
					{
						stack.push(numB+numA);
						break;
					}
					case '-':
					{
						stack.push(numB-numA);
						break;
					}
					case '*':
					{
						stack.push(numB*numA);
						break;
					}
					case '/':
					{
						stack.push(numB/numA);
						break;
					}
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		/*
		 * reverse polish notation
		 */
		ReversePolish rP = new ReversePolish();
		System.out.println(rP.getResult());
		System.out.println("----------------------");
		/*******************************************/
	}
}
