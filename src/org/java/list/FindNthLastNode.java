package org.java.list;

public class FindNthLastNode {

	public static class LinkedListNode {
		private int data;
		private LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}

		public LinkedListNode prePend(int data) {
			LinkedListNode prePender = new LinkedListNode(data);
			prePender.next = this;
			return prePender;
		}

		public int data() {
			return this.data;
		}

		public LinkedListNode next() {
			return this.next;
		}

		public boolean isLast() {
			return (this.next==null);
		}

	}

	public static void main(String[] args) {

		FindNthLastNode.LinkedListNode node = new FindNthLastNode.LinkedListNode(10);
		node = node.prePend(9);
		node = node.prePend(8);
		node = node.prePend(7);
		node = node.prePend(6);
		node = node.prePend(5);
		node = node.prePend(4);
		node = node.prePend(3);
		node = node.prePend(2);
		node = node.prePend(1);

		printList(node);
		for(int i=1; i<=10; ++i) {
			System.out.println(getNthlast(node, i).data());
		}
	}

	private static LinkedListNode getNthlast(LinkedListNode node, int num) {
		if (node == null || num < 1) {
			return null;
		}

		LinkedListNode cur = node;
		for(int i=0; i<num; ++i) {
			cur = cur.next();
		}
		while(cur!=null) {
			cur = cur.next();
			node = node.next();
		}
		return node;
	}

	private static void printList(LinkedListNode st) {
		while(st!=null) {
			System.out.print(st.data() + " ");
			st = st.next();
		}
		System.out.println();
	}

}
