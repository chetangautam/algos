package org.java.numeric;

public class BenchMarkBitShifting {

	public static void main(String[] args) {
		
		int size = (int)Math.pow(2, 29);
		long timeDiff = 0;
		int ctr = (int)Math.pow(2, 8);
		for (int i = 0; i<ctr ; ++i) {
			timeDiff += benchMark(size);
		}
		System.out.println("\n\nBenchMark: " + timeDiff/ctr);;
	}

	private static long benchMark(int size) {
		int[] arr = new int[size];
		
		for(int i=0; i<size; ++i) {
			arr[i] = i;
		}

		long temp;
		long timeTakenShift16 = 0;
		long endTime = 0;
		long startTime = 0;
		startTime = System.currentTimeMillis();
		System.out.println("Start Time: " + startTime);
		for(int i=0; i<size; ++i) {
			temp = arr[i]>>16;
//			System.out.println(arr[i]>>16);
			temp=temp++;
		}
		endTime = System.currentTimeMillis();
		System.out.println("End Time: " + endTime);
		timeTakenShift16 = endTime-startTime;
		System.out.println("Time taken: "+ timeTakenShift16);
		
		long timeTakenShift1 = 0;
		endTime = 0;
		startTime = 0;
		startTime = System.currentTimeMillis();
		System.out.println("Start Time: " + startTime);
		for(int i=0; i<size; ++i) {
			temp = arr[i]>>1;
			temp=temp++;
//			System.out.println(arr[i]>>1);
		}
		endTime = System.currentTimeMillis();
		System.out.println("End Time: " + endTime);
		timeTakenShift1 = endTime - startTime;
		System.out.println("Time taken: "+ timeTakenShift1);

		return timeTakenShift16 - timeTakenShift1;
	}
}
