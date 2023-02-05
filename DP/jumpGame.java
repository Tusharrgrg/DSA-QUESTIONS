package DP;

import java.util.Arrays;

public class jumpGame {

    //naive approach 
    //Tc = O(n^n)
    //Sc = O(n)

    static boolean jump(int[]nums, int idx){
        if(idx == nums.length-1){
            return true;
        }
        for(int i = 1; i<= nums[idx]; i++){
            if(jump(nums, idx+i) == true){
                return true;
            }
        }
        return false;
    }

    // memoization + recursion
    //TC = O(n)
    //SC = O(n)+O(n)

    static boolean[] arr = new boolean[10001];
    static boolean jump2(int[] nums, int idx){

        if(idx == nums.length-1){
            return true;
        }

        if(arr[idx]!= true){
            return false;
        }
        for(int i = 1; i<= nums[idx]; i++){
            if(jump2(nums, idx+i)){
                return arr[idx] = true;
            }
        }
        return false;
    }

    

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,2};
        System.out.println(jump(nums, 0));
        Arrays.fill(arr, true);
        System.out.println(jump2(nums, 0));
    }
}
