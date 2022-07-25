package algorithm.collection.leetcode.deprecated;

import java.util.Arrays;
import java.util.Comparator;

/**
 *给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 */
public class MatrixCellsDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int index = 0;
        for(int i = 0;i<R;i++){//行
            for(int j =0;j<C;j++){//列
                int[] xy = {i,j};//先将每一行点进入res中
                res[index++] = xy;
            }
        }
        Arrays.sort(res,new Comparator<int[]>(){//排序函数
            @Override
            public int compare(int[] o1,int[] o2){//对于每个行，进行举例比较
                int dis1 = Math.abs(o1[0]-r0) + Math.abs(o1[1]-c0);//Math.abs()是求平均值，即为整数
                int dis2 = Math.abs(o2[0]-r0) + Math.abs(o2[1]-c0);
                return dis1 - dis2;//从小到大排序
            }
        });
        return res;
    }
}
