package org.java;

public class StackNode {

	public int data;
	public StackNode previous;
	public StackNode next;

	public StackNode(int n) {
		this.data = n;
		this.previous = null;
		this.next = null;
	}

}
