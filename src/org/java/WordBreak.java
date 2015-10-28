package org.java;

public class WordBreak {

	public static void main(String[] args) {
		/*
		 * word break
		 */
		String word = "ilovemango";
		Text text = new Text();
		if(text.hasAtLeastOneWord(word)) {
			System.out.println("String has words!");
		} else {
			System.out.println("String does not has word!");
		}
		if(text.isWholeOneWord(word)) {
			System.out.println("String is a word!");
		} else {
			System.out.println("String is not just one word!");
		}
		if(text.hasAllValidWords(word)) {
			System.out.println("String has all valid words!");
		} else {
			System.out.println("String does not have all valid words!");
		}
		if(text.hasAllValidWordsUsingRegex(word)) {
			System.out.println("String has all valid words!");
		} else {
			System.out.println("String does not have all valid words!");
		}
		System.out.println("----------------------");
		/*******************************************/
	}
}
