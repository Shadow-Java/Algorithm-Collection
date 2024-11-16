package algorithm.collection.leetcode.november.firstweek.november_10st;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * @author shadow
 * @create 2024-11-10 22:05
 **/
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (fresh > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    queue.add(new int[]{r - 1, c});
                }
                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }

        if (fresh > 0) {
            return -1;
        } else {
            return round;
        }
    }


    /**
     * 1、橘子最后不能有新鲜的，即得全部腐烂
     * 2、经过的分钟数得最小
     *
     * @param grid
     * @return
     */
    public int orangesRottingV2(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int fresh = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    //保存腐烂橘子坐标
                    queue.add(new int[]{r, c});
                }
            }
        }
        //定义四个方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty() && fresh > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];
                    //查看数组下标是否越界
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
                        continue;
                    }
                    //将新鲜的橘子设置为腐烂的橘子
                    grid[row][col] = 2;
                    //腐烂的橘子入队
                    queue.offer(new int[]{row, col});
                    //新鲜橘子减一
                    fresh--;
                }
            }
            time++;
        }
        return fresh > 0 ? -1 : time;
    }

}
