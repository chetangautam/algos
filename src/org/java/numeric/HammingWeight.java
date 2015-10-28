package org.java.numeric;

public class HammingWeight {

	private static int[] mapping = new int[(int) Math.pow(2, 16)];

	static {
		for (int i=0; i<(int) Math.pow(2, 16); ++i) {
			mapping[i] = Integer.bitCount(i);
		}
	}

	public static void main(String[] args) {
		int[] arr = {31,518776661};
		int hammingWeight = getHammingWeigtSlow(arr);
		System.out.println(hammingWeight);

		hammingWeight = 0;
		hammingWeight = getHammingWeigtFast(arr);
		System.out.println(hammingWeight);

		hammingWeight = 0;
		hammingWeight = getHammingWeigtUsingLookup(arr);
		System.out.println(hammingWeight);
	}

	private static int getHammingWeigtSlow(int[] arr) {
		int hammingWeight = 0;
		for (int i=0; i<arr.length; ++i) {
			hammingWeight += countBitsSlow(arr[i]);
		}
		return hammingWeight;
	}

	private static int getHammingWeigtFast(int[] arr) {
		int hammingWeight = 0;
		for (int i=0; i<arr.length; ++i) {
			hammingWeight += countBitsFast(arr[i]);
		}
		return hammingWeight;
	}

	private static int getHammingWeigtUsingLookup(int[] arr) {
		int hammingWeight = 0;
		for (int i=0; i<arr.length; ++i) {
			hammingWeight += mapping[arr[i] & 0xFFFF] + mapping[arr[i]>>16];
		}
		return hammingWeight;
	}

	private static int countBitsSlow(int i) {
		int totalCount = 0;
		while(i>0) {
			if( (i&1)==1) {
				totalCount++;
			}
			i=i>>1;
		}
		return totalCount;
	}

	/*
	 * faster when most bits are 0
	 */
	private static int countBitsFast(int i) {
		int totalCount = 0;
		for(;i>0; totalCount++) {
			i &= i-1;
		}
		return totalCount;
	}

}
