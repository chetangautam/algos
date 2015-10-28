package org.java;

public class Cow implements Comparable<Cow>{

	private String color;
	 
	public Cow(String c) {
		color = c;
	}

	public String toString(){	
		return color + " cow";
	}

	public int hashCode() {
		int retVal = 0;
		char[] arr = color.toCharArray();
		for(int i = 0; i < arr.length; ++i) {
			int numericValue = Character.getNumericValue(arr[i]);
			//System.out.println(numericValue);
			retVal += numericValue;
		}
		//System.out.println("hashcode="+retVal);
		return retVal;
	}

	public boolean equals(Object o) {
		//return ((Cow)o).color.equals(this.color);
		return ((Cow)o).hashCode() == this.hashCode();
	}

	@Override
	public int compareTo(Cow arg0) {
		return this.hashCode() - ((Cow)arg0).hashCode();
	}

}
