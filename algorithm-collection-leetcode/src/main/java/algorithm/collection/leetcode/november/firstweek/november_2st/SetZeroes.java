package algorithm.collection.leetcode.november.firstweek.november_2st;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @author shadow
 * @create 2024-11-02 16:55
 **/
public class SetZeroes {


    /**
     * 方法一：使用标记数组
     * 思路和算法
     *
     * 我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
     *
     * 具体地，我们首先遍历该数组一次，如果某个元素为 0，那么就将该元素所在的行和列所对应标记数组的位置置为 true。最后我们再次遍历该数组，用标记数组更新原数组即可。
     *
     *
     * 复杂度分析
     *
     * 时间复杂度：O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。我们至多只需要遍历该矩阵两次。
     *
     * 空间复杂度：O(m+n)，其中 m 是矩阵的行数，n 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。
     *
     *
     *
     * @param matrix
     */
    public void setZeroes_V2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //一维数组，不要总是想着二维
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes.setZeroes(matrix);
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // 记录所有值为 0 的位置
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    dfs(matrix, i, j, visited);
                }
            }
        }
    }

    public void dfs(int[][] matrix,int row,int col,boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 标记当前元素为已访问
        visited[row][col] = true;

        // 将当前行的所有元素设为 0
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = 0;
                visited[row][j] = true;
            }
        }

        // 将当前列的所有元素设为 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = 0;
                visited[i][col] = true;
            }
        }

        // 继续递归处理相邻的行和列
        for (int j = 0; j < n; j++) {
            if (!visited[row][j] && matrix[row][j] == 0) {
                dfs(matrix, row, j, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i][col] && matrix[i][col] == 0) {
                dfs(matrix, i, col, visited);
            }
        }
    }

}
