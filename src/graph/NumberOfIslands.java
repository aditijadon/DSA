package graph;

public class NumberOfIslands {
    static void dfs(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;

        grid[i][j] = 0;
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }


    static int countIslands(int[][] grid){
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,1},
                        {1,1,0,0,1},
                        {0,0,0,0,0},
                        {0,0,0,1,1}};

        System.out.println(countIslands(grid));
    }
}
