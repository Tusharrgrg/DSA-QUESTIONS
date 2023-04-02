import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public static int minimumSpanning(int V, int E, int edges[][]){
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        //make adjacency list of given vertices and edges
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] vis = new boolean[V];
        pq.add(new int[]{0,0});
        // vis[0] = true;
        int sum = 0;
        while(!pq.isEmpty()){
            int [] node = pq.remove();
            int wt = node[0];
            int u = node[1];

            //if node is alredy visited then no need to travarse again
            if(vis[u] == true){
	            continue;
	        }
	        vis[u] = true;
	        sum += wt;
	        
            for(int i = 0; i<adj.get(u).size(); i++){
                int nwt = adj.get(u).get(i)[1];
                int v = adj.get(u).get(i)[0];

                if(!vis[v]){
                    pq.add(new int[]{v,nwt});
                }

            }
        }
        return sum;
    }
}
