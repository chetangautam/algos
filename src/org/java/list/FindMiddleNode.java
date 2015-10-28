package org.java.list;

public class FindMiddleNode {

    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {

		LinkedListNode head = new FindMiddleNode.LinkedListNode(8);
		LinkedListNode a = new FindMiddleNode.LinkedListNode(11);
		LinkedListNode b = new FindMiddleNode.LinkedListNode(4);
		LinkedListNode c = new FindMiddleNode.LinkedListNode(6);
		LinkedListNode d = new FindMiddleNode.LinkedListNode(7);
		LinkedListNode e = new FindMiddleNode.LinkedListNode(1);
		LinkedListNode f = new FindMiddleNode.LinkedListNode(-99);
		LinkedListNode g = new FindMiddleNode.LinkedListNode(-0);
		LinkedListNode h = new FindMiddleNode.LinkedListNode(2);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		System.out.println(findMiddleNode(head).val);
	}

    static LinkedListNode findMiddleNode(LinkedListNode pList) {
        if (pList==null || pList.next==null) {
            return pList;
        }
        LinkedListNode slow = pList;
        LinkedListNode fast = pList.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null) {
            slow.next.next = null;
            return slow.next;
        } else {
            slow.next = null;
            return slow;
        }
    }

}
