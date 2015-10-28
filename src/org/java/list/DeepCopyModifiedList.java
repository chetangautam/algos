package org.java.list;

import java.util.HashMap;

public class DeepCopyModifiedList {

	public static void main(String[] args) {

		ModifiedLinkListNode root = new ModifiedLinkListNode(1);
		ModifiedLinkListNode two = new ModifiedLinkListNode(2);
		ModifiedLinkListNode three = new ModifiedLinkListNode(3);
		ModifiedLinkListNode four = new ModifiedLinkListNode(4);
		ModifiedLinkListNode five = new ModifiedLinkListNode(5);
		ModifiedLinkListNode six = new ModifiedLinkListNode(6);
		ModifiedLinkListNode seven = new ModifiedLinkListNode(7);

		root.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		two.left = four;
		four.left = seven;
		five.left = six;

		System.out.println("Printing the original list");
		print(root);
		ModifiedLinkListNode newRoot = deepCopy(root);
		System.out.println("Printing the deep copied list");
		print(newRoot);
		System.out.println("Are the two lists equal: " + isEqual(root, newRoot));

	}

	private static ModifiedLinkListNode deepCopy(ModifiedLinkListNode root) {
		ModifiedLinkListNode current = root;
		ModifiedLinkListNode newRoot = null;
		ModifiedLinkListNode newListCurrent = null;

		HashMap<ModifiedLinkListNode, ModifiedLinkListNode> hm = 
				new HashMap<ModifiedLinkListNode, ModifiedLinkListNode>();

		while(current!= null) {
			if(newRoot == null) {
				newRoot = createNode(current, hm);
				newListCurrent = newRoot;
			} else {
				newListCurrent.next = createNode(current, hm);
				newListCurrent = (ModifiedLinkListNode) newListCurrent.next;
			}
			current = (ModifiedLinkListNode) current.next;
		}
		return newRoot;
	}

	private static ModifiedLinkListNode createNode(ModifiedLinkListNode nodeToBeCopied,
			HashMap<ModifiedLinkListNode, ModifiedLinkListNode> hm) {
		ModifiedLinkListNode nodeCreated = new ModifiedLinkListNode(nodeToBeCopied.data);
		if(nodeToBeCopied.left != null) {
			hm.put((ModifiedLinkListNode) nodeToBeCopied.left, nodeCreated);
		}
		ModifiedLinkListNode nodeHavingLeft = hm.get(nodeToBeCopied);
		if(nodeHavingLeft != null) {
			nodeHavingLeft.left = nodeCreated;
		}
		return nodeCreated;
	}

	public static void print(ModifiedLinkListNode root) {
		ModifiedLinkListNode current = root;
		while(current != null) {
			System.out.print(current.data);
			System.out.print(" ");
			current = (ModifiedLinkListNode) current.next;
		}
		System.out.println("");
	}

	public static boolean isEqual(ModifiedLinkListNode root1, ModifiedLinkListNode root2) {
		ModifiedLinkListNode cur1 = root1;
		ModifiedLinkListNode cur2 = root2;
		while(cur1!= null && cur2!=null) {
			if(cur1.data!=cur2.data) {
				return false;
			}
			if(
					(cur1.left == null && cur2.left != null) || 
					(cur1.left != null && cur2.left == null)
			) {
				return false;
			}
			if( cur1.left!= null) {
				if(cur1.left.data != cur2.left.data) {
					return false;
				}
			}
			cur1 = (ModifiedLinkListNode) cur1.next;
			cur2 = (ModifiedLinkListNode) cur2.next;
		}
		return true;
	}
}
