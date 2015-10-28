package org.java.list;


public class MergeSortList {

    public class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {
		MergeSortList mergeSortObj = new MergeSortList();

		LinkedListNode head = mergeSortObj.new LinkedListNode(8);

		LinkedListNode a = mergeSortObj.new LinkedListNode(11);
		LinkedListNode b = mergeSortObj.new LinkedListNode(4);
		LinkedListNode c = mergeSortObj.new LinkedListNode(6);
		LinkedListNode d = mergeSortObj.new LinkedListNode(7);
		LinkedListNode e = mergeSortObj.new LinkedListNode(1);
		LinkedListNode f = mergeSortObj.new LinkedListNode(-99);
		LinkedListNode g = mergeSortObj.new LinkedListNode(-0);
		LinkedListNode h = mergeSortObj.new LinkedListNode(2);
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
		print(mergeSortList(head));
		System.out.println("---");
		// useless below statement
		tail(head);
	}

    private static void print(LinkedListNode head) {
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
	}

    private static LinkedListNode mid(LinkedListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	LinkedListNode slow = head;
    	LinkedListNode fast = head.next;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }

    private static LinkedListNode tail(LinkedListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	while(head.next!=null) {
    		head = head.next;
    	}
    	return head;
    }

    private static LinkedListNode mergeSortList(LinkedListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	LinkedListNode mid = mid(head);
    	LinkedListNode midNext = mid.next;
    	terminateListFromNode(mid);
    	LinkedListNode h1 = mergeSortList(head);
    	LinkedListNode h2 = mergeSortList(midNext);
    	return merge(h1, h2);
    }

    private static void terminateListFromNode(LinkedListNode node) {
    	if(node!=null) {
    		node.next = null;
    	}
	}

	private static LinkedListNode merge(LinkedListNode h1, LinkedListNode h2) {

		if (h1 == null) {
			return h2;
		} else if (h2 == null) {
			return h1;
		}

		if (h1.val > h2.val) {
			LinkedListNode temp = h1;
			h1 = h2;
			h2 = temp;
		}

		LinkedListNode cur1 = h1;
    	LinkedListNode cur2 = h2;
    	LinkedListNode prev1 = null;
    	LinkedListNode prev2 = null;
		LinkedListNode next1 = null;
		LinkedListNode next2 = null;
    	
    	while(cur1 != null && cur2 != null) {
    		next1 = cur1.next;
    		next2 = cur2.next;
    		if (cur1.val < cur2.val) {
    			if(null != prev1) {
    				prev1.next = cur1;
    			}
        		prev1 = cur1;
    			cur1 = next1;
    		} else {
    			prev1.next = cur2;
    			prev1 = cur2;
        		prev2 = cur2;
    			cur2 = next2;
    		}
    	}

		if (cur1 == null && cur2 != null) {
			prev1.next = cur2;
		} else if (cur1 != null && cur2 == null) {
			prev2.next = cur1;
		}
    	return h1;
    }
}
