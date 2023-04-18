import java.util.Arrays;

public class Dungeon {

    static int [][]dp = new int[201][201];

    public static int calculateMinimumHP(int[][]dungeon ){
        if(dungeon == null || dungeon.length == 0){
            return 0;
        }
        for(int []arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return memeo(0, 0, dungeon);
        // return 0;
    }

    public static int memeo(int i, int j, int[][]dungeon){
        if(i>=dungeon.length || j >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int healthPoint = Math.min(memeo(i+1, j, dungeon), memeo(i, j+1, dungeon));

        if(healthPoint == Integer.MAX_VALUE){
            healthPoint = 1;
        }

        if(healthPoint-dungeon[i][j]>0){
            dp[i][j] = healthPoint-dungeon[i][j];
        }else{
            dp[i][j] = 1;
        }
        return dp[i][j];
    }
}
