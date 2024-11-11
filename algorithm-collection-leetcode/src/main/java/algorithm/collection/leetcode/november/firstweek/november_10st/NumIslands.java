package algorithm.collection.leetcode.november.firstweek.november_10st;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * @author shadow
 * @create 2024-11-10 21:44
 **/
public class NumIslands {


    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j,boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if(i >= row || j >= col || i<0 || j<0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }

}
