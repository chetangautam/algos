package org.java;

public class IsEveryWhere {

	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 3, 4};
		System.out.println(isEverywhere(arr, 1));
	}

	public static boolean isEverywhere(int[] nums, int val) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] != val && nums[i + 1] != val) {
				return false;
			}
		}
		return true;
	}

}
