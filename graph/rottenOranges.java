import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public static int rotTime(int[][] grid, boolean[][] vis) {

        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                } else {
                    vis[i][j] = false;
                }
                if (grid[i][j] == 1) {
                    countFresh += 1;
                }
            }
        }
        int t = 0;
        int count = 0;

        while (!q.isEmpty()) {
            int[] arr = q.remove();
            int row = arr[0];
            int col = arr[1];
            int time = arr[2];

            t = Math.max(t, time);

            for (int rowdir = -1; rowdir < 2; rowdir++) {
                for (int coldir = -1; coldir < 2; coldir++) {
                    if (Math.abs(coldir) != Math.abs(rowdir)) {
                        int newRow = row + rowdir;
                        int newCol = col + coldir;

                        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                                && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                            q.add(new int[] { newRow, newCol, time + 1 });
                            vis[newRow][newCol] = true;
                            count++;
                        }
                    }
                }
            }

        }
        if (count != countFresh)
            return -1;
        return t;
    }
}
