package org.java;

import java.util.Scanner;

public class InsertSort {

    public static void insertionSortPart2(int[] ar)
    {       
        int len = ar.length;
        for (int i=1; i<len; ++i) {
            insertSort(ar, i);
            printArray(ar);
        }
    }  
    
    public static void insertSort(int[] arr, int len) {
        int num=arr[len];
        int i = len-1;
        while(i>=0 && arr[i]>num) {
            arr[i+1]=arr[i];
            --i;
        }
        arr[i+1]=num;
    }    
      
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar); 
       in.close();
                    
    }
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
      System.out.println("");
   }
}
