package org.java.arrays;

import java.io.IOException;
import java.util.Scanner;

public class AtoI {

    static int atoi(String strInput) {
        if(strInput==null || strInput.length() ==0) {
            return 0;
        }
        boolean isPositive = true;
        long num= 0;
        while(strInput.charAt(0)==' ') {
        	strInput = strInput.substring(1);
        }
        for(int i=0; i< strInput.length(); ++i) {
            if (i==0) {
              if(strInput.charAt(i)=='-') {
                isPositive = false;
              } else if (strInput.charAt(i) == '+') {
                isPositive = true;
              } else if (!Character.isDigit(strInput.charAt(i))) {
                  return 0;
              } else {
                  num = Character.getNumericValue(strInput.charAt(i));
              }
            } else if (!Character.isDigit(strInput.charAt(i))) {
            	return returnInt(isPositive, num);
            } else {
                num = (num*10) + Character.getNumericValue(strInput.charAt(i));
                if ( isPositive && num >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (!isPositive && (num *-1) <= Integer.MIN_VALUE ) {
                    return Integer.MIN_VALUE;
                }
            }            
        }
    	return returnInt(isPositive, num);
    }

    static int atoi2(String strInput) {

        String str = removeSpaces(strInput);
        return getValue(str);
    }

    static int getValue(String str) {

        boolean isPositive = true;
        if (str.charAt(0) == '-') {
        	str = str.substring(1);
            isPositive = false;
        } else if (str.charAt(0) == '+') {
        	str = str.substring(1);
            isPositive = true;
        } else if (Character.isDigit(str.charAt(0)) ) {
            isPositive = true;
        } else {
            return 0;
        }

        long value = 0;
        for(int i=0; i<str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                value = (value*10)+Character.getNumericValue(str.charAt(i));
            }
        }
        if (!isPositive) {
            value = (-1) * value;
        }
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)value;
    }

    static String removeSpaces(String str) {
        if (str == null) {
            return str;
        }
        while(str.charAt(0)==' ') {
            str = str.substring(1);
        }
        return str;
    }

	private static int returnInt(boolean isPositive, long num) {
		if(!isPositive) {
			return -(int)num;
		} else {
		    return (int)num;
		}
	}


	   public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        String _strInput = in.next();
	        System.out.println(atoi(_strInput));
	        System.out.println(atoi2(_strInput));
	        in.close();
	    }
}