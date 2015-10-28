package org.java.sorting;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {
		int[] arr = {1,0,0,0};
		String[] s = printTriplets(arr);
		for (String str:s) {
			System.out.println(str);
		}

	}

    public static String[] printTriplets(int[] intArr) {

        //Arrays.sort(intArr);

        Set<Set<Integer>> set = new LinkedHashSet<Set<Integer>>();
        for (int i=0; i<intArr.length; ++i) {
            int[] otherTwo = new int[2];
            boolean foundSum = findSum(i, intArr, 0-intArr[i], otherTwo);
            if (foundSum) {
                Set<Integer> inSet = new LinkedHashSet<Integer>();
                inSet.add(i);
                inSet.add(otherTwo[0]);
                inSet.add(otherTwo[1]);
                //String s = String.format("%d,%d,%d", intArr[i], otherTwo[0], otherTwo[1]);
                set.add(inSet);
            }
        }
        String[] out = new String[set.size()];
        int j=0;
        for(Set<Integer> s: set) {
            String str = "";
            for(Integer i: s) {
                str+=String.format("%d,",intArr[i]);
            }
            out[j++]=str.substring(0,str.length()-1);
        }
        return out;
    }

    public static boolean findSum(int exclude, int[] intArr, int sum, int[] oTwo) {
        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for( int i=0; i<intArr.length; ++i) {
            if(i==exclude) {
                continue;
            }
            Integer index = nums.get(sum-intArr[i]);
            if (index!=null) {
                oTwo[0]=index;
                oTwo[1]=i;
                return true;
            }
            nums.put(intArr[i], i);
        }
        return false;
    }

/*    static boolean findSum(int exclude, int[] intArr, int sum, int[] oTwo) {
        int start =0;
        int end = intArr.length-1;
        int total=0;
        while( start<end ) {
            if (start!=exclude && end!=exclude) {
                total = intArr[start] + intArr[end];
                if (total == sum) {
                    oTwo[0]=start;
                    oTwo[1]=end;
                    return true;
                } else if (total < sum) {
                    start++;
                } else {
                    end--;
                }
            } else if (start == exclude) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    } */

}
