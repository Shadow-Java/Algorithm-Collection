package algorithm.collection.leetcode.november.firstweek.november_2st;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * @author shadow
 * @create 2024-12-07 15:59
 **/
public class GenerateMatrix {

    /**
     * 1    ->  2   ->  3
     *                  |
     * 4    ->  5       6
     * |                |
     * 7    <-  8   <-  9
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] director = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int row = 0;
        int col = 0;
        // 定义开始的方向为向右
        int directorIndex = 0;
        int[][] matrix = new int[n][n];
        //为什么要定义visited，因为走一个方向中途会转向；比如7走到4，不会从4走到1，因为1访问过了
        boolean[][] visited = new boolean[n][n];
        for (int i = 1; i <= total; i++) {
            matrix[row][col] = i;
            visited[row][col] = true;
            //提前计算下一个位置，看下一个位置是否需要转向
            int nextRow = row + director[directorIndex][0];
            int nextCol = col + director[directorIndex][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || visited[nextRow][nextCol]) {
                //当下一个位置不合法，则需要转向；使用求余能保证一直在在四个方向转悠
                directorIndex = (directorIndex + 1) % 4;
            }
            row = row + director[directorIndex][0];
            col = col + director[directorIndex][1];
        }
        return matrix;
    }

}
