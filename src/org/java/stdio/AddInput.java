package org.java.stdio;

import java.util.Scanner;

public class AddInput {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        long total = 0;
        for(int i = 0; i < count; ++i) {
        	int val = in.nextInt();
        	total += val;
        }
        System.out.print(total);
        in.close();
	}

}
