package org.java.list;

// comcast case number - cr512433537

public class CycleBeginningNode {

	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;

		public LinkedListNode(int val) {
			this.data = val;
			this.next = null;
		}		
	}

	public static void main(String[] args) {

		CycleBeginningNode.LinkedListNode node1 = new CycleBeginningNode.LinkedListNode(1);
		CycleBeginningNode.LinkedListNode node2 = new CycleBeginningNode.LinkedListNode(2);
		CycleBeginningNode.LinkedListNode node3 = new CycleBeginningNode.LinkedListNode(3);
		CycleBeginningNode.LinkedListNode node4 = new CycleBeginningNode.LinkedListNode(4);
		CycleBeginningNode.LinkedListNode node5 = new CycleBeginningNode.LinkedListNode(5);
		CycleBeginningNode.LinkedListNode node6 = new CycleBeginningNode.LinkedListNode(6);
		CycleBeginningNode.LinkedListNode node7 = new CycleBeginningNode.LinkedListNode(7);
		CycleBeginningNode.LinkedListNode node8 = new CycleBeginningNode.LinkedListNode(8);
		CycleBeginningNode.LinkedListNode node9 = new CycleBeginningNode.LinkedListNode(9);
		CycleBeginningNode.LinkedListNode node10 = new CycleBeginningNode.LinkedListNode(10);
		CycleBeginningNode.LinkedListNode node11 = new CycleBeginningNode.LinkedListNode(11);

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
		node11.next = node5; // creating cycle here

		printCycleBeginning(node1);
	}

	private static void printCycleBeginning(LinkedListNode node) {
		LinkedListNode cycleNode = hasCycle(node);
		int loopLenth = getLoopLength(cycleNode);
		System.out.println(getCycleBeginning(node, loopLenth).data);
	}

	private static LinkedListNode hasCycle(LinkedListNode node) {

		LinkedListNode fast = node.next;
		LinkedListNode slow = node;

		while( fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

	private static int getLoopLength(LinkedListNode cycleNode) {
		if (cycleNode == null) {
			return 0;
		}
		LinkedListNode save = cycleNode;
		int length = 1;
		while(cycleNode.next != save) {
			length++;
			cycleNode = cycleNode.next;
		}
		return length;
	}

	private static LinkedListNode getCycleBeginning(LinkedListNode start, int loopLength) {
		LinkedListNode cur = start;
		for(int i=0; i<loopLength; ++i) {
			cur = cur.next;
		}
		while(start != cur) {
			start = start.next;
			cur = cur.next;
		}
		return start;
	}
}
