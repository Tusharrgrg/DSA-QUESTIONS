import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//Given an undirected graph with V vertices(numbered from 1 to V) and E edges. 
//Find the number of good components in the graph.
// A component of the graph is good if and only if the component is a fully connected component.

public class GoodComponenets {
    public static int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] arr = new boolean[V + 1];
        int count = 0;

        for (int i = 1; i <= V; i++) {

            if (!arr[i]) {

                ArrayList<Integer> result = new ArrayList<>();
                dfs(adj, arr, i, result);
                boolean flag = false;
                for (int j = 0; j < result.size(); j++) {
                    if (adj.get(result.get(j)).size() < result.size() - 1) {
                        flag = true;
                        break;

                    }
                }

                if (flag == false) {
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] arr, int v, ArrayList<Integer> result) {
        arr[v] = true;
        result.add(v);

        for (int u : adj.get(v)) {
            if (!arr[u]) {
                dfs(adj, arr, u, result);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int ans = findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
