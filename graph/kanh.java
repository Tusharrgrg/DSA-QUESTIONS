import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kanh {
    public static List<Integer> topological(ArrayList<ArrayList<Integer>>adj, int V){
        

        int[]indegree = new int[V];
        Queue<Integer>queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();


        //just calculate the indegree of vertices
        for(int i = 0; i<V;i++){
            for(int u:adj.get(i)){
                indegree[u]++;
            }
        }

        //if indegree of vertices is zero then add it into queue
        for(int i = 0; i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            for(int u:adj.get(node)){
                indegree[u]--;
                if(indegree[u] == 0){
                    queue.add(u);
                }
            }
        }

        return topo;
    }
}
