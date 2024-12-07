package algorithm.collection.leetcode.november.firstweek.november_2st;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *   每行的元素从左到右升序排列。
 *   每列的元素从上到下升序排列。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * @author shadow
 * @create 2024-11-02 21:24
 **/
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix,5));
    }

    /**
     * 利用特性构建的二叉搜索树，以右下角为二叉树的顶点(rowLen-1,0)
     * 并且要查找目标数只有两个方向，往上或者往右
     * 我们将矩阵逆时针旋转 45° ，并将其转化为图形式，发现其类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、右分支元素更大。因此，通过从 “根节点” 开始搜索，遇到比 target 大的元素就向左，反之向右，即可找到目标值 target
     *
     * 为什么能用二分的形式查找，是因为旋转45度是一棵二叉搜索树
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix_V2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            //往上走
            if (matrix[i][j] > target){
                i--;
            } else if (matrix[i][j] < target) {
                //往右走
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        for (int i=0;i< matrix[0].length;i++) {
            ans = ans || dfs(matrix,0,i,target);
        }
        return ans;
    }

    /**
     * 超出时间限制
     * @param matrix
     * @param row
     * @param col
     * @param target
     * @return
     */
    public boolean dfs(int[][] matrix,int row,int col,int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        if(row >= rowLen || col >= colLen || matrix[row][col] > target) {
            return false;
        }
        if(matrix[row][col] == target) {
            return true;
        } else {
            //向下找
            boolean bottomExist = dfs(matrix,row+1,col,target);
            //向右找
            boolean rightExist = dfs(matrix,row,col+1,target);
            return bottomExist || rightExist;
        }
    }

}
