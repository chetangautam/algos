package org.java.arrays;

public class AddRemoveChars {

	public static void main(String[] args) {

		String str1 = "abcdez";
		String str2 = "aabb";
		
		System.out.println(addremoveCharacters(str1));
		System.out.println(addremoveCharacters(str2));
	}
	
	static String addremoveCharacters(String strInput) {
		int aCtr =0, bCtr = 0;
		for (int i=0; i<strInput.length(); ++i) {
			if (strInput.charAt(i)=='a') {
				aCtr++;
			}
			if (strInput.charAt(i)=='b') {
				bCtr++;
			}
		}
		int len = strInput.length()-bCtr+aCtr+aCtr;
		char[] arr = new char[len];
		for (int i = 0, j=0; i<len; ++i, ++j) {
			if(strInput.charAt(j)=='a') {
				arr[i] = 'z';
				i++;
				arr[i] = 'z';
			} else 
			if(strInput.charAt(j)=='b') {
				// do nothing
			} else {
				arr[i] = strInput.charAt(j);
			}
		}
		return new String(arr);
    }
}
