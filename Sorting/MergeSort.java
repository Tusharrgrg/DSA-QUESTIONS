package Sorting;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[]arr = {1,8,6,4,5,9,7,12,5,3,5,6,2,63,5,2,3,6,5};
        merge(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int[]arr, int first, int last){
        int mid = first+(last-first)/2;
        if(last-first == 1){
            return;
        }
        merge(arr, first, mid);
        merge(arr, mid, last);
        sort(arr, first, mid, last);
    }

    static void sort(int[] arr, int start, int mid, int end) {
        int i = start, j = mid;
        int k = 0;
        int[] ans = new int[end-start];
        while(i<mid && j < end){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            }else{
                ans[k++] = arr[j++];
            }
        }
        while(i<mid){
            ans[k++] = arr[i++];
        }
        while(j<end){
            ans[k++] = arr[j++];
        }

        for(int a = 0; a < ans.length; a++){
            arr[start+a] = ans[a];
        }
    }
}
