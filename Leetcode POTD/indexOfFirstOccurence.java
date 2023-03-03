//Given two strings needle and haystack, 
//return the index of the first occurrence of needle in haystack, 
//or -1 if needle is not part of haystack.

public class indexOfFirstOccurence {
    public int strStr(String haystack, String needle) {
        
        int start = 0;
        int end = needle.length()-1;
        //make a sliding window of size of needle
         
        while(end<haystack.length()){
            String s = haystack.substring(start,end+1);
            // System.out.println(s);
            if(needle.equals(s)){
                return start;
            }
            start++;
            end++;
        }
        
        return -1;
    }
}
