package org.java.list;


/*
 * Zips the list from 2 ends
 * 
 * e.g.
 * 		Input:  1->2->3->4->5->6
 * 		Output: 1->6->2->5->3->4
 * 
 */
public class ZipList {

    public class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

	public static void main(String[] args) {

		ZipList zListObj = new ZipList();

		LinkedListNode head = zListObj.new LinkedListNode(1);
		LinkedListNode two = zListObj.new LinkedListNode(2);
		LinkedListNode three = zListObj.new LinkedListNode(3);
		LinkedListNode four = zListObj.new LinkedListNode(4);
		LinkedListNode five = zListObj.new LinkedListNode(5);
		LinkedListNode six = zListObj.new LinkedListNode(6);
		LinkedListNode seven = zListObj.new LinkedListNode(7);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		print(head);
		System.out.println("---");
		print(Zip(head));
		System.out.println("---");
	}

    private static void print(LinkedListNode head) {
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}		
	}

	public static LinkedListNode Zip(LinkedListNode pList) {
		if (pList==null || pList.next==null) {
			return pList;
		}
		LinkedListNode halfHead = splitInHalf(pList);
		halfHead = reverseList(halfHead);
		pList = unsortedMerge(pList, halfHead);
		return pList;
    }

	private static LinkedListNode unsortedMerge(LinkedListNode l1, LinkedListNode l2) {
		if (l2==null) {
			return l1;
		}
		if (l1==null) {
			return l2;
		}
		LinkedListNode cur1 = l1, cur2 = l2;
		while(cur1 != null && cur2 != null) {
			LinkedListNode next1 = cur1.next;
			LinkedListNode next2 = cur2.next;
			cur1.next = cur2;
			cur1 = next1;
			if (cur1 != null) {
				cur2.next = cur1;				
			} else {
				cur2.next = next2;
			}
			cur2 = next2;
		}
		return l1;
	}

	private static LinkedListNode reverseList(LinkedListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		LinkedListNode cur = head;
		LinkedListNode next = cur.next;
		while(next!=null) {
			LinkedListNode secondNext = next.next;
			next.next = cur;
			cur = next;
			next = secondNext;
		}
		head.next = null;
		return cur;
	}

	private static LinkedListNode splitInHalf(LinkedListNode pList) {
		LinkedListNode slow = pList;
		LinkedListNode fast = pList.next;
		while (fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedListNode retVal = slow.next;
		slow.next = null;
		return retVal;
	}

}
