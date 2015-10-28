package org.java.recursion;

import java.math.BigDecimal;

public class Power {

	public static void main(String[] args) {
        double d = 2.5;
        int p = 5;
        System.out.println(pow(d,p));
	}

	public static BigDecimal power(double d, int p) {
		if (d==0) {
			return BigDecimal.ZERO;
		}
		if (p==0) {
			return BigDecimal.ONE;
		}
		if (p==1) {
			return new BigDecimal(d);
		}
		BigDecimal powerHalf = power(d, p/2);
		BigDecimal doubleOfHalf = powerHalf.multiply(powerHalf);
		if (p%2 == 0) {
			return doubleOfHalf;
		} else {
			return doubleOfHalf.multiply(new BigDecimal(d));
		}
	}

    public static BigDecimal pow(double d, int p) {
        boolean isNegative = false;
        if (d<0) {
            isNegative = true;
        }
        if (p%2==0) {
            isNegative = false;
        }
        BigDecimal result = power(Math.abs(d), Math.abs(p));
        if (isNegative) {
        	BigDecimal minus = new BigDecimal(-1);
            result = result.multiply(minus);
        }
        if (p<0) {
            return BigDecimal.ONE.divide(result);
        } else {
            return result;
        }
    }

}
