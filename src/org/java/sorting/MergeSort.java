package org.java.sorting;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = {3, 7, 4, 2, 8, 9, 2, 6, 1, 9, 5};

		mergeSort(arr);

		for(int i: arr) {
			System.out.println(i);
		}

	}

    public static void mergeSort(int[] intArr) {

    	ms(intArr, 0, intArr.length-1);

    }

    public static void ms(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            ms(arr, low, mid);
            ms(arr, mid+1, high);
            merge(arr, low, mid+1, high);
        }
    }

    public static void merge(int[] arr, int leftArrBegin, int rightArrBegin, int rightArrEnd) {

    	int size= rightArrEnd-leftArrBegin+1;
        int[] mergeArr = new int[size];

        int leftArrIndex = leftArrBegin, 
        		rightArrIndex = rightArrBegin,
        		leftArrEnd = rightArrBegin-1,
        		mergeArrIndex = 0;

        while( leftArrIndex <= leftArrEnd && rightArrIndex <= rightArrEnd ) {
            if(arr[leftArrIndex]>=arr[rightArrIndex]) {
                mergeArr[mergeArrIndex] = arr[rightArrIndex];
                ++rightArrIndex;
            } else {
                mergeArr[mergeArrIndex] = arr[leftArrIndex];
                ++leftArrIndex;
            }
            ++mergeArrIndex;
        }

        while( leftArrIndex <= leftArrEnd ) {
            mergeArr[mergeArrIndex] = arr[leftArrIndex];
            ++leftArrIndex;
            ++mergeArrIndex;
        }

        while( rightArrIndex <= rightArrEnd ) {
            mergeArr[mergeArrIndex] = arr[rightArrIndex];
            ++rightArrIndex;
            ++mergeArrIndex;
        }

        for(int i = 0; i < size; ++i) {
        	arr[leftArrBegin+i]=mergeArr[i];
        }

    }

}
