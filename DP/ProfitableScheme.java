import java.util.*;

public class ProfitableScheme {
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit){

        return 0;
    }


    public static int helper(int index, int pro , int people , int n, int minprofit, int[]group, int[]profit){

        if (people > n) {
            return 0;
        }
    
        if (index == group.length - 1) {
            if (pro >= minprofit) {
                return 1;
            }
            return 0;
        }
    
        int notTaken = helper(index+1, pro, people, n, minprofit, group, profit);
        int taken = helper(index+1, Math.min(minprofit, pro + profit[index]), people+group[index], n, minprofit, group, profit);
    
        return notTaken + taken;
    }
}
