package intermittent.lying.continuous.progress.deprecated;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for(int r=0;r<grid.length;r++){//纵坐标
            for(int c=0;c<grid[0].length;c++){//横坐标
                if(grid[r][c] == 1){//只有方格节点才遍历
                    return dfs(grid,r,c);
                }
            }
        }
        return 0;
    }
    //以自身节点为坐标，向上下左右进行遍历
    //遍历过的节点，置为2，防止重复遍历
    int dfs(int[][] grid,int r,int c){
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length))//如果是边界方格，则加1
            return 1;

        if(grid[r][c] == 0)//从岛屿节点到水域节点，自动加1
            return 1;

        if (grid[r][c] != 1)//不是方格节点，退出
            return 0;

        grid[r][c] = 2;//记录已经遍历的节点，防止重复遍历

        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);

    }

}
