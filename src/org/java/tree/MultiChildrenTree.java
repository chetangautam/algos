package org.java.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiChildrenTree {

	public static class TreeNode {

		public int data;
		public TreeNode[] nodes;

		public TreeNode(int n) {
			this.data = n;
			this.nodes = null;
		}

		public void depthFirstTraverse() {
			System.out.println(this.data);
			if ( nodes != null ) {
				for(TreeNode t: nodes) {
					t.depthFirstTraverse();
				}
			}
		}

		/*
		 * this breadth first traversal is slightly tricky since no Data structure is used
		 */
		public void breadthFirstTraverse() {
			TreeNode[] list = new TreeNode[1];
			list[0] = this;

			for (int i = 0; i<list.length; ++i) {
				TreeNode n = list[i];

				// just printing here - although flattened out list will be available at the end to traverse too
				System.out.println(n.data);

				if ( n.nodes != null) {

					TreeNode[] tempList = new TreeNode[list.length+n.nodes.length];

					System.arraycopy(list, 0, tempList, 0, list.length);
					System.arraycopy(n.nodes, 0, tempList, list.length, n.nodes.length);

					list = tempList;
				}
			}
		}

		public TreeNode bfSearch(int num) {
			TreeNode[] list = new TreeNode[1];
			list[0] = this;

			for(int i = 0; i < list.length; ++i ) {
				if(list[i].data == num) {
					return list[i];
				}
				if(list[i].nodes !=null) {
					TreeNode[] temp = new TreeNode[list.length+list[i].nodes.length];
					System.arraycopy(list, 0, temp, 0, list.length);
					System.arraycopy(list[i].nodes, 0, temp, list.length, list[i].nodes.length);
					list = temp;
				}
			}
			return null;
		}

		// TODO - need to find out how to solve this.
		public boolean dfSearch(int num) {
			if (this.data == num) {
				return true;
			}
			if(this.nodes != null) {
				for(TreeNode t:this.nodes) {
					return false || t.dfSearch(num);
				}
			}
			//return false;
		}

	};

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode t14 = new TreeNode(14);
		TreeNode t15 = new TreeNode(15);

		TreeNode[] ta1 = {t2, t3, t4 };
		TreeNode[] ta2 = {t5, t6};
		TreeNode[] ta3 = {t7 };
		TreeNode[] ta4 = {t8, t9 };
		TreeNode[] ta5 = {t10, t11 };
		TreeNode[] ta6 = {t12 };
		TreeNode[] ta7 = {t13, t14 };
		TreeNode[] ta8 = {t15 };

		t1.nodes = ta1;
		t2.nodes = ta2;
		t3.nodes = ta3;
		t4.nodes = ta4;
		t5.nodes = ta5;
		t6.nodes = ta6;
		t8.nodes = ta7;
		t12.nodes = ta8;

		// t1.breadthFirstTraverse();
		// t1.depthFirstTraverse();

//		System.out.println(search(t1, 8));
//		System.out.println(search(t3, 9));
//		System.out.println(search(t7, 13));

		System.out.println(t1.bfSearch(150).data);
	}

}
