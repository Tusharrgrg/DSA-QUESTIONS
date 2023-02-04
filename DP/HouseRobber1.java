package DP;

import java.util.Arrays;

public class HouseRobber1 {

    // basically this a pic or non pic type of problem 
    // which can be solved using recursion
    //

    // 1 . naive approach(recursion)
    // time complexity for this approach = O(2^n);
    // space complexity = O(n)

    public static int rob1(int[] houses, int index) {
        if (index < 0) {
            return 0;
        }
        int pic = houses[index] + rob1(houses, index - 2);
        int non_pic = 0 + rob1(houses, index - 1);
        return Math.max(pic, non_pic);
    }

    // 2 . memoization approach - as pic and non pic overlapping in recursion tree
    // so
    // it will be better to store them in an array
    // time complexity = O(n);
    // space complexity = O(n)+O(n);

    static int[] memo = new int[100001];

    public static int rob2(int[] houses, int index) {
        if (index < 0) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int pic = houses[index] + rob1(houses, index - 2);
        int non_pic = 0 + rob1(houses, index - 1);
        return memo[index] = Math.max(pic, non_pic);
    }

    // 3. Iterative+memo (Bottom up Approach)
    // time complexity = O(n);
    // space complexity = O(n);

    public static int rob3(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        int[] dp = new int[houses.length + 1];
        dp[0] = 0;
        dp[1] = houses[0];
        for (int i = 1; i < houses.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + houses[i], dp[i]);
        }
        return dp[houses.length];
    }

    // 4. Iterative + 2 Variable Approach
    // as in previous approach we only use dp[i], dp[i-1] (two steps)
    // so going just 2 steps back. We can hold them in 2 variables instead.

    public static int rob4(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;

        for (int i  = 0; i< houses.length; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + houses[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] houses = { 2, 7, 9, 3, 1 };
        System.out.println(rob1(houses, houses.length - 1));
        Arrays.fill(memo, -1);
        System.out.println(rob2(houses, houses.length - 1));
        System.out.println(rob3(houses));
        System.out.println(rob4(houses));
    }
}
