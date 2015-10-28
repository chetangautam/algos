package org.java.arrays;

public class ArrayRotate {

	private int[] arrayToRotate = {0, 1, 2, 6, 8, 9};
	public void rotateByCopy(int rotateCount) {
		int[] rotatedArray = new int[arrayToRotate.length];
		rotateCount = rotateCount%arrayToRotate.length;
		int j=0, i;
		for(i=rotateCount; i>0;--i,++j) {
			rotatedArray[j] = arrayToRotate[arrayToRotate.length-i];
		}
		for(i=0;j<arrayToRotate.length; ++j, ++i) {
			rotatedArray[j] = arrayToRotate[i];
		}
		for(int num: arrayToRotate) System.out.print(num);
		System.out.println("\n");
		for(int num: rotatedArray) System.out.print(num);
	}

	public void rotateByShifting(int rotateCount) {
		rotateCount = rotateCount%arrayToRotate.length;
		while(rotateCount>0) {
			int numRotating = arrayToRotate[arrayToRotate.length-1];
			shiftArray();
			arrayToRotate[0]=numRotating;
			rotateCount--;
		}
		for(int num: arrayToRotate) System.out.print(num);
	}

	private void shiftArray() {
		for(int i=1; i<arrayToRotate.length; ++i) {
			arrayToRotate[arrayToRotate.length-i] = arrayToRotate[arrayToRotate.length-i-1];
		}
	}

	public void rotateBySplitAndReverse(int rotateCount) {
		reverse(arrayToRotate, 0, arrayToRotate.length-rotateCount-1);
		reverse(arrayToRotate, arrayToRotate.length-rotateCount, arrayToRotate.length-1);
		reverse(arrayToRotate, 0, arrayToRotate.length-1);
		for(int num: arrayToRotate) System.out.print(num);
	}

	private void reverse(int[] arr, int start, int end) {
		if(start == end) {
			return;
		}
		if(start +1 == end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			return;
		}
		for(int i=start; i<= end/2; ++i) {
			int num = arr[i];
			arr[i] = arr[end-i];
			arr[end-i] = num;
		}
	}

	public static void main(String[] args) {
		/*
		 * Array rotating
		 */
		ArrayRotate arrRotate = new ArrayRotate();
		arrRotate.rotateByCopy(8);
		System.out.println("\n");
		arrRotate.rotateByShifting(8);
		System.out.println("\n");
		arrRotate.rotateBySplitAndReverse(2);
		/*******************************************/

	}
}
