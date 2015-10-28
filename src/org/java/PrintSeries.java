package org.java;

import java.util.Scanner;

public class PrintSeries {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        for (int i=0; i<total; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j=0; j<n; ++j) {
                long num = 0;
                for(int k=0; k<=j; ++k) num+=(long)Math.pow(2, k);
                System.out.print(a+num*b + " ");
            }
            System.out.print("\n");
        }
        in.close();
	}

}
