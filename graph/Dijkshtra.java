import java.util.*;

public class Dijkshtra {
    
   public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
       
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //taking min heap to store dis,vertices pair 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[] { 0, S });

        dis[S] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.remove();

            int u = node[1];
            int d = node[0];

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).get(0);
                int edw = adj.get(u).get(i).get(1);

                if (edw + d < dis[v]) {
                    dis[v] = edw + d;
                    pq.add(new int[] { edw + d, v });
                }

            }
        }

        return dis;

    }
}
