package algorithm.collection.leetcode.dynamicprogramming.backpack;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2024-10-25 23:51
 **/
public class MaxTotalReward {

    /**
     * 1.弄清楚什么时候用dp[][],什么时候用dp[]
     * 2.0-1背包问题
     * https://www.bilibili.com/video/BV16Y411v7Y6/?vd_source=416aff31c1c6f64ee63d708299ed23ec
     * @param rewardValues
     * @return
     */
    public int maxTotalReward(int[] rewardValues) {
        //假设最优解中的最大值为x，数组最大值为m
        //因为最大值肯定是最后一个选才会是最优解
        //假如x<m，既然能选x，m还比x大，那么肯定能选m
        //因此数组最大值必定包含在最优解中
        //因此最后一次操作之前，结果应该比m(即<=m-1)小，这样最后一次会选最大值
        //为什么选2m作为数组上限，因为每个值只会选一次，因为选择之后分数必然会比这个值大，就不能再选一次这个值了,因此最大值m只会选择一次
        //在选择最大值之前，分数最大值为m-1，选择最大值后最大值为m-1+m即2m-1，这就是结果最大值
        Arrays.sort(rewardValues);
        int m = rewardValues[rewardValues.length - 1];
        int[] dp = new int[2 * m];//dp[i]表示分数为i是否存在
        dp[0] = 1;//一个都不选即为0
        for (int x : rewardValues)//遍历每一个，把它看作一种结果里的最大值
        {
            for (int k = 2 * x - 1; k >= x; k--)//k是最终结果的分数，此时k的范围为[x,2x-1]，因为最少选一个x，判断这个区间内的所有k是否能够达到
            {
                //也就是把这个范围内的k每个都减去x(因为最少选一个x)，看是否有这样的分数，有的话就能达到当前k的分数
                if (dp[k - x] == 1)
                {
                    dp[k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = dp.length-1; i >=0; i--)//找出最大分数
        {
            if (dp[i] == 1)
            {
                res = i;
                break;
            }
        }
        return res;
    }

}
