import java.util.*;

public class DirectedCycle {
    public static boolean directedDFS(ArrayList<ArrayList<Integer>> adj, boolean[] path, boolean[] vis, int v){
        path[v] = true;
        
        vis[v] = true;
        for(int i:adj.get(v)){
            if(!vis[i]){
                if(directedDFS(adj, path, vis, i)==true){
                    return true;
                }
            }else if(path[i]){
                return true;
            }
        }
        path[v] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] path =new boolean[v];
        boolean[] vis = new boolean[v];

        for(int i = 0; i<v; i++){
            if(!vis[i]){
                if(directedDFS(adj, path, vis, i) == true)return true;
            }
        }
        return false;
    }
}
