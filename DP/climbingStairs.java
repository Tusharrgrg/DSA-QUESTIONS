package DP;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbing3(n));
    }

    public static int climbing1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return climbing1(n - 1) + climbing1(n - 2);
    }

    // Tc - O(n) : SC - O(n)
    public static int climbing2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Space optimization SC- O(1)

    public static int climbing3(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for(int i = 2; i<=n; i++){
            int curr_i = prev1+prev2;
            prev2 = prev1;
            prev1 = curr_i;
        }
        return prev1;
    }
}
