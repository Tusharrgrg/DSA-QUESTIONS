

import java.util.*;
public class ReducingDishes_1402{
     public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        long[][] t = new long[501][501];

        for(int i=0;i<501;i++){
            t[i][0] = 0;
        }

        t[0][1] = satisfaction[0];

        for(int i=1;i<n;i++){
            for(int time = 1;time<=n;time++){
                long include = satisfaction[i]*time + t[i-1][time-1];

                long exclude = 0 + t[i-1][time];

                t[i][time] = Math.max(include, exclude);
            }
        }
        long ans = 0;
        for(int time = 0;time <= n;time++){
            ans = Math.max(ans, t[n-1][time]);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[]satisfaction = {-1,-8,0,5,-7};
        int ans = maxSatisfaction(satisfaction);
        System.out.println(ans);
    }
}