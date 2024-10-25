package algorithm.collection.primary.tree;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        int numIslands = countIslands(grid);
        System.out.println("Number of islands: " + numIslands);
    }

    /**
     * 给你一个int[][] grid，数组里由1和0构成，当0包围1时认为是一个岛屿，请计算有多少个岛屿；
     * @param grid
     * @return
     */
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int numIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // Explore all 4 possible directions
        dfs(grid, i + 1, j, visited); // Down
        dfs(grid, i - 1, j, visited); // Up
        dfs(grid, i, j + 1, visited); // Right
        dfs(grid, i, j - 1, visited); // Left
    }

}
