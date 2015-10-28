package org.java;

import java.util.Scanner;

// TODO - how to solve it in O(N) order

public class TruckTour {

	public static class DistanceGas{
		int gas;
		int distanceToNextStation;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int tot = in.nextInt();
		DistanceGas[] dsArr = new DistanceGas[tot];
		for(int i=0;i<tot;++i) {
			DistanceGas ds = new DistanceGas();
			ds.gas = in.nextInt();
			ds.distanceToNextStation = in.nextInt();
			dsArr[i] = ds;
		}
		in.close();

		for(int i=0; i<tot;++i) {
			int totalGas = 0;
			for (int j=i, k=0; k<tot; ++k, ++j) {
				totalGas+=dsArr[j%tot].gas;
				totalGas-=dsArr[j%tot].distanceToNextStation;
				if(totalGas < 0) {
					break;
				}
			}
			if(totalGas>=0) {
				System.out.println(i);
				return;
			}
		}
	}

}
