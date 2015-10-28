package org.java.recursion;

import java.util.ArrayList;

public class AllPossibleWellFormedBrackets {

	public static void main(String[] args) {

		ArrayList<String> allPossibleWellFormedBrackets = getAllPossibleWellFormedBrackets(3);

		for (String str : allPossibleWellFormedBrackets) {
			System.out.println(str);
		}
	}

	private static ArrayList<String> getAllPossibleWellFormedBrackets(int n) {
		ArrayList<String> allPossibleWellFormedBrackets = new ArrayList<String>();
		for (int i=1; i<=n; ++i) {
			getAllPossibleWellFormedBracketsHelper(i, allPossibleWellFormedBrackets, 0, 0, "");
		}
		return allPossibleWellFormedBrackets;
	}

	private static void getAllPossibleWellFormedBracketsHelper(int pairs,
			ArrayList<String> allPossibleWellFormedBrackets, int openBrackets, int closedBrackets, String s) {
		if( (pairs==openBrackets) && (pairs==closedBrackets) ) {
			allPossibleWellFormedBrackets.add(s);
		} else {
			if (openBrackets < pairs) {
				getAllPossibleWellFormedBracketsHelper(pairs, allPossibleWellFormedBrackets, openBrackets+1, closedBrackets, s+"(");
			}
			if (openBrackets > closedBrackets) {
				getAllPossibleWellFormedBracketsHelper(pairs, allPossibleWellFormedBrackets, openBrackets, closedBrackets+1, s+")");
			}
		}
	}	
	
//	private static void getAllPossibleWellFormedBracketsHelper(int i,
//			ArrayList<String> allPossibleWellFormedBrackets, int openBrackets, int closedBrackets, String s) {
//		if (i==1) {
//			allPossibleWellFormedBrackets.add(s+")");
//			return;
//		}
//		for (int index=i; index>=0; --index) {
//			if (openBrackets==closedBrackets) {
//				getAllPossibleWellFormedBracketsHelper(index-1, allPossibleWellFormedBrackets, openBrackets+1, closedBrackets, s+"(");
//			} else if (openBrackets>=i) {
//				getAllPossibleWellFormedBracketsHelper(index-1, allPossibleWellFormedBrackets, openBrackets, closedBrackets+1, s+")");
//			} else {
//				getAllPossibleWellFormedBracketsHelper(index-1, allPossibleWellFormedBrackets, openBrackets+1, closedBrackets, s+"(");
//			}
//		}
//		
//	}

}
