//Capacity To Ship Packages Within D Days

public class shipCapacity {
    public static int shipWithinDays(int[] arr, int days) {
        int li = 0;
        int hi = 0;
        int sum =0, max = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum+arr[i];
            max = Math.max(max, arr[i]);
        }
        
        if(arr.length == days){
            return max;
        }
        
        li = max;
        hi = sum;
        
        while(li<=hi){
            int mid = li+(hi-li)/2;
            
            if(isPosible(arr,mid, days) == true){
                hi =  mid-1;
            }
            else{
                li = mid+1;
            }
        }
        return li;
    }
    
    static boolean isPosible(int[]arr, int mid, int days){
        int sum =0;
        int d = 1;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];
            if(sum > mid){
                d++;
                sum = arr[i];
            }
        }
        return d<= days;
    }
}
