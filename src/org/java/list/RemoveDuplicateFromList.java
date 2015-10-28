package org.java.list;

import java.util.HashMap;

public class RemoveDuplicateFromList {

    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {

		LinkedListNode head = new RemoveDuplicateFromList.LinkedListNode(8);
		LinkedListNode a = new RemoveDuplicateFromList.LinkedListNode(11);
		LinkedListNode b = new RemoveDuplicateFromList.LinkedListNode(4);
		LinkedListNode c = new RemoveDuplicateFromList.LinkedListNode(6);
		LinkedListNode d = new RemoveDuplicateFromList.LinkedListNode(7);
		LinkedListNode e = new RemoveDuplicateFromList.LinkedListNode(7);
		LinkedListNode f = new RemoveDuplicateFromList.LinkedListNode(-99);
		LinkedListNode g = new RemoveDuplicateFromList.LinkedListNode(0);
		LinkedListNode h = new RemoveDuplicateFromList.LinkedListNode(8);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;

		removeDuplicate(head);
		print(head);
	}
	
    private static void removeDuplicate(LinkedListNode head) {
    	if (head ==null || head.next == null) {
    		return;
    	}
    	HashMap<Integer, LinkedListNode> hm = new HashMap<Integer, LinkedListNode>();
    	LinkedListNode cur = head;
    	LinkedListNode prev = null;
    	while(cur!=null) {
    		LinkedListNode temp = hm.get(cur.val);
    		if (temp == null) {
    			hm.put(cur.val, cur);
    			prev = cur;
    			cur = cur.next;
    		} else {
    			if (cur.next==null) {
    				prev.next = null;
    			} else {
    				prev.next = cur.next;
    			}
				cur = cur.next;
    		}
    	}
	}

	private static void print(LinkedListNode head) {
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
	}


}
