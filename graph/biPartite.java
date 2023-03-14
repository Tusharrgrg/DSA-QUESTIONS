import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class biPartite{
    public static boolean isPartite(ArrayList<ArrayList<Integer>> adj,int[]color,int v){

        Queue<Integer>queue = new LinkedList<>();
        color[v] = 1;
        queue.add(v);
        while(!queue.isEmpty()){
            int e = queue.peek();
            queue.remove();
            for(int u:adj.get(e)){
                if(color[u] == -1){
                    queue.add(u);
                    color[u] = 1-color[e];
                }else{
                    if(color[u]==color[e]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isBiPartite(ArrayList<ArrayList<Integer>> adj, int V){
        int []color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i<V;i++){
            if(color[i]==-1){
                if(isPartite(adj, color, i) ==false){
                    return false;
                }
            }
        }
        return true;
    }
}