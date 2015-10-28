package org.java.recursion;

/*
groupSumClump(0, {2, 4, 8}, 10) → true
groupSumClump(0, {1, 2, 4, 8, 1}, 14) → true
groupSumClump(0, {2, 4, 4, 8}, 14) → false
groupSumClump(0, {8, 2, 2, 1}, 9) → true
groupSumClump(0, {8, 2, 2, 1}, 11) → false
groupSumClump(0, {1}, 1) → true
groupSumClump(0, {9}, 1) → false
 */


public class GroupSumClump {

	public static void main(String[] args) {

		int[] arr = {9};
		System.out.println(groupSumClump(0, arr, 1));

	}

	public static boolean groupSumClump(int start, int[] nums, int target) {
		if (target == 0 && start >= nums.length) {
			return true;
		}
		if (target < 0 || start >= nums.length) {
			return false;
		}
		int repeatTotal = nums[start];
		for (; start+1 < nums.length && nums[start] == nums[start+1]; ++start) {
				repeatTotal += nums[start];
		}
		return groupSumClump(start+1, nums, target - repeatTotal)
				|| groupSumClump(start+1, nums, target);
	}

}
