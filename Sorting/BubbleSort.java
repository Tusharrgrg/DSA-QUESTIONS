package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 8, 1, 4, 6, 8, 45, 6, 5, 5, 5, 5, 2, 47, 52, 68, 4, 2, 6959, 65, 54, 3, 3,
                5, 8, 6 };
        int n = arr.length;
        sort(arr, n);
        System.out.println(Arrays.toString(arr));        
    }

    static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap number using xor operation
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
}