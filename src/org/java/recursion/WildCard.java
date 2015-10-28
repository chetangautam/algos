package org.java.recursion;

import java.util.ArrayList;
import java.util.List;

public class WildCard {

	public static void main(String[] args) {

		String pattern = "1?0?";
		String[] resultSet = getResult(pattern);
		for(String s: resultSet) {
			System.out.println(s);
		}
	}

	private static String[] getResult(String pattern) {
		List<String> result = new ArrayList<String>();
		getResultHelper(pattern, 0, result);
		String[] retArr = new String[result.size()];
		result.toArray(retArr);
		return retArr;
	}

	private static void getResultHelper(String pattern, int i, List<String> result) {
		if(i==pattern.length()) {
			result.add(pattern);
			return;
		}
		if (pattern.charAt(i) == '?') {
			getResultHelper(pattern.substring(0,i) + "0" + pattern.substring(i+1), i+1, result);
			getResultHelper(pattern.substring(0,i) + "1" + pattern.substring(i+1), i+1, result);
		} else {
			getResultHelper(pattern, i+1, result);
		}
	}

}
