package org.java;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PairCount {

	public static class Entry implements Comparable<Entry> {
		public String fname;
		public String sname;
		public Entry(String fn, String sn) {
			this.fname = fn;
			this.sname = sn;
		}
		public boolean equals(Object o) {
			boolean retVal = o!= null && 
					o instanceof Entry &&
					this.fname.compareTo(((Entry)o).fname) == 0 && 
					this.sname.compareTo(((Entry)o).sname) == 0 ;
			return retVal;
		}
		public int hashCode() {
			int hc = 0;
			int l1 = this.fname.length();;
			hc += l1;
			hc -= Character.getNumericValue(this.fname.charAt(0));
			hc += Character.getNumericValue(this.fname.charAt(l1-1));
			hc -= Character.getNumericValue(this.fname.charAt(l1/2));
			int l2 = this.sname.length();;
			hc += l2;
			hc -= Character.getNumericValue(this.sname.charAt(0));
			hc += Character.getNumericValue(this.sname.charAt(l2-1));
			hc -= Character.getNumericValue(this.sname.charAt(l2/2));
//			for(int i=0; i<this.fname.length();++i) {
//				hc += Character.getNumericValue(this.fname.charAt(i));
//			}
//			for(int i=0; i<this.sname.length();++i) {
//				hc += Character.getNumericValue(this.sname.charAt(i));
//			}
			return hc;
		}

		@Override
		public int compareTo(Entry o) {
			if(this.equals(o)) {
				return 0;
			} else {
				if (this.fname.compareTo(o.fname) == 0) {
					return this.sname.compareTo(o.sname);
				} else {
					return this.fname.compareTo(o.fname);
				}
			}
		}
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		Set<Entry> hs = new TreeSet<Entry>();
		int count= 0;
		for(int i=0; i< total; ++i) {
			String fname = in.next();
			String sname = in.next();
			Entry e = new Entry(fname, sname);
			boolean res = hs.contains(e);
			if (res == false) {
				hs.add(e);
				count++;
			}
			System.out.println(count);
		}
		in.close();
	}

}
