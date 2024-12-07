package algorithm.collection.leetcode.november.firstweek.november_2st;

import java.util.ArrayList;
import java.util.List;

/**
 * 885. 螺旋矩阵 III
 *
 * 在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 *
 * 你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。
 *
 * 最终，我们到过网格的所有 rows x cols 个空间。
 *
 * 按照访问顺序返回表示网格位置的坐标列表。
 *
 *  输入：rows = 1, cols = 4, rStart = 0, cStart = 0
 * 输出：[[0,0],[0,1],[0,2],[0,3]]
 *
 * 输入：rows = 5, cols = 6, rStart = 1, cStart = 4
 * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 *
 * @author shadow
 * @create 2024-12-07 17:32
 **/
public class SpiralMatrixIII {

    /**
     * 这题主要是要控制查找的边界
     * @param rows
     * @param cols
     * @param rStart
     * @param cStart
     * @return
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // 创建结果列表，大小为 rows * cols
        List<int[]> result = new ArrayList<>();
        // 初始化当前坐标
        int x = rStart, y = cStart;
        // 将起始位置添加到结果列表中
        result.add(new int[]{x, y});
        // 已访问的元素数量
        int count = 1;
        // 定义四个方向：右、下、左、上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 初始方向为向右
        int directionIndex = 0;
        // 初始层数为1
        int level = 1;

        while (count < rows * cols) {
            // 每两次改变方向后，步数加1
            for (int i = 0; i < 2; i++) {//每转向两次，则层数加一
                for (int j = 0; j < level; j++) {//在当前层中转向
                    // 更新当前坐标
                    x += directions[directionIndex][0];
                    y += directions[directionIndex][1];
                    //x=0,y=5
                    // 检查新坐标是否在网格范围内
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result.add(new int[]{x, y});
                        count++;
                    }
                }
                // 改变方向，方向索引在 0 到 3 之间循环
                directionIndex = (directionIndex + 1) % 4;
            }
            // 增加步数
            level++;
        }

        // 将结果列表转换为二维数组并返回
        return result.toArray(new int[result.size()][]);
    }

}
