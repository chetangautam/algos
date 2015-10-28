package org.java;

import java.util.Scanner;

public class StringHash {

	public static void main(String[] args) {

//		Scanner in = new Scanner(System.in);
//		for(int i = 0; i<10; ++i) {
//			String s = in.next();
//			System.out.println(s.hashCode());
//		}
//		in.close();

		System.out.println(hascode());
	}

	public static int hascode() {
		int result = 17;
		int one = "The Dirty Dozen: The Deadly Mission (1987)".hashCode();
		result = 31 * result + one;
		int two = "16447051002".hashCode();
		result = 31 * result + two;
		int three = "".hashCode();
		result = 31 * result + three;
		int four = "Movies & TV/Video on Demand by VUDU/War & Western".hashCode();
		result = 31 * result + four;
		int five = "0".hashCode();
		result = 31 * result + five;
		int six = "READY_TO_PUBLISH".hashCode();
		result = 31 * result + six;
		return result;
	}
}
