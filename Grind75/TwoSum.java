import java.util.HashMap;

public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        //TC - O(N) SC - O(N)
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int first = i;
                int second = map.get(target-nums[i]);
                return new int[]{first,second};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}