package algorithm.collection.leetcode.november.thirdweek.november_18st.november_21st;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * 当k=1时，等价于121题 买卖股票的最佳时机
 * 当k=2时，等价于123题 买卖股票的最佳时机 III
 *
 * @author shadow
 * @create 2024-11-24 18:41
 **/
public class MaxProfit_188 {

    /**
     * 1.因为交易次数限制，那么应该在递归过程中去记录次数;一笔交易是指有卖出或买入，所以j-1在买入或者卖出都行
     * 2.状态机
     *      定义dfs(i,j,0)表示第i天结束时完成至多j笔交易，未持有股票的最大利润
     *      定义dfs(i,j,1)表示第i天结束时完成至多j笔交易，持有股票的最大利润
     * 3.最终状态转移方程
     *     {dfs(i,j,0)=dfs(i-1,j,0)}未持有   <-----{dfs(i,j,0) = dfs(i-1,j,1)+prices[i]}     持有
     *                              未持有   ------>{dfs(i,j,1) = dfs(i-1,j-1,0)-prices[i]}  持有（dfs(i,j,1)=dfs(i-1,j,1)）
     *     卖出：dfs(i,j,0) = max(dfs(i-1,j,0),dfs(i-1,j,1)+prices[i])
     *     买入：dfs(i,j,1) = max(dfs(i-1,j,1),dfs(i-1,j-1,0)-prices[i])   (注：j-1可在买入写或卖出都行)
     * 4.递归边界
     *      dfs(.,-1,.) = -无穷      任何情况下，j都不能为负
     *      dfs(-1,j,0) = 0         第0天开始未持有股票，利润为0
     *      dfs(-1,j,1)=-无穷        第0天开始不可能持有股票
     * 5.递归入口
     *      max(dfs(n-1,k,0),dfs(n-1,k,1)) = dfs(n-1,k,0)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //倒着递归
        return dfs(prices,n-1,k,false);
    }

    public int dfs(int[] prices,int i,int j,boolean hold) {
        if(j < 0) {
            return Integer.MIN_VALUE;
        }
        if(i < 0) {//边界
            return hold ? Integer.MIN_VALUE:0;
        }
        if(hold) {//要么持有股票
            return Math.max(dfs(prices,i-1,j,true),dfs(prices,i-1,j,false)-prices[i]);
        }
        //要么卖出股票
        return Math.max(dfs(prices,i-1,j,false),dfs(prices,i-1,j-1,true)+prices[i]);
    }

    /**
     * 1:1翻译为递推
     * f[i][j][0] = max(f[i-1][j][0],f[i-1][j][1]+prices[i])
     * f[i][j][1] = max(f[i-1][j][0],f[i-1][j-1][0]-prices[i])
     *
     * i=0时会越界
     * 但这样没有状态表示f[-1][.][.]和f[.][-1][.],那就在f和每个f[i]的前面插入一个状态
     *
     *
     *
     * 最终递推式：
     *    f[.][0][.]= -无穷
     *    f[0][j][0]= 0         j>=1
     *    f[0][j][1]= -无穷      j>=1
     *    f[i+1][j][0] = max(f[i][j][0],f[i][j][1]+prices[i])
     *    f[i+1][j][1] = max(f[i][j][1],f[i][j-1][0]-prices[i])
     * 答案为f[n][k+1][0]
     */
    public int maxProfitV2(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n+1][k+2][2];
        for (int[][] mat : f) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE / 2); // 防止溢出
            }
        }
        for (int j = 1; j <= k + 1; j++) {
            f[0][j][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j - 1][0] - prices[i]);
            }
        }
        return f[n][k + 1][0];
    }

    /**
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitV3(int k, int[] prices) {
        int[][] f = new int[k + 2][2];
        for (int j = 1; j <= k + 1; j++) {
            f[j][1] = Integer.MIN_VALUE / 2; // 防止溢出
        }
        f[0][0] = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            for (int j = k + 1; j > 0; j--) {//也可以不用倒序，只要更新记录一下tmp,或者直接写在一行就行；或者用01背包的思维
                f[j][0] = Math.max(f[j][0], f[j][1] + p);
                f[j][1] = Math.max(f[j][1], f[j - 1][0] - p);
            }
        }
        return f[k + 1][0];
    }

    /**
     * 如果改成「恰好」完成 k 笔交易要怎么做？
     *
     * 递归到 i<0 时，只有 j=0 才是合法的，j>0 是不合法的。
     * f[0][1][0]=0,其余=-无穷
     * （注意前面塞了个状态，f[0][1]才是恰好完成0次的状态）
     *
     * def maxProfit(self, k: int, prices: List[int]) -> int:
     *         # 递推
     *         n = len(prices)
     *         f = [[[-inf] * 2 for _ in range(k + 2)] for _ in range(n + 1)]
     *         f[0][1][0] = 0  # 只需改这里
     *         for i, p in enumerate(prices):
     *             for j in range(1, k + 2):
     *                 f[i + 1][j][0] = max(f[i][j][0], f[i][j][1] + p)
     *                 f[i + 1][j][1] = max(f[i][j][1], f[i][j - 1][0] - p)
     *         return f[-1][-1][0]
     *
     *         # 记忆化搜索
     *         # @cache
     *         # def dfs(i: int, j: int, hold: bool) -> int:
     *         #     if j < 0:
     *         #         return -inf
     *         #     if i < 0:
     *         #         return -inf if hold or j > 0 else 0
     *         #     if hold:
     *         #         return max(dfs(i - 1, j, True), dfs(i - 1, j - 1, False) - prices[i])
     *         #     return max(dfs(i - 1, j, False), dfs(i - 1, j, True) + prices[i])
     *         # return dfs(n - 1, k, False)
     *
     *
     */

    /**
     * 如果改成「至少」完成 k 笔交易要怎么做？
     *
     * 递归到「至少 0 次」时，它等价于「交易次数没有限制」，那么这个状态的计算方式和 122. 买卖股票的最佳时机 II 是一样的。
     * f[i][-1][.]等价于f[i][0][.]
     * 所以每个f[i]的最前面不需要插入状态
     * [至少0次]等价于[可以无限次交易]
     * 所以f[i][0][.]就是无限次交易下的最大利润，转移方程也是一样
     * f[0][0][0]=0,其余=-无穷
     *
     * def maxProfit(self, k: int, prices: List[int]) -> int:
     *         # 递推
     *         n = len(prices)
     *         f = [[[-inf] * 2 for _ in range(k + 1)] for _ in range(n + 1)]
     *         f[0][0][0] = 0
     *         for i, p in enumerate(prices):
     *             f[i + 1][0][0] = max(f[i][0][0], f[i][0][1] + p)
     *             f[i + 1][0][1] = max(f[i][0][1], f[i][0][0] - p)  # 无限次
     *             for j in range(1, k + 1):
     *                 f[i + 1][j][0] = max(f[i][j][0], f[i][j][1] + p)
     *                 f[i + 1][j][1] = max(f[i][j][1], f[i][j - 1][0] - p)
     *         return f[-1][-1][0]
     *
     *         # 记忆化搜索
     *         # @cache
     *         # def dfs(i: int, j: int, hold: bool) -> int:
     *         #     if i < 0:
     *         #         return -inf if hold or j > 0 else 0
     *         #     if hold:
     *         #         return max(dfs(i - 1, j, True), dfs(i - 1, j - 1, False) - prices[i])
     *         #     return max(dfs(i - 1, j, False), dfs(i - 1, j, True) + prices[i])
     *         # return dfs(n - 1, k, False)
     *
     */

    /**
     * 股票交易题单：
     * 121. 买卖股票的最佳时机
     * 122. 买卖股票的最佳时机 II
     * 123. 买卖股票的最佳时机 III
     * 188. 买卖股票的最佳时机 IV
     * 309. 买卖股票的最佳时机含冷冻期
     * 714. 买卖股票的最佳时机含手续费
     *
     */


}
