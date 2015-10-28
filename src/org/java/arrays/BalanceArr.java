package org.java.arrays;

/*
 * Find is there given array has some balance i.e. total on each side of the elements are equal.
 */
public class BalanceArr {

	public static void main(String[] args) {
		int[] arr = {2, 1, 1, 2, 0};
		System.out.println(canBalance(arr));
	}

	public static boolean canBalance(int[] nums) {
		  int lSum = 0, rSum = 0, i = -1, j = nums.length;
		  while( i != j ) {
		    if (lSum == rSum &&  (i+1) == j  ) {
		      return true;
		    } else if ( lSum == rSum ) {
		      ++i; --j;
		      lSum += nums[i];
		      rSum += nums[j];
		    } else if ( lSum > rSum ) {
		      --j;
		      rSum += nums[j];
		    } else if ( lSum < rSum ) {
		      ++i;
		      lSum += nums[i];
		    }
		  }
		  return false;
		}

}
