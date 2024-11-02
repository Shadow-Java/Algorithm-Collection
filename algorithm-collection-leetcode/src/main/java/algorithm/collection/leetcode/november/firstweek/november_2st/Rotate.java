package algorithm.collection.leetcode.november.firstweek.november_2st;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * @author shadow
 * @create 2024-11-02 23:46
 **/
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++)
            tmp[i] = matrix[i].clone();
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }

    /**
     *
     * @param matrix
     */
    public void rotate_V2(int[][] matrix) {
        int left = 0,right = matrix.length-1;
        while (left < right) {
            for (int i=0;i < right - left;i++) {
                //上边界和下边界
                int top = left,bottom = right;
                //暂存左顶端的值
                int topLeft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = topLeft;
            }
            //一圈结束，移动相对left为1的位置
            ++left;
            --right;
        }
    }

}
