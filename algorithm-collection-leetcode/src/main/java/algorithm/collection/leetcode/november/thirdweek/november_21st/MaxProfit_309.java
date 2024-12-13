package algorithm.collection.leetcode.november.thirdweek.november_21st;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 输入: prices = [1]
 * 输出: 0
 *
 * @author shadow
 * @create 2024-11-24 18:36
 **/
public class MaxProfit_309 {

    /**
     * 很像打家劫舍的那道题，前一天不能卖出操作，那么直接递归到i-2即可，其他的跟122这题一样
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return dfs(prices,n-1,false);
    }

    public int dfs(int[] prices,int i,boolean hold) {
        if(i < 0) {//边界
            return hold ? Integer.MIN_VALUE:0;
        }
        if(hold) {//要么持有股票
            return Math.max(dfs(prices,i-1,true),dfs(prices,i-2,false)-prices[i]);
        }
        //要么卖出股票
        return Math.max(dfs(prices,i-1,false),dfs(prices,i-1,true)+prices[i]);
    }

}
