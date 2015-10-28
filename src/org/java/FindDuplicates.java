package org.java;

import java.util.Iterator;


// Problem 1 ------- Not solving it (very simple)

// 3 4 2 1 3
// length n (above n = 5)
// 2 <= n <= 1M
// domain values 1 to (n-1)
// each number is guaranteed to occur at least once



// problem 2 - return non duplicate array (solving this one here)


public class FindDuplicates {

	private static class NonDuplicateIterator implements Iterator<Integer> {

		private Integer[] _arr;
		private int index;
		private int nextIndex;

		public static Iterator<Integer> getNonDuplicateIterator(int[] arr) {
			NonDuplicateIterator it = new NonDuplicateIterator();
			it.index = -1;
			it.nextIndex = -1;
			if (arr==null || arr.length == 0) {
				return null;
			} else {
				it._arr = new Integer[arr.length];
				for(int i=0;i<arr.length;++i) {
					it._arr[i]=arr[i];
				}
			}
			return it;
		}

		private int getNextIndex() {
			if(nextIndex <= index) {
				int i = index+1;
				if (i==0) {
					return i;
				}
				while(i<=_arr.length-1 && _arr[i].equals(_arr[index])) {
					++i;
				}
				return i;
			} else {
				return nextIndex;
			}
		}

		@Override
		public boolean hasNext() {
			if(getNextIndex() == _arr.length) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Integer next() {
			nextIndex = getNextIndex();
			index = nextIndex;
			if(nextIndex >= _arr.length) {
				return null;
			} else {
				return _arr[nextIndex];
			}
		}
		
	}

	//public int [] arr = { 1,1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 };
	public int [] arr = { 1, 1, 1 , 3, 3, 4, 4, 10, 13, 17, 17, 17 };
	//public int [] arr = {2};

	public static void main(String[] args) {
		FindDuplicates fd = new FindDuplicates();
		int [] arr2 = findDuplicates(fd.arr);
		for(int i=0;i<arr2.length;++i) {
			//System.out.println(arr2[i]);
		}
		Iterator<Integer> it = getNonduplicateIterator(fd.arr);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
	}


	private static Iterator<Integer> getNonduplicateIterator(int[] arr) {
		return NonDuplicateIterator.getNonDuplicateIterator(arr);
	}


	/**
	 * function to return non duplicate elements int array from input int array 
	 * @param int[]
	 * @return int[]
	 */
	public static int[] findDuplicates(int[] inputArr) {

		// input array basic validation
		if(inputArr==null || inputArr.length==0) {
			return inputArr;
		}

		// count the total non duplicates in input array - start from 1 since length is >0
		// loop starts from 1 looking previous for duplicates
		int totalNonDuplicates = 1;
		for(int i=1; i<inputArr.length;++i) {
			if(inputArr[i]!=inputArr[i-1]) {
				totalNonDuplicates++;
			}
		}

		// create array for non duplicates to return
		int[] outputArr = new int[totalNonDuplicates];

		int i=0, j=0;
		
		// start with copying first
		outputArr[0]=inputArr[0];

		// copy non duplicates from input to output array
		while(i<inputArr.length) {
			if( inputArr[i]!=outputArr[j]) {
				++j;
				outputArr[j]=inputArr[i];
			}					
			++i;
		}

		return outputArr;
	}
}
