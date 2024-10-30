package algorithm.collection.primary.dynamicprogramming;

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

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = dfs(n-1,amount,coins);
        if(ans < Integer.MIN_VALUE) {
            return ans;
        }
        return -1;
    }

    public int dfs(int i,int capacity,int[] coins) {
        if(i < 0) {
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

}
