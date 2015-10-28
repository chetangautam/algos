package org.java.list;

public class AlternativeNodeSplit {

    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {

		LinkedListNode head = new AlternativeNodeSplit.LinkedListNode(8);
		LinkedListNode a = new AlternativeNodeSplit.LinkedListNode(11);
		LinkedListNode b = new AlternativeNodeSplit.LinkedListNode(4);
		LinkedListNode c = new AlternativeNodeSplit.LinkedListNode(6);
		LinkedListNode d = new AlternativeNodeSplit.LinkedListNode(7);
		LinkedListNode e = new AlternativeNodeSplit.LinkedListNode(1);
		LinkedListNode f = new AlternativeNodeSplit.LinkedListNode(-99);
		LinkedListNode g = new AlternativeNodeSplit.LinkedListNode(-0);
		LinkedListNode h = new AlternativeNodeSplit.LinkedListNode(2);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;

		print(head);
		System.out.println("---");
		alternativeNodeSplit(head);
	}

    private static void alternativeNodeSplit(LinkedListNode head) {
    	if (head == null) {
    		return;
    	}
    	if (head.next == null) {
    		System.out.println(head.val);
    	}
    	LinkedListNode l1 = head;
    	LinkedListNode l2 = head.next;
    	LinkedListNode cur1 = l1;
    	LinkedListNode cur2 = l2;
    	LinkedListNode cur = cur2;
    	int i=0;
    	cur = cur.next;
    	while (cur!=null) {
    		if (i%2==0) {
        		cur1.next = cur;
        		cur1 = cur;
    		} else {
    			cur2.next = cur;
    			cur2 = cur;
    		}
    		cur = cur.next;
    		++i;
    	}
    	cur1.next = null;
    	cur2.next = null;
    	print(l1);
    	System.out.println("-----");
    	print(l2);
    	System.out.println("-----");
	}

	private static void print(LinkedListNode head) {
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
	}


}
