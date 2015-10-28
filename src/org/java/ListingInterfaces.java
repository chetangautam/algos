package org.java;


public class ListingInterfaces {

	public static class Entry implements Comparable<Entry> {

		@Override
		public int compareTo(Entry o) {
			return 0;
		}
	}

	public static void main(String[] args) {
	    	Entry entry=new Entry();
	        System.out.print("I implemented: ");
	        ImplementedInterfaceNames(entry);

    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    public static void ImplementedInterfaceNames(Object o)
    {

        Class<?>[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++)
        {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
