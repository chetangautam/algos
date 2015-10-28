package org.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BSTree {

	public static class BinarySearchTreeNode {

		public int data;
		public BinarySearchTreeNode left;
		public BinarySearchTreeNode right;

		public BinarySearchTreeNode(int n) {
			this.data = n;
			this.left = null;
			this.right = null;
		}

	}

	public BinarySearchTreeNode start;


	public void add(int n) {
		if(this.start == null) {
			BinarySearchTreeNode node = new BinarySearchTreeNode(n);
			this.start = node;
			return;
		} else {
			addToTree(start, n);
		}
	}


	public void addToTree(BinarySearchTreeNode st, int n) {
		if(st.data > n) {
			if(st.left == null) {
				BinarySearchTreeNode node = new BinarySearchTreeNode(n);
				st.left = node;	
			} else {
				addToTree(st.left, n);
			}
		} else {
			if(st.right == null) {
				BinarySearchTreeNode node = new BinarySearchTreeNode(n);
				st.right = node;
			} else {
				addToTree(st.right, n);
			}
		}
	}


	public void preOrder(BinarySearchTreeNode start) {
		if(start==null) {
			return;
		} else {
			System.out.print(start.data);
			System.out.print(" ");
			preOrder(start.left);
			preOrder(start.right);
		}
	}


	public void postOrder(BinarySearchTreeNode start) {
		if(start==null) {
			return;
		} else {
			postOrder(start.left);
			postOrder(start.right);
			System.out.print(start.data);
			System.out.print(" ");
		}
	}


	public void postOrderWithOutRecursion(BinarySearchTreeNode start) {
		
		// left, right, root

		class Node {
			BinarySearchTreeNode bstNode;
			boolean isLeftTraveresed;
			boolean isRightTraveresed;

			public Node(BinarySearchTreeNode bstNode) {
				this.bstNode = bstNode;
				this.isLeftTraveresed = false;
				this.isRightTraveresed = false;
			}
		}

		Stack<Node> stack = new Stack<Node>();

		if (null==start) {
			return;
		}

		BinarySearchTreeNode cur = start;
		stack.add(new Node(cur));
		while(stack.size()>0) {
			
			if (!stack.peek().isLeftTraveresed) {
				Node node = stack.pop();
				node.isLeftTraveresed = true;
				stack.push(node);
				cur = node.bstNode.left;
				if (null != cur) {
					stack.push(new Node(cur));
				}
			} else if (!stack.peek().isRightTraveresed) {
				Node node = stack.pop();
				node.isRightTraveresed = true;
				stack.push(node);
				cur = node.bstNode.right;
				if (null != cur) {
					stack.push(new Node(cur));
				}
			} else {
				Node node = stack.pop();
				System.out.print(node.bstNode.data + " ");
			}
		}
	}


	public void revInOrder(BinarySearchTreeNode start) {
		if(start==null) {
			return;
		} else {
			revInOrder(start.right);
			System.out.print(start.data);
			System.out.print(" ");
			revInOrder(start.left);
		}
	}


	public void inOrder(BinarySearchTreeNode start) {
		if(start==null) {
			return;
		} else {
			inOrder(start.left);
			System.out.print(start.data);
			System.out.print(" ");
			inOrder(start.right);
		}
	}

	public void inOrderWithoutRecursion(BinarySearchTreeNode start) {
		if (start== null) {
			return;
		}

		class Node {
			BinarySearchTreeNode bstNode;
			boolean isLeftTraversed;

			public Node(BinarySearchTreeNode bst) {
				this.bstNode = bst;
				this.isLeftTraversed = false;
			}
		}
		Stack<Node> stack = new Stack<Node>();

		BinarySearchTreeNode cur = start;
		stack.push(new Node(cur));

		while(stack.size()>0) {
			Node node = stack.pop();
			if (node.isLeftTraversed) {
				System.out.print(node.bstNode.data + " ");
				if (node.bstNode.right!=null) {
					stack.push(new Node(node.bstNode.right));
				}
			} else {
				node.isLeftTraversed = true;
				stack.push(node);
				if (node.bstNode.left!=null) {
					stack.push(new Node(node.bstNode.left));
				}
			}
		}
	}


	public void getNth(int n) {
		if (start == null) {
			System.out.println("Empty tree!");
		} else {
			getNthInternal(start,0,n);
		}
	}


	public void getNthInternal(BinarySearchTreeNode start, int ctr, int n) {
		if(start==null) {
			return;
		} else {
			getNthInternal(start.left,ctr+1,n);
			if (ctr==n) {
				System.out.print(start.data);
				System.out.print(" ");
				return;
			}
			getNthInternal(start.right,ctr+1,n);
		}
	}


	private List<Integer> listOfPathToNode(int num) {
		List<Integer> list = new ArrayList<Integer>();
		BinarySearchTreeNode current = start;
		boolean nodeFound = false;
		while(current!=null) {
			list.add(current.data);
			if (current.data > num) {
				current = current.left;
			} else if (current.data < num) {
				current = current.right;
			} else {
				nodeFound = true;
				break;
			}
		}
		if(nodeFound == false) {
			list.clear();
		}
		return list;
	}


	private int lastSameElementIndex(List<Integer> l1, List<Integer> l2) {
		if(l1 == null || l2 == null || l1.size() == 0 || l2.size() == 0) {
			return -1;
		}
		int i = -1;
		while(i < l1.size() && i < l2.size()) {
			++i;
			if(l1.get(i)!=l2.get(i)) {
				break;
			}
		}
		--i;
		if(l1.get(i)!=l2.get(i)) {
			return -1;
		} else {
			return i;
		}
	}


	public int leastCommonRoot(int num1, int num2) {
		List<Integer> num1Path = listOfPathToNode(num1);
		if (num1Path.size() == 0) {
			return -1;
		}
		List<Integer> num2Path = listOfPathToNode(num2);
		if (num2Path.size() == 0) {
			return -1;
		}
		int i = lastSameElementIndex(num1Path, num2Path);
		if(i==-1) {
			return i;
		} else {
			return num1Path.get(i);
		}
	}


	public int pathBetween(int num1, int num2) {
		List<Integer> num1Path = listOfPathToNode(num1);
		if (num1Path.size() == 0) {
			return -1;
		}
		List<Integer> num2Path = listOfPathToNode(num2);
		if (num2Path.size() == 0) {
			return -1;
		}
		int i = lastSameElementIndex(num1Path, num2Path);
		if(i==-1) {
			return i;
		} else {
			return num1Path.size() + num2Path.size() - (2 * (i+1));
		}
	}


	public BinarySearchTreeNode search(int num) {
		BinarySearchTreeNode node = null;
		BinarySearchTreeNode current = start;
		while(current != null) {
			if(current.data == num) {
				node = current;
				break;
			} else if (current.data > num) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return node;
	}


	public void levelOrder(BinarySearchTreeNode start) {
		if(start !=null) {			
			Queue<BinarySearchTreeNode> que = new LinkedList<BinarySearchTreeNode>();
			que.add(start);
			BinarySearchTreeNode node = que.poll();
			while(node != null) {
				System.out.print(node.data);
				System.out.print(" ");
				if(node.left != null) {
					que.add(node.left);
				}
				if(node.right != null) {
					que.add(node.right);
				}
				node = que.poll();
			}
		} else {
			System.out.println("Empty tree!");
		}
	}


	public void printAllPaths(BinarySearchTreeNode start) {
		//printAllPathsHelper(start, "");
		List<Integer> list = new ArrayList<Integer>();
		printAllPathsHelper2(start, list);
	}

	private void printAllPathsHelper(BinarySearchTreeNode start, String list) {
		list = list + " " + start.data;
		if (start.left==null && start.right==null) {
			System.out.println(list);
			return;
		}
		if (start.left != null) {
			printAllPathsHelper(start.left, list);
		}
		if (start.right != null) {
			printAllPathsHelper(start.right, list);
		}
	}


	private void printAllPathsHelper2(BinarySearchTreeNode start, List<Integer> list) {
		list.add(start.data);
		if (start.left==null && start.right==null) {
			printList(list);
			removeLastFromStack(list);
			return;
		}
		if (start.left != null) {
			printAllPathsHelper2(start.left, list);
		}
		if (start.right != null) {
			printAllPathsHelper2(start.right, list);
		}
		removeLastFromStack(list);
	}


	private void removeLastFromStack(List<Integer> list) {
		if (list.size() > 0) {
			list.remove(list.size()-1);
		}
	}


	private void printList(List<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		/*
		 * Binary Search Tree
		 */
		BSTree tree = new BSTree();
		tree.add(9); tree.add(7); tree.add(8); tree.add(5); tree.add(3); tree.add(4);
		tree.add(12); tree.add(14); tree.add(10); tree.add(13); tree.add(11);
		tree.inOrder(tree.start);
		System.out.println("---~~~~~~~");
		tree.inOrderWithoutRecursion(tree.start);
		System.out.println("---");
		tree.revInOrder(tree.start);
		System.out.println("---");
		tree.preOrder(tree.start);
		System.out.println("---");
		tree.postOrder(tree.start);
		System.out.println("---");
		tree.levelOrder(tree.start);
		System.out.println("---");
		tree.getNth(0);
		System.out.println("---");
		System.out.println(tree.search(20));
		System.out.println("---");
		System.out.println(tree.leastCommonRoot(13, 4));
		System.out.println("---");
		System.out.println(tree.pathBetween(13, 4));
		System.out.println("----------------------");
		System.out.println(isBST(tree.start));
		System.out.println("~~~~");
		tree.postOrder(tree.start);
		System.out.println("~~~~");
		tree.postOrderWithOutRecursion(tree.start);
		System.out.println("~~~~");
		tree.printAllPaths(tree.start);
		System.out.println("---");
		System.out.println(lca(tree.start, 3, 4).data);
		BinarySearchTreeNode newRoot = clone(tree.start);
		tree.inOrder(newRoot);
		System.out.println("~~~");
		BinarySearchTreeNode copiedTree=copyTree(tree.start);
		tree.inOrder(copiedTree);
		System.out.println("~~~");
		System.out.println("~~~~~~~~~~~~~");
		printDLL(convertInDLL(newRoot));
		System.out.println("~~~~~~~~~~~~~");
		deleteNodesOfTree(tree, copiedTree);
	}


	private static void deleteNodesOfTree(BSTree tree, BinarySearchTreeNode copiedTree) {
		copiedTree = BSTree.deleteNode(copiedTree, 14);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 10);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 7);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 12);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 9);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 5);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 11);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 4);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 8);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 13);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 3);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
		copiedTree = BSTree.deleteNode(copiedTree, 3);
		tree.inOrder(copiedTree);
		System.out.println("~~~~~~~~~~~~~");
	}


	public static void printDLL(BinarySearchTreeNode root) {
		BinarySearchTreeNode cur = root;
		BinarySearchTreeNode prev = null;
		do {
			System.out.print(cur.data+" ");
			prev = cur;
			cur = cur.right;
		} while (cur != root);
		System.out.println();
		do {
			System.out.print(prev.data+" ");
			cur = prev;
			prev = prev.left;
		} while (cur != root);
		System.out.println();
	}


	public static BinarySearchTreeNode convertInDLL(BinarySearchTreeNode root) {
		if (root== null) {
			return null;
		}

		class Node {
			BinarySearchTreeNode bstNode;
			boolean isLeftTraversed;

			public Node(BinarySearchTreeNode bst) {
				this.bstNode = bst;
				this.isLeftTraversed = false;
			}
		}
		Stack<Node> stack = new Stack<Node>();

		BinarySearchTreeNode cur = null, head = null, prev = null;;
		stack.push(new Node(root));

		while(stack.size()>0) {
			Node node = stack.pop();
			if (node.isLeftTraversed) {
				if (null == head) {
					head = node.bstNode;
				}
				prev = cur;
				cur = node.bstNode;
				joinNodes(prev, cur);
				if (node.bstNode.right!=null) {
					stack.push(new Node(node.bstNode.right));
				}
			} else {
				node.isLeftTraversed = true;
				stack.push(node);
				if (node.bstNode.left!=null) {
					stack.push(new Node(node.bstNode.left));
				}
			}
		}
		joinNodes(cur, head);
		return head;
	}


	private static void joinNodes(BinarySearchTreeNode prev, BinarySearchTreeNode next) {
		if (prev != null) {
			prev.right = next;
		}
		if (next != null) {
			next.left = prev;
		}
	}


	public static boolean isBST(BinarySearchTreeNode root) {
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	private static boolean isBSTHelper(BinarySearchTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data < max && root.data > min) {
			return isBSTHelper(root.left, min, root.data) && isBSTHelper(root.right, root.data, max);
		} else {
			return false;
		}
	}


	public static BinarySearchTreeNode lca(BinarySearchTreeNode root, int n1, int n2) {
		List<BinarySearchTreeNode> l1 = getPath(root, n1);
		List<BinarySearchTreeNode> l2 = getPath(root, n2);
		int lenL1 = l1.size();
		int lenL2 = l2.size();
		
		int i = 0;
		for (i=0; i<Math.min(lenL2, lenL1); ++i) {
			if (l1.get(i).data != l2.get(i).data) {
				return l1.get(i-1);
			}
		}
		// same path child-parent case
		return l1.get(i-1);
	}


	private static List<BinarySearchTreeNode> getPath(BinarySearchTreeNode root, int n) {
		List<BinarySearchTreeNode> list = new ArrayList<BinarySearchTreeNode>();
		while(root.data != n) {
			list.add(root);
			if (root.data>n) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		list.add(root);
		return list;
	}


	public static BinarySearchTreeNode clone(BinarySearchTreeNode root) {
		BinarySearchTreeNode newRoot = new BinarySearchTreeNode(root.data);
		cloneHelper(root, newRoot);
		return newRoot;
	}


	private static void cloneHelper(BinarySearchTreeNode root, BinarySearchTreeNode newRoot) {
		if (root.left !=null) {
			BinarySearchTreeNode newLeft = new BinarySearchTreeNode(root.left.data);
			newRoot.left = newLeft;
			cloneHelper(root.left, newRoot.left);
		}
		if (root.right !=null) {
			BinarySearchTreeNode newRight = new BinarySearchTreeNode(root.right.data);
			newRoot.right = newRight;
			cloneHelper(root.right, newRoot.right);
		}
	}

	public static BinarySearchTreeNode copyTree(BinarySearchTreeNode root) {
		BinarySearchTreeNode newNode = null;
		if (root != null) {
			newNode = new BinarySearchTreeNode(root.data);
			newNode.left = copyTree(root.left);
			newNode.right = copyTree(root.right);
		}
		return newNode;
	}

	public static BinarySearchTreeNode deleteNode(BinarySearchTreeNode root, int num) {
		if (root == null) {
			return root;
		}
		boolean found = false;
		BinarySearchTreeNode cur = root, prev = null;
		while(!found) {
			if (cur.data == num) {
				found = true;
				break;
			} else if (cur.data < num) {
				prev = cur;
				cur = cur.right;
			} else {
				prev = cur;
				cur = cur.left;
			}
		}

		if (cur.left == null && cur.right == null ) {
			if (cur == root) {
				return null;
			} else {
				deleteCurWithNoChildren(cur, prev);
				return root;
			}
		} else if (cur.left == null && cur.right != null) {
			if (cur == root) {
				return cur.right;
			} else {
				deleteCurWithRightChild(cur, prev);
				return root;
			}
		} else if (cur.left != null && cur.right == null) {
			if (cur == root) {
				return cur.left;
			} else {
				deleteCurWithLeftChild(cur, prev);
				return root;
			}
		} else {
			BinarySearchTreeNode highestFromLeftTree = getHighestFromLeftTree(cur.left);
			cur.data = highestFromLeftTree.data;
			if (cur.left.data == highestFromLeftTree.data) {
				cur.left =  highestFromLeftTree.left;
			} else {
				deleteNode(cur.left, highestFromLeftTree.data);
			}
			return root;
		}
	}


	private static void deleteCurWithNoChildren(BinarySearchTreeNode cur, BinarySearchTreeNode prev) {
		if (prev.right == cur) {
			prev.right = null;
		} else {
			prev.left = null;
		}
	}


	private static void deleteCurWithRightChild(BinarySearchTreeNode cur, BinarySearchTreeNode prev) {
		if (prev.right == cur) {
			prev.right = cur.right;
		} else {
			prev.left = cur.right;
		}
	}


	private static void deleteCurWithLeftChild(BinarySearchTreeNode cur, BinarySearchTreeNode prev) {
		if (prev.right == cur) {
			prev.right = cur.left;
		} else {
			prev.left = cur.left;
		}
	}


	private static BinarySearchTreeNode getHighestFromLeftTree( BinarySearchTreeNode left) {
		while (left.right != null) {
			left = left.right;
		}
		return left;
	}

}
