package org.java.list;

public class LinkList {

	public class LinkListNode {
		public int data;
		public LinkListNode next;
		public LinkListNode previous;

		public LinkListNode(int num) {
			this.data = num;
			next = null;
			previous = null;
		}
	}

	private LinkListNode start = null;
	private LinkListNode last = null;

	public void add(int num) {
		LinkListNode node = new LinkListNode(num);
		if(start == null) {
			start = node;
			last = node;
		} else {
			last.next = node;
			node.previous = last;
			last = node;
		}
	}

	public void removeFirst() {
		if(start == null) {
			return;
		} else {
			if(start.next != null ) {
				start.next.previous = null;
			}
			start = start.next;
		}
	}

	public void removeLast() {
		if(last == null) {
			return;
		} else {
			last = last.previous;
			last.next = null;
		}
	}

	public void delete(int num) {
		LinkListNode foundNode = search(num);
		if(foundNode == start) {
			removeFirst();
		} else if (foundNode == last) {
			removeLast();
		} else if (foundNode != null) {
			LinkListNode prevNode = foundNode.previous;
			LinkListNode nextNode = foundNode.next;
			prevNode.next = nextNode;
			nextNode.previous = prevNode;
		}
	}

	public LinkListNode search(int num) {
		LinkListNode curr = start;
		while(curr != null) {
			if (curr.data == num) {
				return curr;
			} else {
				curr = curr.next;
			}
		}
		return curr;
	}

	public void print() {
		LinkListNode curr = start;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println("\n");
	}

	public void reverse() {
		if(start == null || start.next == null) {
			return;
		}
		LinkListNode curr = start;
		LinkListNode prevNode = null;
		LinkListNode nextNode = null;
		last = curr;
		while(curr != null) {
			nextNode = curr.next;
			curr.next = prevNode;
			curr.previous = nextNode;
			prevNode = curr;
			curr = nextNode;
		}
		start = prevNode;
	}

	/* 
	 * is currently not setting previous nodes
	 */
	public void reverseRec() {
		LinkListNode curr = start;
		if(curr==null || curr.next==null) {
			return;
		}
		start = recurReverse(curr);
	}


	private LinkListNode recurReverse(LinkListNode current) {

		if(current==null) {
			return current;
		}

		if(current.next==null) {
			last = current;
			return current;
		}

		LinkListNode secondElement = current.next;

		current.next = null;

		LinkListNode reverseRest = recurReverse(secondElement);

		current.previous = secondElement;
		secondElement.next = current;

		return reverseRest;

	}

	/* 
	 * O(n2) method
	 */
    static int LinkedListIntersection(LinkListNode inputList1, LinkListNode inputList2) {

        if (inputList1==null || inputList2==null) {
            return -1;
        }
        LinkListNode cur1 = inputList1.next;
        while(cur1 != null) {
        	LinkListNode cur2 = inputList2.next;
            while(cur2 != null) {
                if(cur1.data == cur2.data) {
                    return cur1.data;
                }
                cur2=cur2.next;
            }
            cur1=cur1.next;
        }
        return -1;
    }

    /*
     * O(N) method - 
     * calculate lengths
     * move difference of length in the bigger length list
     * then move each node in both and check if it is same or next is same.
     */
    static int LinkedListIntersectionFast(LinkListNode inputList1, LinkListNode inputList2) {
    	return 0;
    }

    public static void main(String[] args) {
		LinkList myList = new LinkList();
		LinkListNode head1 = myList.new LinkListNode(1);
		LinkListNode head2 = myList.new LinkListNode(8);
		
		LinkListNode a = myList.new LinkListNode(2);
		LinkListNode b = myList.new LinkListNode(3);
		
		LinkListNode c = myList.new LinkListNode(4);
		LinkListNode d = myList.new LinkListNode(5);
		
		LinkListNode e = myList.new LinkListNode(6);
		LinkListNode f = myList.new LinkListNode(7);
		
		head1.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		head2.next = e;
		e.next = f;
		f.next = c;
		System.out.println(LinkedListIntersection(head1, head2));

		// TODO - find error in below
		/*
		 * Link list creation, search, delete node, print
		 */
//		LinkList myList = new LinkList();
//		myList.add(1);
//		myList.add(2);
//		myList.add(3);
//		myList.add(4);
//		myList.add(5);
//		myList.print();
//		myList.reverse();
//		myList.print();
//		System.out.println("--");
//		myList.reverseRec();
//		myList.print();
//		System.out.println("--");
//
//		myList.delete(1);
//		myList.print();
//		myList.delete(5);
//		myList.print();
//		myList.delete(3);
//		myList.print();
//		myList.removeLast();
//		myList.print();
//		myList.removeFirst();
//		myList.print();
		System.out.println("----------------------");
		/*******************************************/

	}
}
