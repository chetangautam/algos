package org.java;

import java.util.TreeMap;
import java.util.Map.Entry;

public class TryTreeMap {

	public static void main(String[] args) {
		/*
		 * TreeMap
		 */
		/*******************************************/
		TreeMap<Cow, Integer> cowsTM = new TreeMap<Cow, Integer>();
		Cow cow1 = new Cow("white"); //hashCode 110
		Cow cow2 = new Cow("black"); //hashCode 74
		Cow cow3 = new Cow("brown"); //hashCode 117
		Cow cow4 = new Cow("white"); //hashCode 110
		cowsTM.put(cow1, 5);
		cowsTM.put(cow2, 15);
		cowsTM.put(cow3, 25);
		cowsTM.put(cow4, 35);
		for(Entry<Cow, Integer> e: cowsTM.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue() + " - hashCode:" + e.getKey().hashCode());
		}
		System.out.println("----------------------");
		/*******************************************/

	}

}
