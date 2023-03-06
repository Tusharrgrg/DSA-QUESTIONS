import java.util.LinkedList;
import java.util.Queue;

class pair {
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberofIslands {
    public static int numIslands(char[][] grid) {

        int count = 0;
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    // using dfs traversal

    public static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    // using bfs traversal

    public static void bfs(char[][] grid, boolean[][] vis, int ro, int co) {
        Queue<pair> queue = new LinkedList<>();
        vis[ro][co] = true;

        queue.add(new pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;

            queue.remove();

            for (int Rdir = -1; Rdir < 2; Rdir++) {
                for (int Cdir = -1; Cdir < 2; Cdir++) {

                    if (Rdir != Math.abs(Cdir)) {
                        int newRow = row + Rdir;
                        int newCol = col + Cdir;

                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol]
                                && grid[newRow][newCol] == '1') {
                            vis[newRow][newCol] = true;
                            queue.add(new pair(newRow, newCol));
                        }
                    }

                }
            }
        }

    }

}
