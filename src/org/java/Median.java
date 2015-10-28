package org.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int tot = in.nextInt();
		int[] arr = new int[tot];
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>( new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
			
		});
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		for (int i=0;i<tot;++i) {
			arr[i]=in.nextInt();
			if(i==0) {
				System.out.println(arr[i]);
			} else if(i==1) {
				if(arr[0]>arr[1]) {
					maxHeap.add(arr[0]);
					minHeap.add(arr[1]);
				} else {
					minHeap.add(arr[0]);
					maxHeap.add(arr[1]);
				}
				System.out.println(getMedianUsingHeap(minHeap, maxHeap));
			} else {
				if(arr[i]<=minHeap.peek()){
					minHeap.add(arr[i]);
				}else{
					maxHeap.add(arr[i]);
				}
				if(maxHeap.size()-minHeap.size()==2) {
					minHeap.add(maxHeap.poll());
				} else if(minHeap.size()-maxHeap.size()==2){
					maxHeap.add(minHeap.poll());
				}
				System.out.println(getMedianUsingHeap(minHeap, maxHeap));
			}
			//System.out.println(getMedian(arr, i));
		}
		in.close();
	}

	private static double getMedianUsingHeap(PriorityQueue<Integer> minHeap,
			PriorityQueue<Integer> maxHeap) {
		if(minHeap.size()==maxHeap.size()) {
			return (minHeap.peek()+maxHeap.peek())/2.0;
		} else if(minHeap.size()>maxHeap.size()) {
			return minHeap.peek();
		} else {
			return maxHeap.peek();
		}
	}

	private static double getMedian(int[] arr, int i) {
		if(i%2==0) {
			return arr[i/2];
		} else {
			int mid = (i+1)/2;
			double median = (double)(arr[mid]+arr[mid-1])/2;
			return median;
		}
	}

}
