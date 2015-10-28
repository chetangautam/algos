package org.java.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class SumZero {
	
	public static void main(String[] args) {
		int[] arr = {5,1,2,0,-3,0,0,7,-4};
		String[] subSets = sumZero(arr);
		for (String s : subSets) {
			System.out.println(s);
		}
		System.out.println();
		int[] arr2 = {0, 1, 2, 3, 4, (-10)};
		String[] subSets2 = sumZero(arr2);
		for (String s : subSets2) {
			System.out.println(s);
		}
	}


	// TODO - fix this
    public static String[] sumZero2(int[] arr) {

    	HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    	int total = 0;
    	ArrayList<String> listSubSets = new ArrayList<String>();
    	for (int i=0; i<arr.length; ++i) {
    		total+=arr[i];
    		Integer indexOfSameSum = m.get(total);
    		if( total == 0 || arr[i] == 0 || indexOfSameSum != null) {
    			StringBuilder sb = new StringBuilder();
//    			if (indexOfSameSum == null) {
//    				indexOfSameSum = i;
//    			}
//    			if (arr[i]==0) {
//    				listSubSets.add("0");
//    				continue;
//    			}
    			if (null != indexOfSameSum) {
        			for (int index = indexOfSameSum+1; index <= i; ++index) {
        				sb.append(arr[index]);
        				if (index != i) {
        					sb.append(",");
        				}
        			}
    			}
    			if (sb.length()>0) {
        			listSubSets.add(sb.toString());
    			}
    		} else 
    		m.put(total, i);
    	}
    	String[] subSets = new String[listSubSets.size()];
    	
		return listSubSets.toArray(subSets);
    }



    public static String[] sumZero(int[] arr) {

    	HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    	int total = 0;
    	ArrayList<String> listSubSets = new ArrayList<String>();
    	for (int i=0; i<arr.length; ++i) {
    		total+=arr[i];
    		Integer indexOfSameSum = m.get(total);
    		if( total == 0 || arr[i] == 0 || indexOfSameSum != null) {
    			StringBuilder sb = new StringBuilder();
    			if (indexOfSameSum == null) {
    				indexOfSameSum = i;
    			}
    			for (int index = indexOfSameSum+1; index <= i; ++index) {
    				sb.append(arr[index]);
    				if (index != i) {
    					sb.append(",");
    				}
    			}
    			if (sb.length()>0) {
        			listSubSets.add(sb.toString());
    			}
    			if (arr[indexOfSameSum]==0) {
    				handleAllZeores(indexOfSameSum, i, arr, listSubSets, sb.toString());
    			} else {
    				handleTrailingZeroes(sb.toString(), i, arr, listSubSets);
    			}
    		}
    		m.put(total, i);
    	}
    	String[] subSets = new String[listSubSets.size()];
    	
		return listSubSets.toArray(subSets);
    }


	private static void handleAllZeores(int indexOfSameSum, int i, int[] arr, ArrayList<String> listSubSets, String sb) {
		for(int j=indexOfSameSum; j>=0 && arr[j]==0; --j) {
			StringBuilder sb1 = new StringBuilder();
			sb1.append(arr[j]);
			sb1.append(",");
			String str = sb1.toString()+sb;
			listSubSets.add(sb1.toString()+sb);
			handleTrailingZeroes(str, i, arr, listSubSets);
		}
	}


	private static void handleTrailingZeroes(String str, int i, int[] arr, ArrayList<String> listSubSets) {
		StringBuilder sb1 = new StringBuilder();
		for(int j=i+1; j<arr.length && arr[j]==0; ++j) {
			sb1.append(",");
			sb1.append(arr[j]);
			listSubSets.add(str+sb1.toString());
		}
	}

}
