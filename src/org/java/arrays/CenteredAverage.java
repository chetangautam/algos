package org.java.arrays;

public class CenteredAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 100};
		System.out.println(centeredAverage(nums));
	}

	public static int centeredAverage(int[] nums) {
		int max = nums[0], min = nums[0], total = 0;
		for (int i = 0; i < nums.length; ++i) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
			total += nums[i];
		}
		return (total - max - min) / (nums.length - 2);

	}

}
