package algorithm.collection.primary.dynamicprogramming;

import java.util.Arrays;

/**
 * dfs(i,c)表示从前i个数中选一些数恰好组成c的方案数；
 * 加法原理：做一件事有两种方式，方案数就是这两种方案之和；即将上面的max换成加法
 *
 * 494. 目标和
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * @author shadow
 * @create 2024-10-26 00:55
 **/
public class FindTargetSumways {

    private int[] nums;
    private int[][] memo;

    /**
     * 设P为加法表达式的和
     * S为nums的和，S-P则为添加减号的和
     * P-(S-P)=t  为target
     * 2p=s+t
     * p=(s+t)/2(即选一些数，这些数恰好等于(s+t)/2的和，0-1背包变形)
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {//是负数或者是个奇数 则没有方案数
            return 0;
        }
        int m = s / 2; // 背包容量

        this.nums = nums;
        int n = nums.length;
        memo = new int[n][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, m);
    }

    private int dfs(int i, int c) {
        if (i < 0) {
            //c==0表示有一个方案
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) { // 之前计算过
            return memo[i][c];
        }
        if (c < nums[i]) {
            return memo[i][c] = dfs(i - 1, c); // 只能不选
        }
        //注意这是方案数，dfs(i - 1, c - nums[i])没有自增1
        //因为这里代表的是一直让capacity枚举到0 才算一个方案
        //
        return memo[i][c] = dfs(i - 1, c) + dfs(i - 1, c - nums[i]); // 不选 + 选
    }


    /**
     * 翻译成递推
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysV2(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int m = s / 2; // 背包容量

        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= m; c++) {
                if (c < nums[i]) {
                    f[i + 1][c] = f[i][c]; // 只能不选
                } else {
                    f[i + 1][c] = f[i][c] + f[i][c - nums[i]]; // 不选 + 选
                }
            }
        }
        return f[n][m];
    }


    /**
     * 空间优化：两个数组（滚动数组）
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysV3(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int m = s / 2; // 背包容量

        int n = nums.length;
        int[][] f = new int[2][m + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= m; c++) {
                if (c < nums[i]) {
                    f[(i + 1) % 2][c] = f[i % 2][c]; // 只能不选
                } else {
                    f[(i + 1) % 2][c] = f[i % 2][c] + f[i % 2][c - nums[i]]; // 不选 + 选
                }
            }
        }
        return f[n % 2][m];
    }

    /**
     * 空间优化：一个数组
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysV4(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int m = s / 2; // 背包容量

        int[] f = new int[m + 1];
        f[0] = 1;
        for (int x : nums) {
            for (int c = m; c >= x; c--) {
                f[c] += f[c - x];
            }
        }
        return f[m];
    }

}
