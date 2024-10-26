package algorithm.collection.primary.dynamicprogramming;

/**
 * 322.零钱兑换
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
