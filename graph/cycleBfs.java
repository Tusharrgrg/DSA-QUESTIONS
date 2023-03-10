import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleBfs {

    static class pair{
        int first;
        int parent;
        public pair(int first,int parent){
            first = this.first;
            parent = this.parent;
        }
    }

    public static boolean cycle(ArrayList<ArrayList<Integer>>adj, int v,boolean[]vis ){
        vis[v] = true;
        Queue<pair> que = new LinkedList<>();
        que.add(new pair(v, -1));

        while(!que.isEmpty()){
            int node = que.peek().first;
            int parent = que.peek().parent;

            que.remove();

            for(int u:adj.get(node)){
                if(!vis[u]){
                    vis[u] = true;
                    que.add(new pair(u, node));
                }else{
                    if(parent!= u){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        boolean[] vis = new boolean[v];
        for(int i = 0; i<v; i++){
            if(!vis[i]){
                //run your cycle function.
            }
        }
    }
}
