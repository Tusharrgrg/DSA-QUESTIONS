public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1,4,5,7,8,9,11,19,25,36,48,58,69};
        int target = 21;
        System.out.println(searchInsert(nums, target));
    }
}
