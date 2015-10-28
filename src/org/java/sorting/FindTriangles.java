package org.java.sorting;

import java.util.Arrays;

public class FindTriangles {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6};
		System.out.println(triplets(8, arr));
	}

/*
for(int i=0; (i<d.length-2) && d[i]<t; ++i) {
	for(int j=i+1; (j<d.length-1) && (t-d[i]-d[j])>d[j]; ++j) {
		if (d[i]==d[j]) {
			continue;
		}
		int k=j+1;
		for(; k<d.length; ++k) {
			if (d[j]==d[k]) {
				continue;
			}
			if ((d[i]+d[j]+d[k])<=t) {
				retVal++;
			} else {
				break;
			}
		}
	}
}
*/

	public
    static int triplets(int t, int[] d) {
		Arrays.sort(d);
		int retVal = 0;
		for(int i=0; (i<d.length-2) && d[i]<t; ++i) {
			int k = d.length-1;
			for(int j=i+1; (j<k) && (t-d[i]-d[j])>d[j]; ++j) {
				if (d[i]==d[j]) {
					continue;
				}
				for(; k>j; --k) {
					if (d[j]==d[k]) {
						continue;
					}
					if ((d[i]+d[j]+d[k])<=t) {
		                retVal += (k-j);
		                k=(k<d.length-1)?++k:k;
						break;
					}
				}
			}
		}
		return retVal;
	}


}
