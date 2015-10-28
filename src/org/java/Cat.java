package org.java;

public class Cat {

	private String color;
	 
	public Cat(String c) {
		color = c;
	}

	public String toString(){	
		return color + " cat";
	}

	public int hashCode() {
		/*int retVal = 0;
		char[] arr = color.toCharArray();
		for(int i = 0; i < arr.length; ++i) {
			retVal += Character.getNumericValue(arr[i]);
		}*/
		return color.length();
	}

	public boolean equals(Object o) {
		return ((Cat)o).color.equals(this.color);
		//return ((Cat)o).hashCode() == this.hashCode();
	}

}
