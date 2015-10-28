package org.java.search;

public class BinarySearch {
	private int[] sortedArr = {0, 1, 2, 6, 8, 9};
	public int search(int key) {
		int retval = -1;
		int lo = 0, hi = this.sortedArr.length-1;
		while (lo <= hi) {
			int mid = (lo+hi)/2;
			if (key == this.sortedArr[mid]) {
				retval = mid;
				break;
			} else if (key > this.sortedArr[mid]) {
				lo = mid+1;
			} else {
				hi = mid-1;
			}
		}
		return retval;
	}

	public static void main(String[] args) {
		
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(0));
		System.out.println(bs.search(1));
		System.out.println(bs.search(2));
		System.out.println(bs.search(6));
		System.out.println(bs.search(8));
		System.out.println(bs.search(9));
		System.out.println(bs.search(3));
		System.out.println("----------------------");
		/*******************************************/
	}
}
