package org.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplePhoneBook {

	public static void main(String[] args) {
        try {
            BufferedReader is =
                    new BufferedReader(new InputStreamReader(System.in));
	        String sCount = is.readLine();
	        int count = Integer.valueOf(sCount).intValue();
	        Map<String, Integer> phoneBook = new HashMap<String, Integer>();
	        List<String> names = new ArrayList<String>();
            for (int i=0; i<count; ++i) {
                String name = is.readLine();
                String n = is.readLine();
                phoneBook.put(name, Integer.valueOf(n));
            }
        	String name = is.readLine();
	        while(name != null) {
	            names.add(name);
	            name = is.readLine();
	        }
	        is.close();
	        for(String str: names) {
	            Integer pNum = (Integer) phoneBook.get(str);
	            if(null == pNum) {
	                System.out.println("Not found");
	            } else {
	                System.out.print(str);
	                System.out.print("=");
                    System.out.print(pNum);
	                System.out.print("\n");
	            }
	        }
        } catch (IOException e) {
        	System.out.println(e);
        }

	}

}
