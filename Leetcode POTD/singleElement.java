//Single element in sorted array

public class singleElement {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        
        while(start < end){
            
            int mid = start+(end-start)/2;
            
            if((mid%2 == 0 && arr[mid] == arr[mid+1]) ||
               (mid%2 == 1 && arr[mid] == arr[mid-1])){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return arr[start];
    }
}
