package algorithm.collection.primary.dynamicprogramming;

import java.util.Arrays;

/**
 * 322.零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 解释: 无法用面额为 2 的硬币组成总金额 3
 *
 *
 * 输入: coins = [1], amount = 0
 * 输出: 0
 * 解释: 总金额为 0，不需要任何硬币
 * @author shadow
 * @create 2024-10-26 20:39
 **/
public class CoinChange {

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = dfs(n-1,amount,coins);
        if(ans < Integer.MIN_VALUE) {
            return ans;
        }
        return -1;
    }

    /**
     * 类比完全背包，数量就是价值，在完全背包中求的是价值，那么数量就类比价值
     * 总金额 amount就是背包容量，面额就是物品容量
     * @param i
     * @param capacity
     * @param coins
     * @return
     */
    public int dfs(int i,int capacity,int[] coins) {
        if(i < 0) {
            //因为类比完全背包，初始状态[0,0]的状态需要构造出来，所以加了初始态
            if(capacity == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(capacity < coins[i]) {
            return dfs(i-1, capacity,coins);
        }
        return Math.min(dfs(i-1,capacity,coins), dfs(i, capacity-coins[i],coins)+1);
    }

    /**
     * 翻译为递推
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeV2(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE / 2); // 除 2 防止下面 + 1 溢出
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if (c < coins[i]) f[i + 1][c] = f[i][c];
                else f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
            }
        }
        int ans = f[n][amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    /**
     * 空间优化：两个数组（滚动数组）
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeV3(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[2][amount + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE / 2);
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if (c < coins[i]) f[(i + 1) % 2][c] = f[i % 2][c];
                else f[(i + 1) % 2][c] = Math.min(f[i % 2][c], f[(i + 1) % 2][c - coins[i]] + 1);
            }
        }
        int ans = f[n % 2][amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    /**
     * 空间优化：一个数组
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeV4(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int x : coins) {
            for (int c = x; c <= amount; c++) {
                f[c] = Math.min(f[c], f[c - x] + 1);
            }
        }
        int ans = f[amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

}
