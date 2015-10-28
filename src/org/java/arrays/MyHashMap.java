package org.java.arrays;

import java.util.Random;

public class MyHashMap {

	public static class MyEntry {
		private String key;
		private String value;
		private int keyHash;
		private MyEntry next;

		public String getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
		public int getKeyHash() {
			return keyHash;
		}
		public MyEntry(String key, String value) {
			super();
			this.keyHash = key.hashCode();
			this.key = key;
			this.value = value;
			this.next = null;
		}
		public MyEntry(MyEntry cur) {
			this.keyHash = cur.keyHash;
			this.key = cur.key;
			this.value = cur.value;
			this.next = null;
		}
		public MyEntry append(MyEntry next) {
			this.next = next;
			return this;
		}
	}

	private MyEntry[] table;
	private final int initialTableSize = 15;
	private final float loadFactor = 0.75f;
	private final int tableResizeFactor = 2;
	private int currentSize = 0;

	public MyHashMap() {
		table = new MyEntry[initialTableSize];
		initializeTable(table, initialTableSize);
	}

	public void put(String key, String value) {
		if (eligibleToResize()) {
			resize();
		}
		putEntry(key, value);
	}

	private void putEntry(String key, String value) {
		int hash = key.hashCode();
		int tableIndex = getTableIndex(hash, table.length);
		currentSize++;
		MyEntry entry = table[tableIndex];
		if(null!=entry) {
			MyEntry newEntry = new MyEntry(key, value);
			table[tableIndex] = newEntry.append(entry);
		} else {
			table[tableIndex] = new MyEntry(key, value);
		}
	}

	private void initializeTable(MyEntry[] table, int size) {
		for (int i=0; i<size; ++i) {
			table[i] = null;
		}
	}

	private boolean eligibleToResize() {
		if (currentSize/loadFactor >= table.length ) {
			return true;
		}
		return false;
	}

	private void resize() {
		int newTableSize = table.length * tableResizeFactor;
		MyEntry[] newTable = new MyEntry[newTableSize];
		initializeTable(newTable, newTableSize);
		for(MyEntry e: table) {
			if (null!=e) {
				MyEntry cur = e;
				MyEntry next = null;
				while(cur!=null) {
					next = cur.next;
					int hash = cur.getKeyHash();
					int newTableIndex = getTableIndex(hash, newTableSize);
					MyEntry entryInNewTable = newTable[newTableIndex];
					if (null==entryInNewTable) {
						cur.next = null;
						newTable[newTableIndex] = cur;
					} else {
						cur.next = entryInNewTable;
						newTable[newTableIndex] = cur;
					}
					cur = next;
				}
			}
		}
		table = newTable;
	}

	private int getTableIndex(int hash, int tableLength) {
		return Math.abs(hash) % tableLength;
	}

	public MyEntry getEntry(String key) {
		int hash = key.hashCode();
		MyEntry e = table[getTableIndex(hash, table.length)];
		if (e==null) {
			return e;
		}
		MyEntry cur = e;
		while(cur!=null) {
			if (cur.getKeyHash() == hash) {
				if (cur.key.equalsIgnoreCase(key)) {
					return new MyEntry(cur);
				}
			}
			cur = cur.next;
		}
		// should never reach here
		return cur;
	}

	public static void main(String[] args) {

		String chars = "abcdefghijklmnopqrstuvwxyz";
		MyHashMap hm = new MyHashMap();
		hm.put("guddu", "delhi");
		hm.put("rangeela", "orrisa");
		hm.put("baagi", "bangalore");
		hm.put("anuraagi", "santa clara");
		for (int i=0; i<1000; ++i) {
			String key = generateString(chars, 10);
			String value = generateString(chars, 10);
			hm.put(key, value);
		}
		System.out.println(hm.getEntry("guddu").getValue());
		System.out.println(hm.getEntry("rangeela").getValue());
		System.out.println(hm.getEntry("baagi").getValue());
		System.out.println(hm.getEntry("anuraagi").getValue());
	}

	public static String generateString(String characters, int length)
	{
		Random rng = new Random();
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    String toReturn = new String(text);
	    if (toReturn.length() == 0) {
	    	return generateString(characters, length);
	    }
	    return toReturn;
	}
}
