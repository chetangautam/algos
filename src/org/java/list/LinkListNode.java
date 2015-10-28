package org.java.list;

public class LinkListNode {
	public int data;
	public LinkListNode next;
	public LinkListNode previous;

	public LinkListNode(int num) {
		this.data = num;
		next = null;
		previous = null;
	}
}

