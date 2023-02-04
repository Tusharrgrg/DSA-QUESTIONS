package graph;

import java.util.List;

public class dfs{


    public static void dfs_travere(List<List<Integer>> adj, boolean[] isVisited, int v , List<Integer> result){
        isVisited[v] = true;
        result.add(v);

        for(int i : adj.get(v)){
            if(isVisited[i] == false){
                dfs_travere(adj, isVisited, i, result);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}