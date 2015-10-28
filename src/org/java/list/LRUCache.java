package org.java.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static class LinkedListNode {
		private int val;
		private LinkedListNode next, previous;
		public LinkedListNode(int val) {
			this.val = val;
			this.next = null;
			this.previous = null;
		}
		public LinkedListNode(LinkedListNode node) {
			this(node.val);
		}
		public LinkedListNode addPrevious(LinkedListNode prev) {
			this.previous = prev;
			if (null!=prev) {
				prev.next = this;
			}
			return prev;
		}
		public LinkedListNode addNext(LinkedListNode next) {
			this.next = next;
			if (null!=next) {
				next.previous = this;
			}
			return next;
		}
		public LinkedListNode deleteSelf() {
			LinkedListNode toReturn = null;
			if (null==this.previous) {
				if (null!=this.next) {
					this.next.previous = null;
				}
				toReturn = this.next;
			} else {
				this.previous.next = this.next;
				if(null!=this.next) {
					this.next.previous = this.previous;
				}
				toReturn = this.previous;
			}
			deLink();
			return toReturn;
		}
		public LinkedListNode getNext() {
			return this.next;
		}
		public LinkedListNode getPrevious() {
			return this.previous;
		}
		public void deLink() {
			this.next = null;
			this.previous = null;
		}
	}

	int cacheMax = 10;
	int cacheSize = 0;
	LinkedListNode cacheHead = null;
	LinkedListNode cacheTail = null;
	Map<Integer, LinkedListNode> hm = null;

	public LRUCache() {
		hm = new HashMap<Integer, LinkedListNode>();
	}

	public void clearCache() {
		cacheSize = 0;
		cacheHead = null;
		cacheTail = null;
		hm.clear();
	}

	public void addToCache(int key) {
		if ( cacheSize == cacheMax) {
			evict();
		}
		cacheSize++;
		LinkedListNode node = new LinkedListNode(key);
		if (null!=cacheHead) {
			cacheHead = cacheHead.addPrevious(node);
		} else {
			cacheHead = node;
			cacheTail = node;
		}
		hm.put(key, node);
	}

	private void moveToHead(LinkedListNode node) {
		if (cacheHead != node) {
			LinkedListNode prev = node.deleteSelf();
			if (cacheTail == node) {
				cacheTail = prev;
			}
			node.deLink();
			cacheHead = cacheHead.addPrevious(node);
		}
	}

	public void evict() {
		deleteFromCache(cacheTail);
	}

	/*
	 * nodeToDelete must be in cache
	 */
	private void deleteFromCache(LinkedListNode nodeToDelete) {
		if (null!=nodeToDelete) {
			cacheSize--;
			hm.remove(nodeToDelete.val);
			if (cacheHead==nodeToDelete && cacheTail==nodeToDelete) {
				nodeToDelete.deleteSelf();
				clearCache();
			} else if (cacheHead==nodeToDelete) {
				cacheHead = nodeToDelete.deleteSelf();
			} else if (cacheTail==nodeToDelete) {
				cacheTail = nodeToDelete.deleteSelf();
			} else {
				nodeToDelete.deleteSelf();
			}
		}
	}

	public void deleteFromCache(int key) {
		deleteFromCache(hm.get(key));
	}

	public LinkedListNode findInCache(int key) {
		LinkedListNode foundKeyNode = hm.get(key);
		if (null==foundKeyNode) {
			return null;
		}
		moveToHead(foundKeyNode);
		return new LinkedListNode(foundKeyNode);
	}

	public static void main(String[] args) {

		LRUCache lru = new LRUCache();
		lru.addToCache(1);
		lru.addToCache(2);
		lru.addToCache(3);
		lru.addToCache(4);
		lru.addToCache(5);
		lru.addToCache(6);
		lru.addToCache(7);
		assert lru.print().equalsIgnoreCase("7 6 5 4 3 2 1 |1 2 3 4 5 6 7 ") == true;
		lru.findInCache(4);
		assert lru.print().equalsIgnoreCase("4 7 6 5 3 2 1 |1 2 3 5 6 7 4 ") == true;
		lru.findInCache(1);
		assert lru.print().equalsIgnoreCase("1 4 7 6 5 3 2 |2 3 5 6 7 4 1 ") == true;
		lru.findInCache(7);
		assert lru.print().equalsIgnoreCase("7 1 4 6 5 3 2 |2 3 5 6 4 1 7 ") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("7 1 4 6 5 3 |3 5 6 4 1 7 ") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("7 1 4 6 5 |5 6 4 1 7 ") == true;
		lru.findInCache(6);
		assert lru.print().equalsIgnoreCase("6 7 1 4 5 |5 4 1 7 6 ") == true;
		lru.deleteFromCache(6);
		assert lru.print().equalsIgnoreCase("7 1 4 5 |5 4 1 7 ") == true;
		lru.addToCache(6);
		assert lru.print().equalsIgnoreCase("6 7 1 4 5 |5 4 1 7 6 ") == true;
		lru.deleteFromCache(4);
		assert lru.print().equalsIgnoreCase("6 7 1 5 |5 1 7 6 ") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("6 7 1 |1 7 6 ") == true;
		lru.deleteFromCache(7);
		assert lru.print().equalsIgnoreCase("6 1 |1 6 ") == true;
		lru.findInCache(6);
		assert lru.print().equalsIgnoreCase("6 1 |1 6 ") == true;
		lru.findInCache(1);
		assert lru.print().equalsIgnoreCase("1 6 |6 1 ") == true;
		lru.deleteFromCache(6);
		assert lru.print().equalsIgnoreCase("1 |1 ") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("|") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("|") == true;
		lru.evict();
		assert lru.print().equalsIgnoreCase("|") == true;
		lru.addToCache(3);
		lru.addToCache(4);
		lru.addToCache(5);
		lru.addToCache(6);
		lru.addToCache(7);
		assert lru.print().equalsIgnoreCase("7 6 5 4 3 |3 4 5 6 7 ") == true;
		lru.addToCache(1);
		lru.addToCache(2);
		lru.addToCache(8);
		lru.addToCache(9);
		lru.addToCache(10);
		assert lru.print().equalsIgnoreCase("10 9 8 2 1 7 6 5 4 3 |3 4 5 6 7 1 2 8 9 10 ") == true;
		lru.addToCache(11);
		assert lru.print().equalsIgnoreCase("11 10 9 8 2 1 7 6 5 4 |4 5 6 7 1 2 8 9 10 11 ") == true;
		lru.addToCache(12);
		assert lru.print().equalsIgnoreCase("12 11 10 9 8 2 1 7 6 5 |5 6 7 1 2 8 9 10 11 12 ") == true;
	}

	public String print() {
		LinkedListNode cur = cacheHead;
		StringBuilder sb = new StringBuilder();
		while(null!=cur) {
			sb.append(cur.val);
			sb.append(" ");
			cur = cur.next;
		}
		sb.append("|");
		cur = cacheTail;
		while(null!=cur) {
			sb.append(cur.val);
			sb.append(" ");
			cur = cur.previous;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}

/*

arr = 1, 4, 5, 6, 2, 3, 8
sum = 1, 5, 10, 16, 18, 21, 29
diff =  3, 1, 1, 4, 0, 5

4, 1, 6, 2, 5, 3, 8

1st position < move else swap
2nd position > move else swap



arr = 4, 1, 5, 2, 6, 3, 8
sum = 4, 5, 10, 12, 18, 21, 29
diff =  -3, 4, -3, 4, -3, 5
*/