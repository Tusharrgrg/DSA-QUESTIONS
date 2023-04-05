public class MaxSubarray{
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        //TC - O(N) 
        //This algo also known as Kadane Algorithm
        for(int i = 0; i<nums.length; i++){
            sum+= nums[i];
            if(maxSum<sum){
                maxSum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return maxSum;
    }
}