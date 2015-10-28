package org.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestedArraylist {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int inputArrListCount = in.nextInt();
		in.nextLine();
		List<List<Integer>> mainList = new ArrayList<List<Integer>>(inputArrListCount);
		for (int i=0; i<inputArrListCount; ++i) {
			String str = in.nextLine();
			String[] arr = str.split(" ");
			List<Integer> al = new ArrayList<Integer>();
			for(String s: arr) {
				al.add(Integer.valueOf(s));
			}
			mainList.add(al);
		}
		inputArrListCount = in.nextInt();
		in.nextLine();
		for (int i=0; i<inputArrListCount; ++i) {
			int j = in.nextInt();
			int k = in.nextInt();
			if (j < 1 || j> mainList.size()) {
				System.out.println("ERROR!");
			} else {
				if (k < 0 || k >= mainList.get(j-1).size()) {
					System.out.println("ERROR!");
				} else {
					System.out.println(mainList.get(j-1).get(k));
				}
			}
		}
		in.close();
	}

}
