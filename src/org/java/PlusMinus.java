package org.java;

import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int posCtr = 0;
        int negCtr = 0;
        int zerCtr = 0;
        for(int i = 0; i < count; ++i) {
        	int val = in.nextInt();
            if(val ==0) {
                zerCtr++;
            } else if (val < 0) {
                negCtr++;
            } else {
                posCtr++;
            }
        }
        System.out.println((float)posCtr/count);
        System.out.println((float)negCtr/count);
        System.out.println((float)zerCtr/count);
        in.close();

	}

}
