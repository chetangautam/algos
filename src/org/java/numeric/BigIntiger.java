package org.java.numeric;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntiger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

//		BigInteger num1 = in.nextBigInteger();
//		BigInteger num2 = in.nextBigInteger();

		long num1 = in.nextLong();
		long num2 = in.nextLong();

		in.close();

//		BigInteger sum = num1.add(num2);
//		BigInteger product = num1.multiply(num2);

		BigInteger bNum1 = BigInteger.valueOf(num1);
		BigInteger bNum2 = BigInteger.valueOf(num2);
		
		BigInteger sum = bNum1.add(bNum2);
		BigInteger product = bNum1.multiply(bNum2);

		System.out.println(sum);
		System.out.println(product);
	}

}
