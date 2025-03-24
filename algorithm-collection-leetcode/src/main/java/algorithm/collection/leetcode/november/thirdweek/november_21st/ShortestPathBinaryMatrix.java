package algorithm.collection.leetcode.november.thirdweek.november_21st;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * @author shadow
 * @create 2025-03-24 23:02
 **/
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid.length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });// 加入头结点，宽度优先搜索二维数组
        int minSteps = 1;
        boolean[][] visited = new boolean[n][m];// 因为需要四个方向，索引仍然会回溯，需要看是否已经被访问
        visited[0][0] = true;
        // 定义四个方向
        int[][] directors = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
                { -1, 1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pin = queue.poll();
                if (pin[0] == n - 1 && pin[1] == m - 1) {
                    return minSteps;
                }
                visited[pin[0]][pin[1]] = true;
                for (int j = 0; j < 8; j++) {
                    int[] dir = directors[j];
                    int nextX = pin[0] + dir[0];
                    int nextY = pin[1] + dir[1];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || 1 == grid[nextX][nextY]
                            || visited[nextX][nextY]) {
                        continue;
                    }
                    queue.add(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
            minSteps++;
        }
        return -1;
    }

}
