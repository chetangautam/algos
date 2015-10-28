package org.java.sorting;

public class OnlyMedian {

    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int[] arr= new int[total];
        */
        int[] arr = {3, 5, 3, 6, 7, 8, 9, 3, 2, 4, 5};

        //1,2,3,3,3,4,5,5,6,7,8,9,  
        
        int total = arr.length;
        int mid = total/2;
        sort(arr,mid);
        if (total%2==1) {
            System.out.println( arr[mid]);
        } else {
            sort(arr, mid-1);
            System.out.println((arr[mid]+arr[mid-1])/2);
        }
    }

    public static void sort(int[] arr, int mid) {
        quickSort(arr, mid, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int mid, int low, int high) {
        if (low>=high) {
            return;
        }
        int pivot = getPivot(arr, low, high);
        if (pivot == mid) {
            return;
        } else if (pivot < mid) {
            quickSort(arr, mid, pivot+1, high);
        } else {
            quickSort(arr, mid, low, pivot-1);
        }
    }

    public static int getPivot(int[] arr, int low, int high) {
        int pivot = low;
        int pivotValue = arr[pivot];
        low++;
        while(low<=high) {
            if(arr[low] <= pivotValue) {
                swap(arr, low, pivot);
                pivot++;
                low++;
            } else {
                swap(arr, low, high);
                high--;
            }
        }
        return pivot;
    }

    public static void swap(int[] arr, int i , int j) {
        if(i==j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
