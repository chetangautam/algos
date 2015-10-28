package org.java;

public class Stack {

	public static class StackNode {

		public int data;
		public StackNode previous;
		public StackNode next;

		public StackNode(int n) {
			this.data = n;
			this.previous = null;
			this.next = null;
		}

	}

	private StackNode start = null;
	private StackNode last = null;

	public void push(StackNode node) {
		if (node == null) {
			return;
		} else {
			if(start == null) {
				start = node;
				last = node;
			} else {
				last.next = node;
				node.previous = last;
				last = node;
			}
		}
	}

	public StackNode pop(){
		if(last == null) {
			return null;
		} else {
			StackNode saveLast = last;
			last = last.previous;
			if(last == null) {
				start = null;
			}
			return saveLast;
		}
	}

	public static void main(String[] args) {
		/*
		 * Stack
		 */
		int[] arr = {8,7,6,5,4,3,2,1};
		Stack stack = new Stack();
		for (int i = 0; i< arr.length; ++i) {
			StackNode node = new StackNode(arr[i]);
			stack.push(node);
		}
		StackNode node = stack.pop();
		while(node != null) {
			System.out.print(node.data);
			node = stack.pop();
		}
		System.out.println("----------------------");
	}
}
