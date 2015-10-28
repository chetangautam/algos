package org.java.stdio;

import java.util.Scanner;

public class EndOfFile {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int count = 0;
		while(in.hasNext()) {
			count++;
			String s = count + " " + in.nextLine();
			System.out.println(s);
		}
		in.close();
	}

}
