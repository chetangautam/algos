package org.java.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangle {

	public static void main(String[] args) {

		int[] arr = new int[10];
		arr[0]=6320;
		arr[1]=6020;
		arr[2]=6098;
		arr[3]=1332;
		arr[4]=7263;
		arr[5]=672;
		arr[6]=9472;
		arr[7]=2838;
		arr[8]=3401;
		arr[9]=9494;
		int maxArea = getMaxAreaSlow(arr);
		System.out.println(maxArea);
		maxArea = getMaxAreaFast(arr);
		System.out.println(maxArea);

		int[] arr2 = {6,2,5,4,1}; //,5,1,6};
		System.out.println(getMaxAreaFast(arr2));
	}

	private static int getMaxAreaFast(int[] arr) {
		int maxArea=-1;
		Deque<Integer> stack = new LinkedList<Integer>();
		int i=0;
		while(i<arr.length) {
			if(stack.isEmpty() || arr[stack.peekFirst()]<=arr[i]) {
				stack.addFirst(i);
				++i;
			} else {
				maxArea = Math.max(maxArea,getStackTopArea(arr, stack, i));
			}
		}
		while(!stack.isEmpty()) {
			maxArea = Math.max(maxArea,getStackTopArea(arr, stack, i));
		}
		return maxArea;
	}

	private static int getStackTopArea(int[] arr, Deque<Integer> stack, int i) {
		int top = stack.pollFirst();
		if(stack.isEmpty()) {
			return arr[top]*i;
		} else {
			return arr[top]*(i-stack.peekFirst()-1);
		}
	}

	private static int getMaxAreaSlow(int[] arr) {
		int maxArea=-1;
		for(int i=0; i<arr.length; ++i) {
			int j=i;
			while(j>=0) {
				if(arr[j] < arr[i]) {
					++j;
					break;
				}
				--j;
			}
			if(j<0){
				j = 0;
			}
			int k=i;
			while(k<arr.length) {
				if(arr[k] < arr[i]) {
					--k;
					break;
				}
				++k;
			}
			if(k>arr.length-1) {
				k = arr.length-1;
			}
			int area = arr[i]* (k-j+1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

}
