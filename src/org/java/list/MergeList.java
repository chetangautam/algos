package org.java.list;

// TODO - check if this program works for all cases.
public class MergeList {
	public static class Node {
		public int data;
		public Node next;

	}

	Node MergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
	    if(null == headB) {
	        return headA;
	    } else if (null == headA) {
	        return headB;
	    }
	    Node a = headA, b = headB, cur= null;
	    while (a!=null && b!=null) {
	        if (a.data<=b.data) {
	            if (cur!=null) {
	                cur.next = a;
	            }
	            cur = a;
	            a = a.next;
	        } else {
	            Node bNext = b.next;
	            if (cur==null) {
	                b.next = a;
	            } else {
	                cur.next = b;
	            }
	            cur = b;
	            b = bNext;
	        }
	    }
	    if(a==null && b!=null) {
	        cur.next = b;
	    } else if (a!=null && b==null) {
	        cur.next = a;
	    }
	    if(headA.data<=headB.data) {
	        return headA;
	    } else {
	        return headB;
	    }

	}

}
