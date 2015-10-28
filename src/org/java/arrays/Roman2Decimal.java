package org.java.arrays;

import java.util.HashMap;

public class Roman2Decimal {

	private static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	static {
		hm.put("I", 1);
		hm.put("IV", 4);
		hm.put("V", 5);
		hm.put("IX", 9);
		hm.put("X", 10);
		hm.put("XL", 40);
		hm.put("L", 50);
		hm.put("XC", 90);
		hm.put("C", 100);
		hm.put("CD", 400);
		hm.put("D", 500);
		hm.put("CM", 900);
		hm.put("M", 1000);
	}
	
	public static void main(String[] args) {
	    
        assert romanNumerals("CXXXVII") == 137;
        assert romanNumerals("CDXXXVII") == 437;
        assert romanNumerals("CXXIX") == 129;
        assert romanNumerals("XCIX") == 99;
        assert romanNumerals("XCIV") == 94;
        System.out.println("All tests pass");

	}

	public static int romanNumerals(String numerals) {
		int number = 0;
		for(int i=0; i<numerals.length(); ++i) {
			if (i+1<numerals.length()) {
				Integer value = hm.get(numerals.substring(i, i+2));
				if (null != value) {
					number += value;
					++i;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(numerals.charAt(i));
					number = number + hm.get(sb.toString());
				}
				
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(numerals.charAt(i));
				number = number + hm.get(sb.toString());
			}
		}
		System.out.println(number);
		return number;
	}

}

/*
 * The task is to complete the function romanNumerals such that given a valid roman numeral string
 * the function returns the integer value associated with that string of roman numerals.
 * 
 * The values for each numeral is as follows:
 * I = 1
 * V = 5 
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 * 
 * For a series of roman numerals, the values are parsed from left to right. The values are addative in most cases, that is:
 * 
 * II = (1 + 1)   = 2
 * XX = (10 + 10) = 20
 * VI = (5+1)     = 6
 * 
 * Typically, the values are ordered with larger numerals on the left, smaller numerals on the right, however
 * putting 4 of the same numerals in a row is invalid. In order to avoid this Romans added an additional rule. 
 * If the numeral to the immediate right of any other numeral is a larger value, then the value on the left is negative. 
 * For example:
 * 
 * VIIII is an INVALID roman numeral string, if we want 9 instead we have to do
 * IX = (10-1) = 9 or -1 + 10 = 9
*/

/*
    public static class LetterDetails {
      private int value;
      private List<Character> possiblePostRomanLetters;
      
      // constructor
      public LetterDetails(int value, List<Character> posPostRmnLetters) {
        this.value = value;
        if (null != posPostRmnLetters) {
          this.possiblePostRomanLetters = new ArrayList<Character>();
          for (Character c: posPostRmnLetters) {
            this.possiblePostRomanLetters.add(c);
          }
        }
      }

      // getters
      public int getValue() {
        return this.value;
      }

      public List<Character> getPossibleNextRomanLetters() {
        if (null != this.possiblePostRomanLetters) {
          List<Character> toReturn = new ArrayList<Character>();
          for (Character c: this.possiblePostRomanLetters) {
            toReturn.add(c);
          }
          return toReturn;
        }
        return null;
      }
    }

  public static int romanNumerals(String numerals) {
    
    int retVal = 0;
    if (null == numerals || numerals.length==0) {
      return retVal;
    }
    int curTotal = 0;
    for(int i=0; i<numerals.length(); ++i) {
      LetterDetails letterDet = HashMapLetterDetails.get(numerals.charAt(i));
      int curValue = letterDet.getValue();
      List<Characters> nextpossibles = letterDet.getPossibleNextRomanLetters();
      if (i!=numerals.length()-1) {
        char nextLetter = numerals.charAt(i+1);
        for(int j=0; j<nextPossibles.size(); +j) {
          if (nextpossibles.getAt(j) == nextLetter) {
            int nextLetterValue = HashMapLetterDetails.get(nextLetter).getValue();
            curTotal = curTotal + (nextLetterValue - curValue);
            ++i;
            break;
          }
        } 
      }
    }
    return curTotal;
  }
}
*/
