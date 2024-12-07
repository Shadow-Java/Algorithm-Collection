package algorithm.collection.leetcode.november.firstweek.november_2st;

import algorithm.collection.common.datastruct.linklist.ListNode;

import java.util.Arrays;

/**
 * 2326. 螺旋矩阵 IV
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 *
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 *
 * 输入：m = 1, n = 4, head = [0,1,2]
 * 输出：[[0,1,2,-1]]
 * 解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 *
 * @author shadow
 * @create 2024-12-07 16:28
 **/
public class SpiralMatrix {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] director = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int row = 0;
        int col = 0;
        // 定义开始的方向为向右
        int directorIndex = 0;
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(matrix[i], -1);
        }
        //为什么要定义visited，因为走一个方向中途会转向；比如7走到4，不会从4走到1，因为1访问过了
        boolean[][] visited = new boolean[m][n];
        while (head != null) {
            matrix[row][col] = head.val;
            visited[row][col] = true;
            //提前计算下一个位置，看下一个位置是否需要转向
            int nextRow = row + director[directorIndex][0];
            int nextCol = col + director[directorIndex][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || visited[nextRow][nextCol]) {
                //当下一个位置不合法，则需要转向；使用求余能保证一直在在四个方向转悠
                directorIndex = (directorIndex + 1) % 4;
            }
            row = row + director[directorIndex][0];
            col = col + director[directorIndex][1];
            head = head.next;
        }
        return matrix;
    }

}
