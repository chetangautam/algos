package org.java;

public class TryFinals {

	int num;
	
	public final void increment() { ++num; }
	public int getNum() { return num; }
	public TryFinals() { num=0; }

	public static void main(String[] args) {
		TryFinals obj = new TryFinals();
		System.out.println(obj.getNum());
		obj.increment();
		System.out.println(obj.getNum());
	}

}
