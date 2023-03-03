import java.util.*;

public class bfs {
    public static void main(String[] args) {
        
    }

    public static void bfsGraph(List<List<Integer>> adj, int v, List<Integer> ans,boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        isVisited[v] = true;
        ans.add(v);

        while(!queue.isEmpty()){
            int it = queue.poll();

            for(int u : adj.get(it)){
                if(!isVisited[u]){
                    queue.add(u);
                    isVisited[u] = true;
                    ans.add(u);
                }
            }
        }
    }
}
