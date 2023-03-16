import java.util.*;

public class wordLadder1 {

    static class pair{
        String first;
        int second;
        public pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static int countSteps(String start, String target, ArrayList<String>worldList){

        //define a queue to use bfs algorithm for this problem
        Queue<pair>q = new LinkedList<>();

        //initialize a set table for keep traking words
        Set<String> set = new HashSet<>();

        for(int i = 0; i<worldList.size(); i++){
            set.add(worldList.get(i));
        }

        q.add(new pair(start, 1));
        set.remove(start);

        while(!q.isEmpty()){
            int steps = q.peek().second;
            String word = q.peek().first;

            q.remove();
            if(word.equals(target)) return steps;
            
            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] toreplace = word.toCharArray();
                    toreplace[i] = ch;
                    String newWord = new String(toreplace);

                    if(set.contains(newWord)){
                        q.add(new pair(newWord, steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
