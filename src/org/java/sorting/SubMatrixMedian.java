package org.java.sorting;

import java.util.Scanner;

/*
4
1 3 2 4
8 1 2 9
1 1 2 2
7 5 3 6
3
1 1 2 2
1 2 3 4
4 4 4 4 
*/

// TODO - find out why it failed for 3 last test cases
// if possible think of what Santosh said and retry
public class SubMatrixMedian {

//	public static void main(String[] args) {
//
//		Scanner in = new Scanner(System.in);
//		int N = in.nextInt();
//		int[][] arr = new int[N][N];
//		for(int i=0; i<N; ++i) {
//			for(int j=0; j<N; ++j) {
//				arr[i][j] = in.nextInt();
//			}
//		}
//		int Q = in.nextInt();
//		int[][] ques = new int[Q][4];
//		for(int i =0; i<Q; ++i) {
//			for (int j=0; j<4; ++j) {
//				ques[i][j] = in.nextInt();
//			}
//		}
//		in.close();
//		for(int i=0; i<Q; ++i) {
//			double median = getMedian(arr, ques, i);
//			System.out.println(median);
//		}
//	}
//
//	private static double getMedian(int[][] arr, int[][] ques, int quesIndex) {
//		int r1 = ques[quesIndex][0];
//		int c1 = ques[quesIndex][1];
//		int r2 = ques[quesIndex][2];
//		int c2 = ques[quesIndex][3];
//
//		int total = (r2-r1+1)*(c2-c1+1);
//		int[] subArr = new int[total];
//		int i = 0;
//		for(int j=r1-1; j < r2 ; ++j) {
//			for(int k=c1-1; k<c2; ++k) {
//				subArr[i] = arr[j][k];
//				++i;
//			}
//		}
//		sort(subArr);
//		if(total%2 ==0) {
//			int mid = total /2;
//			return (subArr[mid-1] + subArr[mid])/2;
//		} else {
//			return subArr[total/2];
//		}
//	}
//
//	public static void sort(int[] arr) {
//		quickSort(arr, 0, arr.length-1);
//	}
//
//	private static void quickSort(int[] arr, int low, int high) {
//		if(low>=high) {
//			return;
//		}
//		int pivot = getPivot(arr, low, high);
//		quickSort(arr, low, pivot-1);
//		quickSort(arr, pivot+1, high);
//	}
//	
//	private static int getPivot(int[] arr, int low, int high) {
//
//		int pivot = low;
//		int pivotValue=arr[pivot];
//		low++;
//		while (low <= high) {
//			if(arr[low] <= pivotValue) {
//				swap(arr, low, pivot);
//				pivot++;
//				low++;
//			} else {
//				swap(arr, low, high);
//				high--;
//			}
//		}
//		return pivot;
//	}
//
//	private static void swap(int[] arr, int i, int j) {
//		if(i==j) return;
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				arr[i][j] = in.nextInt();
			}
		}
		int Q = in.nextInt();
		int[][] ques = new int[Q][4];
		for(int i =0; i<Q; ++i) {
			for (int j=0; j<4; ++j) {
				ques[i][j] = in.nextInt();
			}
		}
		in.close();
		for(int i=0; i<Q; ++i) {
			int median = getMedian(arr, ques, i);
			System.out.println(median);
		}
	}

	private static int getMedian(int[][] arr, int[][] ques, int quesIndex) {
		int r1 = ques[quesIndex][0];
		int c1 = ques[quesIndex][1];
		int r2 = ques[quesIndex][2];
		int c2 = ques[quesIndex][3];

		int total = (r2-r1+1)*(c2-c1+1);
		int[] subArr = new int[total];
		int i = 0;
		for(int j=r1-1; j < r2 ; ++j) {
			for(int k=c1-1; k<c2; ++k) {
				subArr[i] = arr[j][k];
				++i;
			}
		}

        int mid = total/2;
        sort(subArr,mid);
        int midValue = subArr[mid];
        if (total%2==1) {
            return midValue;
        } else {
            sort(subArr, mid-1);
            return (midValue+subArr[mid-1])/2;
        }
	}

    public static void sort(int[] arr, int mid) {
        quickSort(arr, mid, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int mid, int low, int high) {
        if (low>=high) {
            return;
        }
        int pivot = getPivot(arr, low, high);
        if (pivot == mid) {
            return;
        } else if (pivot < mid) {
            quickSort(arr, mid, pivot+1, high);
        } else {
            quickSort(arr, mid, low, pivot-1);
        }
    }
	
    public static int getPivot(int[] arr, int low, int high) {
        int pivot = low;
        int pivotValue = arr[pivot];
        low++;
        while(low<=high) {
            if(arr[low] <= pivotValue) {
                swap(arr, low, pivot);
                pivot++;
                low++;
            } else {
                swap(arr, low, high);
                high--;
            }
        }
        return pivot;
    }


	private static void swap(int[] arr, int i, int j) {
		if(i==j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
