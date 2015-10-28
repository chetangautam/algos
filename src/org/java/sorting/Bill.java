package org.java.sorting;

/*
 * Bill.com interview - 
 * 		Merge sort
 * 		reverse an array
 */

public class Bill {

}
/*

public void reverse(int[] arr) {
	if (arr != null) {
	for(int i=0; i<arr.length/2; ++i) {
		int temp = arr[i];
		arr[i] = arr[arr.length-1-i];
		arr[arr.length-1-i] = arr[i];
}
}
}

empty array: {}
single element array
even numbers in an array
odd numbers in an array
1M elements in an array
null array

// merge two sorted arrays
// array1 is large to store


// arr1 ------ 5,6,7     => 1,2,_,5,6,7	len(5) , i(2), j(2)
// arr2 ------ 1,2,3,4

public void mergeArrays(int[] arr1, int lenOfArr1, int[] arr2, int lenOfArr2) {

	int j=0;
	int i=0;
	for(; i<lenOfArr1;i++) {
		for(; j<lenOfArr2; j++) {
		if(arr1[i] <= arr2[j]) {
			break;
} else {
	shift(arr1, i, lenOfArr1);
	++lenOfArr1;
	arr1[i] = arr2[j];
		++i;
}
	}
}
if(j!=lenOfArr2) {
	while(j<lenOfArr2){
		arr1[i++] = arr2[j++];
}
}
}
private void shift(int[]arr, int currentLoc, int length) {
}

// 1,2,3,4  <==4
// 1,2,3,3,4,5,6
// 3,5,6    <==3

// 1,2,3,3,4,5,6

var j = ++i;
// increment i and then assign to j

var j = i++;
// assign i to j, and then increment i

*/
