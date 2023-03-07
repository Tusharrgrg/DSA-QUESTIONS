public class minTimeToCompleteTrips {

    //Brute force method- give TLE for large inputs
    public long minimumTime(int[] time, int totalTrips) {
        long sum = 0;
        long t = 1;
        
        while(true){
            for(int i = 0; i<time.length; i++){
                sum+= t/time[i];
            }
            if(sum>=totalTrips){
                return t;
            }else{
                t++;
                sum = 0;
            }
        }
        // return 0;
    }

    //optimal solution using binary search
    
}
