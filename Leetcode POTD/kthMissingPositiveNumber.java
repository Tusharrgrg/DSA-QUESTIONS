public class kthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        int count =0;
        
        for(int i =0; i<arr.length;){
            if(num!= arr[i]){
                num++;
                count++;
            }
            else if(num == arr[i]){
                num++;
                i++;
            }
            if(count == k){
                return num-1;
            }
        }
        if(count!=k){
            while(count!=k){
                num++;
                count++;
            }
        }
        return num-1;
    }
}
