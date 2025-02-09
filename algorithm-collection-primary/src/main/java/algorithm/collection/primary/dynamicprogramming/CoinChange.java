package algorithm.collection.primary.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

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
     * @param i         表示第i种物品，枚举的是可能性
     * @param capacity  背包容量
     * @param coins     所有的可能性
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
        //这是结果是个数，即在枚举capacity到0的时候的次数，有一个合法的自增1
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
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int x : coins) {
            for (int c = x; c <= amount; c++) {
                if(f[c - x] != Integer.MAX_VALUE) {//避免溢出小于0，最终会递归到f[0]=0
                    f[c] = Math.min(f[c], f[c - x] + 1);
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }


    int count = Integer.MAX_VALUE;
    //这种是每种场景都枚举，因为硬币都都能重复，所以总的组合数达到了c^a种组合；c是硬币种类的数量，a是目标金额
    //相当于遍历背包1-amount时，每次遍历都是coins.size种情况
    //如何优化：1.使用动态规划dp    2.dfs(i) 将大问题转化为子问题，通过记忆化搜索转化为dfs(i-coin)+1
    private void dfs(int amount, int path, int[] coins, List<Integer> onPath) {
        if (path == amount) {
            count = Math.min(count, onPath.size());
            return;
        }
        if (path > amount) {
            return; // 超过目标金额，直接返回
        }

        for (int coin : coins) {
            // 剪枝：如果当前路径长度已经大于等于已知的最小硬币数，则无需继续搜索
            if (onPath.size() + 1 >= count) continue;

            onPath.add(coin);
            // 使用新的局部变量来避免修改外部状态
            dfs(amount, path + coin, coins, onPath);
            onPath.remove(onPath.size() - 1); // 回溯时移除最后一个元素
        }
    }

}
