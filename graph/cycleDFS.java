import java.util.ArrayList;

public class cycleDFS {
    public static void main(String[] args) {
        
    }

    public static boolean cycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int v, int parent) {
        vis[v] = true;
        for (int u : adj.get(v)) {
            if (u == parent) {
                continue;
            } else if (vis[u] == true) {
                return true;
            } else {
                if (cycle(adj, vis, u, v)) {
                    return true;
                }
            }
        }
        return false;
    }
}
