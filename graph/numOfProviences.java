import java.util.*;

public class numOfProviences {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjli = new ArrayList<ArrayList<Integer>>();

        for(int i =0; i<V; i++){
            adjli.add(new ArrayList<Integer>());
        }

        for(int i =0; i<V; i++){
            for(int j =0;j<V; j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjli.get(i).add(j);
                    adjli.get(j).add(i);
                }
            }
        }
        int count = 0;
        
        boolean[] isVisited = new boolean[V+1];
        
        for(int i = 0; i<V; i++){
            if(!isVisited[i]){
                count++;
                dfs(adjli,isVisited,i);
            }
        }
        
        return count;
    }
    
     public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int v){
        isVisited[v] = true;
        // result.add(v);

        for(int i : adj.get(v)){
            if(isVisited[i] == false){
                dfs(adj, isVisited, i);
            }
        }
    }
}
