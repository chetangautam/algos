package org.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

	private HashSet<String> dict = null;

	Text() {
		dict = new HashSet<String>();
		dict.add("i");
		dict.add("love");
		dict.add("man");
		dict.add("mango");
		dict.add("go");
	}

	public boolean hasAtLeastOneWord(String word) {

		Iterator<String> it = dict.iterator();
		while(it.hasNext()) {
			String currentWord = (String)it.next();
			if (word.contains(currentWord) && currentWord.length() < word.length()) {
				return true;
			}
		}
		return false;
	}

	public boolean isWholeOneWord(String word) {

		Iterator<String> it = dict.iterator();
		while(it.hasNext()) {
			String currentWord = (String)it.next();
			if (word.contains(currentWord) && currentWord.length() == word.length()) {
				return true;
			}
		}
		return false;
	}

	public boolean hasAllValidWordsUsingRegex(String word) {

		StringBuffer sb = new StringBuffer();
		for(String s: dict) {
			sb.append(s + "|");
		}

		String pattern = sb.toString().substring(0, sb.length()-1);
		pattern = "(" + pattern + ")*";
		Pattern p = Pattern.compile(pattern);
		Matcher M = p.matcher(word);
		if(M.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasAllValidWords(String word) {
		return hasAllValidWords(word, 0);
	}

	private boolean hasAllValidWords(String word, int startIndex) {
		if(startIndex == word.length()) {
			return true;
		}

		Iterator<String> it = dict.iterator();
		while(it.hasNext()) {
			String currentWord = (String)it.next();
			int len = currentWord.length();
			int end = startIndex+len;

			if(end > word.length()) {
				continue;
			}

			String subStr = word.substring(startIndex, startIndex+len);
			if(subStr.equals(currentWord)) {
				if( hasAllValidWords(word, startIndex+len) ) {
					return true;
				}
			}
		}
		return false;
	}

}
