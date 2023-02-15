package Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[]arr = {4,5,7,8,6,4,56,1,2,4,5,4,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[]arr){
        int n = arr.length;
        for(int i = 1; i<n; i++){
            int element = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>element){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
    }
}
