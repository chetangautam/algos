package org.java;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        int d1Sum = 0;
        int d2Sum = 0;
        for(int i = 0; i< n; ++i) {
            for(int j = 0; j<n; ++j) {
                arr[i][j] = in.nextInt();
                if(i==j) {
                    d1Sum += arr[i][j];
                }
                if(n-j-1==i) {
                    d2Sum += arr[i][j];
                }
            }
        }
        in.close();
        System.out.println(Math.abs(d1Sum-d2Sum));
	}

}
