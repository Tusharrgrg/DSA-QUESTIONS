
public class uniquePaths {
    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        System.out.println(uniquePaths1(n, m));
    }

    //optimal approach
    public static int uniquePaths1(int n, int m) {

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
