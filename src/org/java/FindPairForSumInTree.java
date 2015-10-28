package org.java;

import java.util.ArrayList;
import java.util.List;

public class FindPairForSumInTree {

	public static class TreeNode {
		public int data;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	private TreeNode root;

	public void addToTree(TreeNode root, int num) {
		if(root == null) {
			return;
		} else{
			TreeNode curr = root;
			while(true) {
				if(curr.data > num) {
					if (curr.left != null) {
						curr = curr.left;
					} else {
						curr.left = new TreeNode(num);
						break;
					}
				} else {
					if (curr.right != null) {
						curr = curr.right;
					} else {
						curr.right = new TreeNode(num);
						break;
					}
				}
			}
		}
		
	}

	public TreeNode addToTreeRecur(TreeNode root, int num) {
		if(root == null) {
			return new TreeNode(num);
		}
		if (num<=root.data) {
			root.left = addToTreeRecur(root.left, num);
		}
		else {
			root.right = addToTreeRecur(root.right, num);
		}
		return root;
	}

	public void inOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public TreeNode search(TreeNode root, int num) {
		if (root == null) {
			return null;
		}
		if (root.data == num) {
			return root;
		}
		if (root.data < num) {
			return search(root.right, num);
		} else {
			return search(root.left, num);
		}
	}

	public TreeNode[] findPairNodesForSum(TreeNode root, int sum) {
		TreeNode[] pair = new TreeNode[2];
		findPairNodesForSumHelper(pair, root, sum, root);
		return pair;
	}

	private void findPairNodesForSumHelper(TreeNode[] pair, TreeNode currentRoot, int sum, TreeNode treeRoot) {
		if (currentRoot == null || pair[0] != null) {
			return;
		}
		findPairNodesForSumHelper(pair, currentRoot.left, sum, treeRoot);
		TreeNode searchedNode = search(treeRoot, sum - currentRoot.data);
		if (searchedNode != null) {
			pair[0] = currentRoot;
			pair[1] = searchedNode;
			return;
		} else {
			findPairNodesForSumHelper(pair, currentRoot.right, sum, treeRoot);
		}
	}

	public TreeNode[] findPairNodesForSumFast(TreeNode root, int sum) {
		TreeNode[] pair = new TreeNode[2];
		List<TreeNode> treeList = flattenTree(root);
		findPairNodesForSumInArr(pair, treeList, sum);
		return pair;
	}

	public List<TreeNode> flattenTree(TreeNode root) {
		List<TreeNode> arr = new ArrayList<TreeNode>();
		flattenTreeHelper(arr, root);
		return arr;
	}

	private void flattenTreeHelper(List<TreeNode> arr, TreeNode root) {
		if (root == null) {
			return;
		}
		flattenTreeHelper(arr, root.left);
		arr.add(root);
		flattenTreeHelper(arr, root.right);
	}

	public void findPairNodesForSumInArr(TreeNode[] pair, List<TreeNode> arr, int sum) {
		for(int i = 0, j = arr.size()-1; i< j; ) {
			if (arr.get(i).data + arr.get(j).data == sum) {
				pair[0] = arr.get(i);
				pair[1] = arr.get(j);
				return;
			} else if (arr.get(i).data + arr.get(j).data > sum) {
				--j;
			} else {
				++i;
			}
		}
	}

	public static void main(String[] args) {

		FindPairForSumInTree fp = new FindPairForSumInTree();

		/*
		 * Below tree building and traversal works but commented since same tree is created below with recursion.
		 * 
		fp.root = new TreeNode(30);

		fp.addToTree(fp.root, 20); 
		fp.addToTree(fp.root, 24); 
		fp.addToTree(fp.root, 18); 
		fp.addToTree(fp.root, 45); 
		fp.addToTree(fp.root, 34); 
		fp.addToTree(fp.root, 48); 

		fp.inOrderTraversal(fp.root);
		 */

		System.out.println("\n");

		fp.root = fp.addToTreeRecur(null, 30);

		fp.addToTreeRecur(fp.root, 20); 
		fp.addToTreeRecur(fp.root, 24); 
		fp.addToTreeRecur(fp.root, 18); 
		fp.addToTreeRecur(fp.root, 45); 
		fp.addToTreeRecur(fp.root, 34); 
		fp.addToTreeRecur(fp.root, 48); 

		fp.inOrderTraversal(fp.root);

		System.out.println("\n");
		System.out.println(fp.search(fp.root, 45).data);
		// System.out.println(fp.search(fp.root, 46).data); // if uncommented this will throw null pointer exception. Null will be returned as 46 is not in tree.

		TreeNode[] pair = fp.findPairNodesForSum(fp.root, 69);
		System.out.println("\n");
		System.out.println(pair[0].data);
		System.out.println(pair[1].data);

		TreeNode[] pair2 = fp.findPairNodesForSumFast(fp.root, 69);
		System.out.println("\n");
		System.out.println(pair2[0].data);
		System.out.println(pair2[1].data);

	}

}
