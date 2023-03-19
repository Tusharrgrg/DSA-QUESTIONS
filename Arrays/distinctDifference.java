import java.util.*;

public class distinctDifference {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> findArray(int[] arr, int n) {
        // naive approach is that we can use set data structure and iterate through j =
        // o to j = i,
        // and j = i+1 to j = N and add diff. element in the set and finaly count
        // diffence.
        // it take upto O(n*n(log(n)));

        // so optimal approach is that storing the frequency of distinct
        // elements on the left and the right for each array element and then find the
        // resultant difference for each array element.TC-O(N) ---> SC-O(N)

        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        // Stores the frequency of array
        // element in the map rightMap
        for (int i = 0; i < n; i++) {
            if (rightMap.containsKey(arr[i])){
                rightMap.put(arr[i],rightMap.get(arr[i]) + 1);
            }
            else{
                rightMap.put(arr[i], 1);
            }
        }

        // Stores the resultant differences
        ArrayList<Integer> res = new ArrayList<>();

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Find the count in the left
            int countLeft = leftMap.size();

            // Decrement the frequency
            if (rightMap.get(arr[i]) > 1) {
                rightMap.put(arr[i],rightMap.get(arr[i]) - 1);
            } else {
                rightMap.remove(arr[i]);
            }

            // Find the count in the left
            int countRight = rightMap.size();

            // Insert the resultant difference
            res.add(Math.abs(countRight - countLeft));

            // Increment the frequency
            if (leftMap.containsKey(arr[i])){
                leftMap.put(arr[i],leftMap.get(arr[i]) + 1);
            }
            else{
                leftMap.put(arr[i], 1);
            }
        }
        return res;
    }
}