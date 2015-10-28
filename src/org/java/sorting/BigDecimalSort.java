package org.java.sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BigDecimalSort {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		List<BigDecimal> arr = new ArrayList<BigDecimal>();
		for(int i =0; i<n; ++i) {
			BigDecimal b = in.nextBigDecimal();
			arr.add(b);
		}
		in.close();
		Collections.sort(arr, Collections.reverseOrder());
		for(BigDecimal b: arr) {
			String s = b.toPlainString();
			if(s.startsWith("0.")) {
				s = s.substring(1);
			}
			System.out.println(s);
		}

	}

}
