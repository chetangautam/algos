package org.java.arrays;

public class Random7 {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println(random7());
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.println(randX(5,7));
		}

	}

	public static int randX(int rand1, int rand2) {
		int rand1square = rand1*rand1;
		int maxPossibleMultiples = rand1square/rand2;

		int random = -1;
		do {
			int i = (int) (Math.random()*5)+1;
			int j = (int) (Math.random()*5)+1;
			random = (i-1)*5+j;
		} while(random > maxPossibleMultiples*rand2);
		return random%rand2+1;
	}

	public static int random7() {
		int[][] rand = { 
				{1, 2, 3, 4, 5},
				{6, 7, 1, 2, 3},
				{4, 5, 6, 7, 1},
				{2, 3, 4, 5, 6},
				{7, 0, 0, 0, 0}
		};

		int random = 0;
		while(random==0) {
			int i = (int) (Math.random()*5) +1;
			int j = (int) (Math.random()*5) +1;
			random = rand[i-1][j-1];
		}

		return random;
	}

}
