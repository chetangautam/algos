package org.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LexicograpicFirstAndLast {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = in.nextInt();
        int length = str.length();
        in.close();
        if (length < n) return;
        List<String> arr = new ArrayList<String>();
        for(int i=0; i<length-n+1; ++i) {
            arr.add(str.substring(i,i+n));
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
        System.out.println(arr.get(arr.size()-1));
 	}

}
