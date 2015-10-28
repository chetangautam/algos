package org.java.list;

public class SwapKthNode {

    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {

		LinkedListNode head = new SwapKthNode.LinkedListNode(11);
		LinkedListNode a = new SwapKthNode.LinkedListNode(2);
		LinkedListNode b = new SwapKthNode.LinkedListNode(4);
		LinkedListNode c = new SwapKthNode.LinkedListNode(1);
		LinkedListNode d = new SwapKthNode.LinkedListNode(7);
		LinkedListNode e = new SwapKthNode.LinkedListNode(1);
		LinkedListNode f = new SwapKthNode.LinkedListNode(-99);
		LinkedListNode g = new SwapKthNode.LinkedListNode(-0);
		LinkedListNode h = new SwapKthNode.LinkedListNode(2);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;

		print(head);
		head = swap(head, 3);
		print(head);
		head = swap(head, 3);
		print(head);
		head = swap(head, 4);
		print(head);
		head = swap(head, 5);
		print(head);
		head = swap(head, 1);
		print(head);

	}

	private static LinkedListNode swap(LinkedListNode head, int i) {
		if(head==null || head.next==null || i==0) {
			return head;
		}
		LinkedListNode left = head;
		LinkedListNode prevLeft = null;
		for(int j=1;j<i;++j) {
			prevLeft = left;
			left = left.next;
			if (left == null) {
				return head;
			}
		}
		LinkedListNode cur = left.next;
		LinkedListNode prevRight = null;
		LinkedListNode right = head;
		while(cur!=null) {
			prevRight = right;
			right = right.next;
			cur=cur.next;
		}
		return swap(head, prevLeft, left, prevRight, right);		
	}

	private static LinkedListNode swap(LinkedListNode head,
			LinkedListNode prevLeft, LinkedListNode left,
			LinkedListNode prevRight, LinkedListNode right) {

		if (left==right) {
			return head;
		}

		if (left==head && left==prevRight) {
			// just 2 nodes
			left.next = null;
			right.next = left;
			return right;
		}

		if (right==head && right==prevLeft) {
			// just 2 nodes
			left.next = right;
			right.next = null;
			return right;
		}

		if (left==head) {
			// swap first with last
			right.next = left.next;
			left.next = null;
			prevRight.next = left;
			return right;
		}

		if (right==head) {
			// swap first with last
			left.next = right.next;
			right.next = null;
			prevLeft.next = right;
			return left;
		}

		if (left==prevRight) {
			prevLeft.next = right;
			left.next = right.next;
			right.next = left;
			return head;
		}

		if (right==prevLeft) {
			prevRight.next = left;
			right.next = left.next;
			left.next = right;
			return head;
		}

		prevLeft.next = right;
		prevRight.next = left;
		LinkedListNode save = left.next;
		left.next = right.next;
		right.next = save;

		return head;

//		prevRight.next = left;
//		left.next = right.next;
//		right.next = save;
//		if (prevLeft != null) {
//			prevLeft.next = right;
//			return head;
//		} else {
//			return right;
//		}
	}

	private static void print(LinkedListNode head) {
    	while(head != null) {
    		System.out.print(head.val);
    		System.out.print(" ");
    		head = head.next;
    	}
    	System.out.println();
	}

}
