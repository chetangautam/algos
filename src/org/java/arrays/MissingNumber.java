package org.java.arrays;

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = {4,1,2,6,5};
		System.out.println(findMissingNumber(arr));
	}


    public static int findMissingNumber(int[] arr) {

    	int total = 0;
    	int maxPossible = 0;
    	for(int i=0; i<arr.length; ++i) {
    		total += arr[i];
    		maxPossible += (i+1);
    	}
    	maxPossible += arr.length+1;
    	return maxPossible - total;

    }

}
