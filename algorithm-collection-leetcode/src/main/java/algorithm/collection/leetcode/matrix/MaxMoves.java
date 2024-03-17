package algorithm.collection.leetcode.matrix;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.doublepointer.NextGreaterElementIII;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 *
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 *
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 *
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 *
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 * @author shadow
 * @create 2024-03-16 16:10
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "2684",
        questionTitle = "矩阵中移动的最大次数",
        relevateClass = NextGreaterElementIII.class,
        desc = "给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。",
        questionLink = "https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/?envType=daily-question&envId=2024-03-16",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MaxMoves {

    private static int maxDepth=0;

    /**
     * 延伸图的最大深度，矩阵的最大深度
     *
     * 求的是矩阵的最大深度，并不是最大宽度，并且有回溯的过程
     * @param grid
     * @return
     */
    public static int dfsMaxMoves(int[][] grid) {
        /**
         * 访问过的节点
         */
        List<Node> visited = new ArrayList<>();
        /**
         * 记录遍历顺序
         */
        List<Node> list = new ArrayList<>();
        if(grid == null) {
            return maxDepth;
        }
        int curDepth = 0;
        for(int row = 0;row< grid.length;row++) {
            dfs(grid,row,0,visited,list,curDepth);
        }
        return maxDepth;
    }

    public static void dfs(int[][] grid,int row,int col,List<Node> visited,List<Node> list,int curDepth) {
        Node curNode = new Node(row,col,grid[row][col]);
        visited.add(curNode);
        list.add(curNode);
        curDepth++;
        if(col>= grid[0].length-1) {
            list.clear();
            maxDepth = Math.max(curDepth,maxDepth);
            return;
        }
        for(int curRow =0;curRow < grid.length;curRow++) {
            int curVal = grid[curRow][col+1];
            if(curVal> grid[row][col]) {
                dfs(grid,curRow,col+1,visited,list,curDepth);
                visited.remove(new Node(curRow,col+1,grid[curRow][col+1]));
            }
        }

    }


    private int ans;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid); // 从第一列的任一单元格出发
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) { // ans 已达到最大值
            return;
        }
        // 向右上/右/右下走一步
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(k, j + 1, grid);
            }
        }
        //避免重复访问，将格子值置为0，因为最大就只能为grid[0].length
        grid[i][j] = 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid[0] = new int[]{2,4,3,5};
        grid[1] = new int[]{5,4,9,3};
        grid[2] = new int[]{3,4,2,11};
        grid[3] = new int[]{10,9,13,15};
        dfsMaxMoves(grid);
    }


    static class Node {
        int row;
        int col;
        int val;
        public Node(int row,int col,int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

}
