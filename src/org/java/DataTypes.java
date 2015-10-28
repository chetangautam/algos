package org.java;

import java.math.BigInteger;
import java.util.Scanner;

public class DataTypes {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i =0; i<n; ++i) {
            java.math.BigInteger l = in.nextBigInteger();
            BigInteger lBMax = BigInteger.valueOf(Long.MAX_VALUE);
            BigInteger lBMin = BigInteger.valueOf(Long.MIN_VALUE);
            if( l.compareTo(lBMax) > 0 || l.compareTo(lBMin) < 0 ) {
            	System.out.println(l.toString() + " can't be fitted anywhere.");
            } else {
                System.out.println(l + " can be fitted in:");
                BigInteger bMax = BigInteger.valueOf(Byte.MAX_VALUE);
                BigInteger bMin = BigInteger.valueOf(Byte.MIN_VALUE);
                if(l.compareTo(bMax) <= 0 && l.compareTo(bMin) >= 0 ) {
                	System.out.println("* byte");
                }
                bMax = BigInteger.valueOf(Short.MAX_VALUE);
                bMin = BigInteger.valueOf(Short.MIN_VALUE);
                if(l.compareTo(bMax) <= 0 && l.compareTo(bMin) >= 0 ) {
                	System.out.println("* short");
                }
                bMax = BigInteger.valueOf(Integer.MAX_VALUE);
                bMin = BigInteger.valueOf(Integer.MIN_VALUE);
                if(l.compareTo(bMax) <= 0 && l.compareTo(bMin) >= 0 ) {
                	System.out.println("* int");
                }
                if(l.compareTo(lBMax) <= 0 && l.compareTo(lBMin) >= 0) {
                	System.out.println("* long");
                }
            }
        }
        in.close();
	}

}
