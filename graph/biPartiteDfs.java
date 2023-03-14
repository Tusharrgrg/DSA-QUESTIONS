import java.util.*;
public class biPartiteDfs {
    public static boolean isPartite(ArrayList<ArrayList<Integer>>adj,int[]color,int col,int start){
        // vis[start] = true;
        color[start] = col;

        for(int u:adj.get(start)){
            if(color[u]==-1){
                if(isPartite(adj, color, 1-col, u) == false)return false;
            }else if(color[u] == col){
                return false;
            }
        }
        return true;
    }

    public static boolean isBiPartite(ArrayList<ArrayList<Integer>>adj,int V){
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i<V;i++){
            if(color[i] ==-1){
                if(isPartite(adj, color, 0, i) == false) return false;
            }
        }
        return true;
    }
}
