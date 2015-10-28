package org.java;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stairCount = in.nextInt();
        for(int i=1; i <= stairCount; ++i) {
            for(int j =0; j<stairCount-i; ++j) {
                System.out.print(" ");
            }
            for(int j=0; j<i; ++j) {
                System.out.print("#");
            }
            System.out.print("\n");
        }
        in.close();
	}

}
