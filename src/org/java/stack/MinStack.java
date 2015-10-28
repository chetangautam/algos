package org.java.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int num) {
		stack.push(num);
		if (minStack.size()>0) {
			int top = minStack.peek();
			if(num < top) {
				minStack.push(num);
			} else {
				minStack.push(top);
			}
		} else {
			minStack.push(num);
		}
	}

	public int min() throws NoSuchElementException {
		if (minStack.size()==0) {
			throw new NoSuchElementException();
		}
		return minStack.peek();
	}

	public int pop() {
		if (stack.size()==0) {
			throw new NoSuchElementException();
		}
		minStack.pop();
		return stack.pop();
	}

	public static void main(String[] args) {

		int[] nums = {4,7,1,3,2,0,-2,5};

		MinStack minSt = new MinStack();

		for(int i: nums) {
			minSt.push(i);
			System.out.println(minSt.min());
		}

		System.out.println();

		for (int i=0; i<nums.length-1; ++i) {
			minSt.pop();
			System.out.println(minSt.min());
		}
	}

}
