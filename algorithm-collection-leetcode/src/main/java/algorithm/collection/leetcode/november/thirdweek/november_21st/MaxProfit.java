package algorithm.collection.leetcode.november.thirdweek.november_21st;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 * 最大总利润为 4 + 3 = 7 。
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 最大总利润为 4 。
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
 *
 *
 * @author shadow
 * @create 2024-11-24 18:24
 **/
public class MaxProfit {

    /**
     * prices = [7,1,5,3,6,4]
     * 1.状态机DP，不限制交易次数；可以从前往后思考，也可以从后往前思考
     * 2.最后一天发生了什么？
     *      从第0天开始到第5天结束时的利润 =从第0天开始到第4天结束时的利润+第5天的利润；分析子问题，到第i天结束时，持有/未持有股票的最大利润
     * 3.状态机（在第i天能做那些事情）：
     *     （什么也不做的话，就自循环） 未持有   <-----（卖出）   持有（什么也不做的话，就自循环）
     *     （什么也不做的话，就自循环）未持有   ------>(买入)   持有（什么也不做的话，就自循环）
     * 4.定义状态和状态转移方程：
     *     定义dfs(i,0)表示第i天结束时，未持有股票的最大利润
     *     定义dfs(i,1)表示第i天结束时，持有股票的最大利润
     *   由于第i-1天的结束就是第i天的开始，dfs(i-1,.)也表示到第i天开始时的最大利润（边界条件）
     * 5.最终状态转移方程
     *     {dfs(i,0)=dfs(i-1,0)}未持有   <-----{dfs(i,0) = dfs(i-1,1)+prices[i]}   持有
     *                          未持有   ------>{dfs(i,1) = dfs(i-1,0)-prices[i]}  持有（dfs(i,1)=dfs(i-1,1)）
     *     dfs(i,0) = max(dfs(i-1,0),dfs(i-1,1)+prices[i])
     *     dfs(i,1) = max(dfs(i-1,1),dfs(i-1,0)-prices[i])
     * 6.递归边界（如果把i=0当成递归边界的话，那么需要保证数组不为空；i=-1则不需要）
     *      dfs(-1,0) = 0     第0天开始未持有股票，利润为0
     *      dfs(-1,1) = -无穷  第0天开始不可能持有
     * 7.递归入口:枚举最后一天是否持有股票就行，但最后一天未持有股票的利润肯定比持有股票的利润要大
     *     max(dfs(n-1,0),dfs(n-1,1)) = dfs(n-1,0)
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //倒着递归
        return dfs(prices,n-1,false);
    }

    /**
     * 可以改成记忆化搜索，用数组提前存储（作业）
     * 时间复杂度O(N)个状态
     * @param prices
     * @param i
     * @param hold
     * @return
     */
    public int dfs(int[] prices,int i,boolean hold) {
        if(i < 0) {//边界
            return hold ? Integer.MIN_VALUE:0;
        }
        if(hold) {//要么持有股票
            return Math.max(dfs(prices,i-1,true),dfs(prices,i-1,false)-prices[i]);
        }
        //要么卖出股票
        return Math.max(dfs(prices,i-1,false),dfs(prices,i-1,true)+prices[i]);
    }

    /**
     * 1:1翻译为递推
     * f[i][0] = max(f[i-1][0],f[i-1][1]+prices[i])
     * f[i][1] = max(f[i-1][0],f[i-1][0]-prices[i])
     *
     * i=0时会越界
     * 但这样没有状态表示f[-1][0]和f[-1][1],那就在f的前面插入一个状态
     *
     * 最终递推式：
     *    f[0][0]=0
     *    f[0][1]=-无穷
     *    f[i+1][0] = max(f[i][0],f[i][1]+prices[i])
     *    f[i+1][1] = max(f[i][0],f[i][0]-prices[i])
     * 答案为f[n][0]
     */
    public int maxProfitV2(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n+1][n+1];
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //为什么没有写if else，因为f[i+1][0]和f[i+1][1]表示的是两个不同的位置
            f[i+1][0] = Math.max(f[i][0],f[i][1]+prices[i]);
            f[i+1][1] = Math.max(f[i][1],f[i][0]-prices[i]);
        }
        return f[n][0];
    }

    public int maxProfitV3(int[] prices) {
        int n = prices.length;
        int f0 = 0;
        int f1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //需要有个变量临时存储f0,因为下面会计算f0，不临时直接复制给f0，会有问题
            int new_f0 = Math.max(f0,f0+prices[i]);
            f1 = Math.max(f1,f0-prices[i]);
            f0 = new_f0;
        }
        return f0;
    }

}
