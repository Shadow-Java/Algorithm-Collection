package algorithm.collection.leetcode.deprecated;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */
public class BestTimeBuySellStock {
    /**
     * 贪心算法
     * 这题其实就是看后面的数减去前面的数，看差值然后相加即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length-1];
        int j=0;
        for(int i=1;i<prices.length;i++){//前缀和数组
            if(prices[i]-prices[i-1] < 0){
                res[j++] = 0;
            }else{
                res[j++] = prices[i]-prices[i-1];//
            }
        }
        int count = 0;
        for(int m = 0;m<res.length;m++){
            count += res[m];
        }
        return count;
    }

    /**
     * 优化方法，计数器count统计每个数字的间距，相加
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        int count = 0;
        for(int i=1;i<prices.length;i++){//前缀和数组
            if(prices[i]>prices[i-1]){
                count += prices[i] - prices[i-1];
            }
        }
        return count;
    }

    /**
     * 动态规划DP
     * 定义状态 \dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）。
     *
     * 考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，这时候我们要将其卖出，并获得 \textit{prices}[i]prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：
     *
     */
    public int maxProfit_Dp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {//对于当天只有两种状态dp[i][0]  或 dp[i][1]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//对于当天没有股票状态，要么前一天没有股票，要么前一天有股票而今天需卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//对于当天持有股票状态，要么前一天持有股票，要么前一天没有持有股票而今天要买入
        }
        return dp[n - 1][0];//最后只需最后一天的没有持有股票的最大利润
    }

    /**
     * 动态规划优化
     * 注意到上面的状态转移方程中，每一天的状态只与前一天的状态有关，而与更早的状态都无关，因此我们不必存储这些无关的状态，只需要将 \textit{dp}[i-1][0]dp[i−1][0] 和 \textit{dp}[i-1][1]dp[i−1][1] 存放在两个变量中，通过它们计算出 \textit{dp}[i][0]dp[i][0] 和 \textit{dp}[i][1]dp[i][1] 并存回对应的变量，以便于第 i+1i+1 天的状态转移即可。
     *
     */
    public int maxProfit_Dp2(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }


}
