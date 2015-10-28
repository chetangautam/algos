package org.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordsFindInFile {

	public static class TrieNode {
		public char letter;
		public boolean isTerminal;
		public Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
		public List<Integer> positions = new ArrayList<Integer>();
		public TrieNode() {}
		public TrieNode(char letter) {
			this.letter = letter;
		}
	}

	public static void main(String[] args) {

	}

}
