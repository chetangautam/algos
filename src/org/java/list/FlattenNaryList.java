package org.java.list;

public class FlattenNaryList {

	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		public LinkedListNode children;

		public LinkedListNode(int val) {
			this.data = val;
			this.next = null;
			this.children = null;
		}
	}

	public static void main(String[] args) {

		FlattenNaryList.LinkedListNode node1 = new FlattenNaryList.LinkedListNode(1);
		FlattenNaryList.LinkedListNode node2 = new FlattenNaryList.LinkedListNode(2);
		FlattenNaryList.LinkedListNode node3 = new FlattenNaryList.LinkedListNode(3);
		FlattenNaryList.LinkedListNode node4 = new FlattenNaryList.LinkedListNode(4);
		FlattenNaryList.LinkedListNode node5 = new FlattenNaryList.LinkedListNode(5);
		FlattenNaryList.LinkedListNode node6 = new FlattenNaryList.LinkedListNode(6);
		FlattenNaryList.LinkedListNode node7 = new FlattenNaryList.LinkedListNode(7);
		FlattenNaryList.LinkedListNode node8 = new FlattenNaryList.LinkedListNode(8);
		FlattenNaryList.LinkedListNode node9 = new FlattenNaryList.LinkedListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node5.next = node6;
		node8.next = node9;

		node1.children = node5;
		node3.children = node7;
		node6.children = node8;

		flattenList(node1);
		printList(node1);
	}

	private static void flattenList(LinkedListNode start) {

		LinkedListNode tail = getTail(start);

		while( start != null ) {
			if ( start.children !=null ) {
				tail = updateTail(start.children, tail);
			}
			start = start.next;
		}
	}

	private static LinkedListNode updateTail(LinkedListNode children, LinkedListNode tail) {
		tail.next = children;
		return getTail(tail);
	}

	private static LinkedListNode getTail(LinkedListNode start) {
		while ( start.next != null) {
			start = start.next;
		}
		return start;
	}

	private static void printList(LinkedListNode start) {
		while ( start != null ) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}

}
