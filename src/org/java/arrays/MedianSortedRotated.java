package org.java.arrays;

public class MedianSortedRotated {

	public static void main(String[] args) {

		int[] arr = {4,5,5,6,7,0,1,2};

		int cur = 0;
		int i = 1;
		while (i<arr.length) {
			if (arr[i] < arr[cur]) {
				break;
			}
			++i;
		}
		int index = (i + arr.length/2) % arr.length;
		if (arr.length%2==1) {
			System.out.println(arr[index]);
		} else {
			int index2 = (index-1) % arr.length;
			System.out.println((double)(arr[index]+arr[index2])/2);
		}
	}

}
