package org.java.arrays;

import java.util.Stack;

public class SeeAndSay {

	public static void main(String[] args) {

		System.out.println(printSeqNum(1, 1));
		System.out.println(printSeqNum(2, 1));
		System.out.println(printSeqNum(3, 1));
		System.out.println(printSeqNum(4, 1));
		System.out.println(printSeqNum(5, 1));
		System.out.println(printSeqNum(6, 1));
		System.out.println(printSeqNum(2, 2));
		System.out.println(printSeqNum(3, 22));
		System.out.println(printSeqNum(4, 10));
	}

	public static int printSeqNum(int nth, int seed) {
		int[] arr = new int[nth];
		arr[0] = seed;
		for(int i=1; i<nth; ++i) {
			String s = read(arr[i-1]);
			arr[i] = write(s);
		}
		return arr[nth-1];
	}

	private static int write(String s) {
		return Integer.valueOf(s);
	}

	private static String read(int i) {
		Stack<Integer> stack = new Stack<Integer>();
		do {
			stack.push(i%10);
			i/=10;
		} while(i>0);

		return strForNum(stack);
	}

	public static String strForNum(Stack<Integer> stack) {
		StringBuilder sb = new StringBuilder("");
		int num = 0;
		int ctr = 0;
		while (stack.size()>0) {
			ctr++;
			num = stack.pop();
			if (stack.size()>0) {
				if (stack.peek() != num) {
					sb.append(createString(ctr, num));
					ctr =0;
				}
			}
		}
		sb.append(createString(ctr, num));
		return sb.toString();
	}

	private static String createString(int ctr, int num) {
		return String.format("%s%d", ctr, num);
	}

}
