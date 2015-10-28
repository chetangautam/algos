package org.java.numeric;

import java.math.BigDecimal;

public class Power {

	public static void main(String[] args) {
        double d = 3.0;
        int p = 3;
        System.out.println(pow(d,p));
        d = 2.0;
        p = 10;
        System.out.println(ipow(d,p));

	}

	public static BigDecimal pow(double d, int p) {
        if(d==0) return BigDecimal.ZERO;
        if(p==0) return BigDecimal.ONE;
        BigDecimal bd = new BigDecimal(Math.abs(d));
        boolean isNegative = false;
        if (d<0) {
            isNegative = true;
        }
        if (p%2==0) {
            isNegative = false;
        }
        BigDecimal result = BigDecimal.ONE;
        int mid = p/2;
        for (int i=0; i<mid; ++i) {
            result = result.multiply(bd);
        }
        result = result.multiply(result);
        if(p%2==1) {
            result = result.multiply(bd);
        }
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


    private static BigDecimal ipow(double d, int p) {
        if(d==0) return BigDecimal.ZERO;
        if(p==0) return BigDecimal.ONE;
        BigDecimal bd = new BigDecimal(Math.abs(d));
        boolean isNegative = false;
        if (d<0) {
            isNegative = true;
        }
        if (p%2==0) {
            isNegative = false;
        }
        BigDecimal result = BigDecimal.ONE;
        while (p!=0)
        {
            if ((p & 1)==1) {
                result = result.multiply(bd);
            }
            p >>= 1;
            bd = bd.multiply(bd);
        }
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
