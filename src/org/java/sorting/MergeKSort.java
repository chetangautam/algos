package org.java.sorting;

public class MergeKSort {

	public static void main(String[] args) {
		int[][] arr = {
			{2, 4, 6, 19},
			{1, 20, 35, 67},
			{3, 5, 7, 11},
			{45, 46, 47, 48},
			{3, 9, 100, 200}
		};

		int[] sortedArr = merge(arr);
		for(int i:sortedArr) {
			System.out.println(i);
		}

		System.out.println("\n");
		
		int[] sortedArr2 = kwaymerge(arr);

		for(int i:sortedArr2) {
			System.out.println(i);
		}
	}

    private static int[] kwaymerge(int[][] arr) {

        int K = arr.length;
        int N = arr[0].length;

        /** array to keep track of non considered positions in subarrays **/
        int[] curPos = new int[K];

        /** final merged array **/
        int[] mergedArray = new int[K * N];

        int p = 0;
        while (p < K * N) {

            int min = Integer.MAX_VALUE;
            int minPos = -1;

            /** search for least element **/
            for (int i = 0; i < K; i++) {
                if (curPos[i] < N) {
                    if (arr[i][curPos[i]] < min) {
                        min = arr[i][curPos[i]];
                        minPos = i;
                    }
                }
            }
            curPos[minPos]++;
            mergedArray[p++] = min;

        }

        return mergedArray;

    }

    private static int[] merge(int[][] arr) {
		int K = arr.length;
		int N = arr[0].length;
		int[][] mH = new int[K][2];

		for(int i=0; i<K; ++i) {
			mH[i][0] = i;
			mH[i][1] = 0;
		}
		heapify(mH, arr);

		int[] result = new int[K*N];
		for(int i=0; i<K*N; ++i) {
			result[i] = getMinFromK(mH, arr);
		}

		return result;
	}

	private static void heapify(int[][] mH, int[][] arr) {

		int mid = (mH.length-1)/2;

		if(mH.length%2==1) {
			mid--;
		}

		actualHeapify(mH, arr, mid);

	}

	private static void actualHeapify(int[][] mH, int[][] arr, int i) {

		int left = (2*i)+1;
		if (left > mH.length-1) {
			return;
		}
		int right = (2*i)+2;

		int valueAtI = Integer.MAX_VALUE;
		if(mH[i][1] != -1) {
			valueAtI = arr[mH[i][0]][mH[i][1]];
		}
		int valueAtLeft = Integer.MAX_VALUE;
		if(mH[left][1] != -1) {
			valueAtLeft = arr[mH[left][0]][mH[left][1]];
		}

		if(right <= mH.length-1) {

			int valueAtRight = Integer.MAX_VALUE;
			if (mH[right][1] != -1) {
				valueAtRight = arr[mH[right][0]][mH[right][1]];
			}
			if( valueAtI <= valueAtLeft && valueAtI <= valueAtRight ) {
				return;
			} else if( valueAtLeft < valueAtRight ) {
				swap(mH, i, left);
				actualHeapify(mH, arr, left);
			} else {
				swap(mH, i, right);
				actualHeapify(mH, arr, right);
			}
		} else {
			if( valueAtI <= valueAtLeft ) {
				return;
			} else {
				swap(mH, i, left);
				actualHeapify(mH, arr, left);
			}

		}

	}

	private static int getMinFromK(int[][] mH, int[][] arr) {
		int num = arr[mH[0][0]][mH[0][1]];
		int N = arr[0].length;
		if (mH[0][1] == N-1) {
			mH[0][1] = -1;
		} else {
			int col = mH[0][1];
			col++;
			mH[0][1] = col;
		}
		actualHeapify(mH, arr, 0);
		return num;
	}

	private static void swap(int[][] mH, int i, int j) {
		int[] temp = mH[i];
		mH[i] = mH[j];
		mH[j] = temp;
	}

}
