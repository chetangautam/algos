package org.java.recursion;

public class TotalPathsBinaryMatrix {

	public static void main(String[] args) {

		int[][] a = { {1,1},{1,1} };
		System.out.println(numberOfPaths(a, 2, 2));

	}

	public static int numberOfPaths(int [][]a,int M,int N) {
	    return numberOfPathsHelperSimpler(a, M-1, N-1);
	}

	public static int numberOfPathsHelper(int [][]a, int row, int col) {
	    if (row>0 && col>0) {
	        if (a[row-1][col] !=0 && a[row][col-1]!=0) {
	            return numberOfPathsHelper(a, row-1, col) + numberOfPathsHelper(a, row, col -1);
	        } else if (a[row-1][col]!=0) {
	            return numberOfPathsHelper(a, row-1, col);
	        } else {
	            return numberOfPathsHelper(a, row, col -1); 
	        }
	    } else if (col>0 && a[row][col-1]!=0) {
	        return numberOfPathsHelper(a, row, col-1);
	    } else if (row >0 && a[row-1][col]!=0){
	        return numberOfPathsHelper(a, row-1, col);
	    } else {
	        return 1;
	    }
	}

	public static int numberOfPathsHelperSimpler(int [][]a, int row, int col) {
		if (row>=0 && col>=0 && a[row][col]==0) {
			return 0;
		}
	    if (row>0 && col>0) {
	    	return numberOfPathsHelperSimpler(a, row-1, col) + numberOfPathsHelperSimpler(a, row, col-1);
	    } else if (col>0) {
	        return numberOfPathsHelperSimpler(a, row, col-1);
	    } else if (row>0) {
	        return numberOfPathsHelperSimpler(a, row-1, col);
	    } else if (row==0 && col==0){
	        return 1;
	    } else {
	    	return 0;
	    }
	}

}
