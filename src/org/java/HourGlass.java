package org.java;

import java.util.Scanner;

public class HourGlass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for(int i = 0; i< 6; ++i) {
        	for(int j=0; j<6; ++j) {
        		arr[i][j] = in.nextInt();
        	}
        }
        in.close();
        int max = -100;
        for(int i = 0; i<=3; ++i) {
        	for (int j = 0; j<=3; ++j) {
        		max = Math.max(max, 
        				(arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]));
        	}
        }
        System.out.println(max);        
    }

}
