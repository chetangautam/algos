package org.java.list;

public class DutchFlagSort {


	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;

		public LinkedListNode(int val) {
			this.data = val;
			this.next = null;
		}		
	}

	public static void main(String[] args) {

		DutchFlagSort.LinkedListNode node1 = new DutchFlagSort.LinkedListNode(11);
		DutchFlagSort.LinkedListNode node2 = new DutchFlagSort.LinkedListNode(2);
		DutchFlagSort.LinkedListNode node3 = new DutchFlagSort.LinkedListNode(3);
		DutchFlagSort.LinkedListNode node4 = new DutchFlagSort.LinkedListNode(14);
		DutchFlagSort.LinkedListNode node5 = new DutchFlagSort.LinkedListNode(15);
		DutchFlagSort.LinkedListNode node6 = new DutchFlagSort.LinkedListNode(6);
		DutchFlagSort.LinkedListNode node7 = new DutchFlagSort.LinkedListNode(5);
		DutchFlagSort.LinkedListNode node8 = new DutchFlagSort.LinkedListNode(8);
		DutchFlagSort.LinkedListNode node9 = new DutchFlagSort.LinkedListNode(9);
		DutchFlagSort.LinkedListNode node10 = new DutchFlagSort.LinkedListNode(1);
		DutchFlagSort.LinkedListNode node11 = new DutchFlagSort.LinkedListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;

		print(node1);
		node1 = dutchSort(node1,5);
		print(node1);
	}

	private static LinkedListNode dutchSort(LinkedListNode head, int num) {
		if (head==null) {
			return null;
		}
		LinkedListNode tail = getLastNode(head);
		LinkedListNode loopEnder = tail;
		boolean loopEnderShifted = false;
		LinkedListNode prev = null;
		LinkedListNode cur = head;
		do {
			if (cur.data<num) {
				if (cur!=head) {
					prev.next = cur.next;
					cur.next = head;
					head = cur;
					// no change in prev
					cur = prev.next;
				} else {
					prev = cur;
					cur = cur.next;
				}
			} else if (cur.data>num) {
				if (!loopEnderShifted) {
					loopEnderShifted = true;
					loopEnder = cur;
				}
				LinkedListNode next = cur.next;
				if (cur!=head) {
					prev.next = next;
					cur.next = null;
					tail.next = cur;
					tail = cur;
					// no change in prev
					cur = next;
				} else if (cur!=tail){
					cur.next = null;
					tail.next = cur;
					tail = cur;
					cur = next;
					head = cur;
					prev = null;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}
		} while (cur!=loopEnder);
		return head;
	}

	private static LinkedListNode getLastNode(LinkedListNode start) {
		if (start==null) {
			return null;
		}
		while(start.next!=null) {
			start = start.next;
		}
		return start;
	}

	private static void print(LinkedListNode start) {
		while(start!=null) {
			System.out.print(start.data+" ");
			start = start.next;
		}
		System.out.println();
	}
}
