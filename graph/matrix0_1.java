import java.util.LinkedList;
import java.util.*;

public class matrix0_1 {

    public static void bfs(int[][]mat, boolean[][]vis, int[][]dis){

        Queue<int[]>pq = new LinkedList<>();

        for(int i = 0; i<mat.length; i++){
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    pq.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        while(!pq.isEmpty()){
            int [] arr = pq.remove();
            int row = arr[0];
            int col = arr[1];
            int d = arr[2];
            dis[row][col] = d;

            for(int i = -1; i<2;i++){
                for(int j = -1; j<2; j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int newRow = row+i;
                        int newCol = col+j;

                        if(newRow>=0 && newCol>=0 &&newRow<mat.length&&newCol<mat[0].length&&!vis[newRow][newCol]){
                            pq.add(new int[] { newRow, newCol, d + 1 });
                            vis[newRow][newCol] = true;
                        }
                    }
                }
            }
        }

    }
}
