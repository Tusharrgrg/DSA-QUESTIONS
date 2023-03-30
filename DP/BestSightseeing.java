//https://leetcode.com/problems/best-sightseeing-pair/
// You are given an integer array values where values[i] represents the value of the ith sightseeing spot. 
//Two sightseeing spots i and j have a distance j - i between them.
// The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: 
//the sum of the values of the sightseeing spots, minus the distance between them.
// Return the maximum score of a pair of sightseeing spots.

public class BestSightseeing {

    public static void main(String[] args) {
        int [] arr = {967,607,644,202,24,715,18,184,782,185,771,505,974,622,889,73,516,904,30,362,262,599,791,339,667,778,781,34,44,317,452,867,125,565,160,14,601,99,962,175,922,1000,749,433,986,26,562,809,771,668,652,427,786,647,620,735,127,523,453,414,101,577,691,674,222,208,459,560,588,658,49,86,978,16,943,793,506,616,277,294,667,798,12,709,552,513,
            644,687,818,108,310,275,590,586,140,574,902,652,189,769,239,954,659,902,62,294,417,269,372,367,58,149,489,246,
            413,812,740,499,675,359,556,927,153,979,261,381,410,217,276,285,822,534,827,450,470,36,300,491,734,192,585,
            710,742,46,70,830,370,985,31,885,574,310,488,288,633,441,789,931,658,474,223,428,810,720,963,142,137,442,479,
            111,299,673,623,161,341,374,334,53,268,83,235,945,838,78,524,112,832,311,108,169,688,781,392,739,576,559,840,
            377,713,879,800,576,9,69,651,807,52,3,327,6,311,219,425,896,894,147,179,123,342,152,155,508,766,624,392,220,
            697,727,712,246,688,723,263,51,515,396,187,167,618,523,704,46,745,498,406,708,398,683,831,184,787,103,528,991,656,22,165,6,581,27,11,745,429,373,773,
            405,207,274,876,294,393,678,241,521,414,862,194,693,715,573,784,352,858,846,325,195,825,214,655,883,390,323,799,135,668,782,302,643,
            };

         System.out.println(maxScoreSightseeingPair1(arr));   
    }

    // Bruteforce Approach TC- O(n*n), SC- O(1)

    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int value = values[i] + values[j] + i - j;
                // if current score is greater then maxScore the update maxScore
                if (value > maxScore) {
                    maxScore = value;
                }
            }
        }
        return maxScore;
    }


    // optimal approach 
    public static int maxScoreSightseeingPair1(int[] values){
        int res = 0;
        int max = values[0];

        for(int i = 0; i<values.length; i++){
            res = Math.max(res, max+values[i]-i);
            max = Math.max(max, i+values[i]);
        }
        return res;
    }
}
