package org.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class StartProgram {

	public static void main(String[] args) {

		/*
		 * same method in 2 interfaces implemented by a class 
		 */
		Circle circleOnSquare = new CircleOnSquare();
		circleOnSquare.draw();
		Square obj;
		obj = (Square) circleOnSquare;
		obj.draw();
		System.out.println("----------------------");
		/*******************************************/


		/*
		 * trying ConcurrentModificationException
		 */
		Collection<String> myCollection = new ArrayList<String>(10);
		myCollection.add("123");
		myCollection.add("456");
		myCollection.add("789");
		int someConditionIsTrue = 0;
		for (Iterator<String> myColIt = myCollection.iterator(); myColIt.hasNext();) {
			someConditionIsTrue++;
			String myObject = (String)myColIt.next();
			System.out.println(myObject);
			if (someConditionIsTrue == 3) {
				myCollection.remove(myObject); //can throw ConcurrentModificationException in single as //well as multi-thread access situations.
			}
		}
		System.out.println("----------------------");
		/*******************************************/


		final int A[] = {-1, 3, -4, 5, 1, -6, 2, 1};
		System.out.println(solution(A, A.length));
		System.out.println("----------------------");
		/*******************************************/


		final int A1[] = {0,Integer.MAX_VALUE};
		System.out.println(solution(A1));
		System.out.println("----------------------");
		/*******************************************/


		System.out.println(solution3(1,10,10));
		System.out.println("----------------------");
		/*******************************************/


		int[] forTriangle = {10, 50, 5, 1} ;
		System.out.println(checkTriangle(forTriangle));
		System.out.println("----------------------");
		/*******************************************/


		String S = "{[()()]}";
		System.out.println(bracketsMatch(S));
		System.out.println("----------------------");
		/*******************************************/
		

		System.out.println(fac(40,20));
		System.out.println("----------------------");
		/*******************************************/
		

		int[] tttttt = {5, 2,4,6,3,7} ;
		System.out.println(chain(tttttt));
		System.out.println("----------------------");


		TryException ce = new TryException();
		try{
			ce.process();
		} catch(Exception e) {
			System.out.println("Caught exception!");
		}

	}

	/*
	 * equilibrium
	 */
	public static int solution(int A[], int N) {
		/*
		 * This is a demo task. You can read about this task and its solutions in this blog post.
			A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
			A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
			Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
			For example, consider the following array A consisting of N = 8 elements:
			  A[0] = -1
			  A[1] =  3
			  A[2] = -4
			  A[3] =  5
			  A[4] =  1
			  A[5] = -6
			  A[6] =  2
			  A[7] =  1
			P = 1 is an equilibrium index of this array, because:
			A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
			P = 3 is an equilibrium index of this array, because:
			A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
			P = 7 is also an equilibrium index, because:
			A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
			and there are no elements with indices greater than 7.
			P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
			Write a function:
			int solution(int A[], int N);
			that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
			For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
			Assume that:
			N is an integer within the range [0..100,000];
			each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
			Complexity:
			expected worst-case time complexity is O(N);
			expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
			Elements of input arrays can be modified.
		 * 
		 */

		long leftSum = 0;
	    long rightSum = 0;
	    for(int i = 0; i < N; ++i) {
	        rightSum += A[i];
	    }
	    int j = 0;
	    do {
	        rightSum -= A[j];
	        if(leftSum == rightSum) {
	            break;
	        } 
		    leftSum += A[j];
		    ++j;
	    }while(j<N);
	    if(j>=N) {
	    	return -1;
	    } else {
	    	return j;
	    }
	}

	/*
	 * permutation
	 */
    public static int solution(int[] A) {
    	/*
    	 * A non-empty zero-indexed array A consisting of N integers is given.
			A permutation is a sequence containing each element from 1 to N once, and only once.
			For example, array A such that:
			    A[0] = 4
			    A[1] = 1
			    A[2] = 3
			    A[3] = 2
			is a permutation, but array A such that:
			    A[0] = 4
			    A[1] = 1
			    A[2] = 3
			is not a permutation, because value 2 is missing.
			The goal is to check whether array A is a permutation.
			Write a function:
			class Solution { public int solution(int[] A); }
			that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
			For example, given array A such that:
			    A[0] = 4
			    A[1] = 1
			    A[2] = 3
			    A[3] = 2
			the function should return 1.
			Given array A such that:
			    A[0] = 4
			    A[1] = 1
			    A[2] = 3
			the function should return 0.
			Assume that:
			N is an integer within the range [1..100,000];
			each element of array A is an integer within the range [1..1,000,000,000].
			Complexity:
			expected worst-case time complexity is O(N);
			expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
			Elements of input arrays can be modified.
    	 */
    	
    	if (A.length == 1) {
    		return 0;
    	}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long min = A[0];
        long max = A[0];
        for(int i=0;i<A.length;++i) {
            if(map.get(A[i]) != null) {
                return 0;
            } else if(A[i] < 1) {
                return 0;
            } else {
                if (min > A[i]) {
                    min = A[i];
                }
                if (max < A[i]) {
                    max = A[i];
                }
                map.put(A[i],1);
            }
        }
        if ((max -min +1) == A.length) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
     * frog jump
     */
    public int solution2(int X, int Y, int D) {
    	/*
    	 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
			Count the minimal number of jumps that the small frog must perform to reach its target.
			Write a function:
			class Solution { public int solution(int X, int Y, int D); }
			that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
			For example, given:
			  X = 10
			  Y = 85
			  D = 30
			the function should return 3, because the frog will be positioned as follows:
			after the first jump, at position 10 + 30 = 40
			after the second jump, at position 10 + 30 + 30 = 70
			after the third jump, at position 10 + 30 + 30 + 30 = 100
			Assume that:
			X, Y and D are integers within the range [1..1,000,000,000];
			X ≤ Y.
			Complexity:
			expected worst-case time complexity is O(1);
			expected worst-case space complexity is O(1).
    	 */
    	int steps = 0;
        if (X!=Y) {
            long current = X;
            while (current <Y) {
                current+=D;
                ++steps;
            }
        }
        return steps;
    }

    /*
     * frog jump - better performance solution
     */
    public static int solution3(int X, int Y, int D) {
        int steps = 0;
        if (X!=Y) {
            int remainder = (Y-X)%D;
            if (remainder == 0) {
            	steps = (Y-X)/D;
            } else {
            	steps = ((Y-X)/D)+1;
            }
        }
        return steps;
    }

    /*
     * MaxProductOfThree (50% accurate based on codility)
     */
    public int maxProductOfThree(int[] A) {
    	/*
    	 * A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
			For example, array A such that:
			  A[0] = -3
			  A[1] = 1
			  A[2] = 2
			  A[3] = -2
			  A[4] = 5
			  A[5] = 6
			contains the following example triplets:
			(0, 1, 2), product is −3 * 1 * 2 = −6
			(1, 2, 4), product is 1 * 2 * 5 = 10
			(2, 4, 5), product is 2 * 5 * 6 = 60
			Your goal is to find the maximal product of any triplet.
			Write a function:
			class Solution { public int solution(int[] A); }
			that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.
			For example, given array A such that:
			  A[0] = -3
			  A[1] = 1
			  A[2] = 2
			  A[3] = -2
			  A[4] = 5
			  A[5] = 6
			the function should return 60, as the product of triplet (2, 4, 5) is maximal.
			Assume that:
			N is an integer within the range [3..100,000];
			each element of array A is an integer within the range [−1,000..1,000].
			Complexity:
			expected worst-case time complexity is O(N*log(N));
			expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
			Elements of input arrays can be modified.
    	 */
        Arrays.sort(A);
        int productOfFirst2 = A[1]*A[0];
        int productOfLast2 = A[A.length-1]*A[A.length-2];
        if (productOfFirst2 < productOfLast2) {
            int[] A1 = new int [A.length -1];
            for(int i=0; i< A.length-2;++i) {
                A1[i]=A[i];
            }
            A1[A1.length-1]=productOfLast2;
            Arrays.sort(A1);
            return A1[A1.length-1]*A1[A1.length-2];
        } else {
            int[] A1 = new int [A.length -1];
            for(int i=2; i< A.length;++i) {
                A1[i-2]=A[i];
            }
            A1[A1.length-1]=productOfFirst2;
            Arrays.sort(A1);
            return A1[A1.length-1]*A1[A1.length-2];
        }        
    }
    
    /*
     * triangle
     */
    public static int checkTriangle(int[] A) {
        for(int i=0; i<A.length-2; ++i) {
            for(int j=i+1; j<A.length-1; ++j) {
                for(int k=j+1; k<A.length; ++k) {
                    if(isTriangle(A[i],A[j],A[k])== true) return 1;
                }
            }
        }
        return 0;
    }

    public static int checkTriangle2(int[] A) {
    	Arrays.sort(A);
        for(int i=0; i<A.length-2; ++i) {
            if(A[i]>0 && A[i]>A[i+2]-A[i+1]) return 1;
        }
        return 0;
    }

    private static boolean isTriangle(int a, int b, int c) {
    	if(a<0 || b<0 || c<0) return false;
    	if(a==b && b==c) return true;
        if(a+b>c && a+c>b && b+c>a){
        	return true;
        } else{
        	return false;
        }
    }


    /*
     * match the brackets {, [, ( - return 0 if does not match, else return 1
     */
    public static int bracketsMatch(String S) {
        java.util.Stack<Character> st = new java.util.Stack<Character>();
        char a;
        for(int i=0; i<S.length(); ++i) {
            char c= S.charAt(i);
            switch (c)
            {
            case '{': 
            case '[': 
            case '(': {
                st.push(c);
                break;
                }
            case '}': {
	            	try {
	            		a = (char) st.pop();
	            	}
	            	catch (java.util.EmptyStackException e) {
	            		return 0;
	            	}
	                if (a != '{') return 0;
	                break;
                }
            case ']': {
	            	try {
	            		a = (char) st.pop();
	            	}
	            	catch (java.util.EmptyStackException e) {
	            		return 0;
	            	}
	                if (a != '[') return 0;
	                break;
                }
            case ')': {
	            	try {
	            		a = (char) st.pop();
	            	}
	            	catch (java.util.EmptyStackException e) {
	            		return 0;
	            	}
	                if (a != '(') return 0;
	                break;
                }
            }
        }
        if(st.size()==0) {
            return 1;
        }
        return 0;
    }

    
    public static int fac(int N, int K) {
        if(N<0 || K<0 || N<K) {
            return -1;
        }
        long numeratorFact = factorial(N);
        long denominatorHigh = factorial(K);
        long denominatorLow = factorial(N-K);
        double temp = numeratorFact/denominatorHigh;
        temp = temp/denominatorLow;
        if(temp>1000000000){
            return -1;
        } else {
            return (int)temp;
        }
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for(int i=1; i<=n; ++i) {
            fact*=i;
        }
        return fact;
    }

    
    public static int chain(int[] A) {
        for(int i=0; i< A.length-2; ++i) {
            /*minTilHere = Math.max(0, A[i] - min);
            min = Math.min(min, A[i]);
            int temp = Math.min(minTilHere, minFinal);
            if (temp != minFinal) {
                minFinal = temp;
                updateMins(minFinal);
            }*/
            //let me get the answer first
            for (int j =i+2; j<A.length; ++j) {
                int temp = A[i]+A[j];
                updateMins(temp);
            }
        }
        return (int)mins[0];
    }

    private static long[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    private static void updateMins(long num) {
            if (num < mins[0]) {
                mins[0] = num;
            } else if (num < mins[1]) {
                if(mins[1]==Integer.MAX_VALUE) {
                    mins[1] = num;
                } else {
                    mins[0] = mins[1];
                    mins[1] = num;
                }
            } else if (num < mins[2]) {
                if(mins[2]==Integer.MAX_VALUE) {
                    mins[2] = num;
                } else {
                    long temp = mins[1];
                    mins[1] = mins[2];
                    mins[0] = temp;
                    mins[2] = num;
                }
            }
        }

}

/*
 * 
 * 
 * 
 * // you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int K) {
        if(N<0 || K<0 || N<K) {
            return -1;
        }
        long denominatorLow = factorial(N-K);
        long denominatorHigh = denominatorLow * factorialFrom(N-K+1, K);
        long numeratorFact = denominatorHigh * factorialFrom(K+1, N);
        if(numeratorFact <0 || denominatorHigh <0 || denominatorLow <0) {
            return -1;
        }
        double temp = numeratorFact/denominatorHigh;
        temp = temp/denominatorLow;
        if(temp>1000000000){
            return -1;
        } else {
            return (int)temp;
        }
    }

    private long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for(int i=1; i<=n; ++i) {
            if(Integer.MAX_VALUE/fact > i) {
                fact*=i;
            } else {
                return -1;
            }
        }
        return fact;
    }

    private long factorialFrom(int start, int end) {
        long fact = 1;
        for(;start<=end; start++) {
            if(Integer.MAX_VALUE/fact > start) {
                fact*=start;
            } else {
                return -1;
            }
        }
        return fact;
    }
}

 */

