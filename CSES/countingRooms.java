import java.util.Scanner;


public class countingRooms {
    static boolean[][] vis = new boolean[1010][1010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for(int i = 0; i<n; i++){
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        // boolean[][]vis = new boolean[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '.' && vis[i][j] == false){
                    dfs(grid, i,j);
                    ++count;
                }
            }
        }
        System.out.println(count); 
    }

    private static void dfs(char[][]grid, int i, int j) {
        vis[i][j] = true;

        if(i<0 || j<0||j>=grid[0].length||i>=grid.length||vis[i][j] == false|| grid[i][j]!='.'){
            return;
        }
        // grid[i][j] = '.';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i ,j+1);
        dfs(grid, i, j-1);
    }
}
