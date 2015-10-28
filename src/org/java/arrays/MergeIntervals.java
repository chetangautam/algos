package org.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {

		int[][] intervals = {
				{1,3},
				{2,4},
				{5,7},
				{6,8},
				{9,10},
				{11,12},
				{12,14},
				{13,15}
			};
		mergeIntervals(intervals);
	}

	private static void mergeIntervals(int[][] intervals) {
		if (null==intervals || intervals.length <=1) {
			for (int[] is : intervals) {
				for (int i : is) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
			return;
		}
		List<Integer[]> returnIntervals = new ArrayList<Integer[]>();
		for (int i=0; i<intervals.length; ++i) {
			int[] curInterval = intervals[i];
			int[] prevInterval = null;
			int[] interval = null;
			for (int indexUntil = i+1; indexUntil<intervals.length; ++indexUntil) {
				prevInterval = intervals[indexUntil-1];
				interval = intervals[indexUntil];
				if (prevInterval[1] >= interval[0] && prevInterval[1] < interval[1]) {
					curInterval[1] = interval[1];
					i++;
				} else {
					break;
				}
			}
			Integer[] returnElement = new Integer[2];
			returnElement[0] = curInterval[0];
			returnElement[1] = curInterval[1];
			returnIntervals.add(returnElement);
		}
		for (Integer[] is : returnIntervals) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
