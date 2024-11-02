package algorithm.collection.leetcode.november.firstweek.november_2st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 1    ->  2   ->  3
 *                  |
 * 4    ->  5       6
 * |                |
 * 7    <-  8   <-  9
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * @author shadow
 * @create 2024-11-02 20:43
 **/
public class SpiralOrder {

    /**
     * 1.空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
     * 2.初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
     * 3.循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环打印。
     *      a.根据边界打印，即将元素按顺序添加至列表 res 尾部。
     *      b.边界向内收缩 1 （代表已被打印）。
     *      c.判断边界是否相遇（是否打印完毕），若打印完毕则跳出。
     * 4.返回值： 返回 res 即可。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder_V1(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        Integer[] res = new Integer[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++)
                res[x++] = matrix[top][i]; // left to right
            if (++top > bottom)//当从左往右遍历后，上边界往下增1，如果上边界超过下边界则循环结束
                break;
            for (int i = top; i <= bottom; i++)
                res[x++] = matrix[i][right]; // top to bottom
            if (left > --right)//从上往下遍历，右边界减一，如果右边界越过左边界则循环结束
                break;
            for (int i = right; i >= left; i--)
                res[x++] = matrix[bottom][i]; // right to left
            if (top > --bottom)
                break;
            for (int i = bottom; i >= top; i--)
                res[x++] = matrix[i][left]; // bottom to top
            if (++left > right)
                break;
        }
        return Arrays.asList(res);
    }

    public List<Integer> spiralOrder_V2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        /**
         * 因为遍历数组的方向是固定的
         *    0.从左向右遍历，next_row = cur_row+0,next_col = cur_col+1
         *    1.从上往下遍历，next_row = cur_row+1,next_col = cur_col+0
         *    2.从右往左遍历，next_row = cur_row+0,next_col = cur_col-1
         *    3.从下往上遍历，next_row = cur_row-1,next_col = cur_col+0
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //0表示从左向右遍历
        int directionIndex = 0;
        //total是方格中的所有数据都遍历
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                //保证方向一直是从0-3的
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    public void dfs(int[][] matrix,int row,int col,List<Integer> ans) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        if(row < 0 || col<0 || row>=rowLen || col>=colLen || ans.contains(matrix[row][col])) {
            return;
        }
        ans.add(matrix[row][col]);
        if(col < colLen-1) {
            //向右
            dfs(matrix,row,col+1,ans);
        }

    }

}
