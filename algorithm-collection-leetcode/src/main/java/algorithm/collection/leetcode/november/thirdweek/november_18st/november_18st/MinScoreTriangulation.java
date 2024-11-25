package algorithm.collection.leetcode.november.thirdweek.november_18st.november_18st;

import java.util.Arrays;

/**
 * 1039. 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 *
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 *
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 *
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 *
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 *
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * @author shadow
 * @create 2024-11-24 22:34
 **/
public class MinScoreTriangulation {

    /**
     * 1.无论怎么剖分这个六边形，边1-5一定在这个三角形中，枚举这个三角形
     *
     *
     * @param values
     * @return
     */
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示还没有计算过
        }
        return dfs(0, n - 1, values, memo);
    }

    /**
     * 问：区间 DP 有一个「复制一倍，断环成链」的技巧，本题为什么不用这样计算？
     *
     * 答：无论如何旋转多边形，无论从哪条边开始计算，得到的结果都是一样的，那么不妨就从 0 - (n−1) 这条边开始计算。
     * 复杂度分析
     * 时间复杂度：O(n3)，其中 n 为 values 的长度。动态规划的时间复杂度 = 状态个数 × 单个状态的计算时间。本题中状态个数等于 O(n2)，单个状态的计算时间为 O(n)，因此时间复杂度为 O(n3)。
     * 空间复杂度：O(n2)。保存多少状态，就需要多少空间。
     *
     * @param i
     * @param j
     * @param v
     * @param memo
     * @return
     */
    private int dfs(int i, int j, int[] v, int[][] memo) {
        if (i + 1 == j) {
            return 0; // 只有两个点，无法组成三角形
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) { // 枚举顶点 k
            res = Math.min(res, dfs(i, k, v, memo) + dfs(k, j, v, memo) + v[i] * v[j] * v[k]);
        }
        return memo[i][j] = res; // 记忆化
    }

    /**
     * 1:1 翻译成递推
     * 根据视频中讲的，把 dfs 改成 f 数组，把递归改成循环就好了。相当于原来是用递归计算每个状态 (i,j)，现在改用循环去计算每个状态 (i,j)。
     *
     * 状态转移方程和递归完全一致：
     *
     * 需要注意循环的顺序：
     *
     * 由于 i<k，f[i] 要能从 f[k] 转移过来，必须先计算出 f[k]，所以 i 要倒序枚举；
     * 由于 j>k，f[i][j] 要能从 f[i][k] 转移过来，必须先计算出 f[i][k]，所以 j 要正序枚举。
     *
     *
     * 问：dfs(i,j)为什么只用枚举 i，j为顶点？ 答：区间dp是从小区间到大区间，内部的小区间一定都算过了，（枚举区间长度也是从小到大）所以只有以i，j结尾没有算过
     *
     * 也可以这么理解： 我们增加了一个点其实是相当于增加了一条边，0到n-1（也就是i到j）的一条边，我们需要考虑这条边怎么分配出去
     *
     * 问：为什么只计算i，j结尾就能cover所有情况？ 答：注意当前仅考虑（i，j）这个区间，那么i和j一定是最短的一条边（也就是相邻的两个点（也就是编号为0和n-1 的两个点）（灵神说的一定会包含一和五就是这两个点）），那么这两个相邻的点一定会跟第三个点合并构成三角形，每一个第三节点k对应一种情况，枚举了所有的k就是枚举了所有的情况
     *
     * 总结：爽！
     * @param v
     * @return
     */
    public int minScoreTriangulationV2(int[] v) {
        int n = v.length;
        int[][] f = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + v[i] * v[j] * v[k]);
                }
            }
        }
        return f[0][n - 1];
    }

    /**
     * 思考题
     * 如果要计算把 n 边形三角剖分的方案数，代码要怎么改？
     *
     * 课后作业
     * 375. 猜数字大小 II
     * 1312. 让字符串成为回文串的最少插入次数
     * 1547. 切棍子的最小成本
     * 1000. 合并石头的最低成本
     */

}
