package org.java.list;

public class PartitionList {

	public static class LinkListNode {
		public int data;
		public LinkListNode next;
		public LinkListNode previous;

		public LinkListNode(int num) {
			this.data = num;
			next = null;
			previous = null;
		}
	}

	LinkListNode head, last;
	int partitionValue;

	public PartitionList() {
		head = new LinkListNode(8);
		LinkListNode current = head;
		current.next = new LinkListNode(4);
		current.next.previous = current;
		current = current.next;
		current.next = new LinkListNode(3);
		current.next.previous = current;
		current = current.next;
		current.next = new LinkListNode(2);
		current.next.previous = current;
		current = current.next;
		current.next = new LinkListNode(6);
		current.next.previous = current;
		current = current.next;
		current.next = new LinkListNode(5);
		last = current.next;
		current.next.previous = current;
		partitionValue = 3;
	}

	public void partition() {
		if(null == head || head.next == null) {
			return;
		}
		LinkListNode prev = null;
		LinkListNode current = head;
		LinkListNode next = current.next;
		LinkListNode newListHead = null;
		LinkListNode newListCurr = null;
		while(current!=null) {
			next = current.next;
			if(current.data >= partitionValue) {
				if(current == head && current == last) {
					head = newListHead;
				} else if(current == head) {
					head = head.next;
					head.previous = null;
				} else if(current == last) {
					last = prev;
				} else {
					prev.next = current.next;
					next.previous = prev;
				}
				if(newListHead == null) {
					newListHead = current;
					current.next = null;
					current.previous = null;
					newListCurr = newListHead;
				} else {
					newListCurr.next = current;
					current.next = null;
					current.previous = newListCurr;
					newListCurr = current;
				}
			} else {
				prev = current;
			}
			current = next;
		}
		if(last != null) {
			last.next = newListHead;
			newListHead.previous = last;
			last = newListCurr;
		}
	}

	public void print() {
		LinkListNode curr = head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println("\n");
	}

	public void reversePrint() {
		LinkListNode curr = last;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.previous;
		}
		System.out.println("\n");
	}

	public static void main(String[] argv) {
		PartitionList pl = new PartitionList();
		pl.print();
		pl.reversePrint();
		pl.partition();
		pl.print();
		pl.reversePrint();
	}
}
