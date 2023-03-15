public class EvantualSafeState {
    public static boolean CountSafe(int[][]graph,boolean[]vis,boolean[]path,int[]check,int start){
        vis[start] = true;
        path[start] = true;

        for(int u:graph[start]){
            if(!vis[start] && CountSafe(graph, vis, path, check, start) == true){
                return true;
            }else if(path[u] == true){
                return true;
            }
        }
        path[start] = false;
        check[start] = 1;
        return false;
    }
}
