package algorithm.collection.primary.dynamicprogramming;

/**
 * 多重背包问题：设有n种物品，每种物品有一个重量及一个价值。但第i种物品的数量最多有n[i]件可用，每件物品的重量为w[i],价值为v[i]，同时有一个背包，最大载重量为CAPACITY，今从n种物品中选取若干件（同一种物品可以多次选取），使其重量的和小于等于M，而价值的和为最大
 *
 *  0-1背包问题是每种物品只有一件，完全背包是每种物品有无限件，但多重背包每种物品只有有限件
 *
 *
 * @author shadow
 * @create 2024-10-30 00:59
 **/
public class MultipleKnapsack {

    /**
     * 在01背包的基础上，依次穷举个数k < n[i]  && k*w[i] >= j
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public int multipleKnapsack(int[] weight, int[] value,int[] s, int capacity) {
        int n = weight.length;

        int[] dp = new int[capacity+1];

        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= 1; j--) {
                for (int k=0;k<=s[i] && j>=k*weight[i];k++) {
                    //从01背包的状态转移方程式，去增加第i个物品拿k个的循环
                    dp[j] = Math.max(dp[j],dp[j-k*weight[i-1]]+k*value[i-1]);
                }
            }
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[capacity];
    }

    /**
     * 有1000个苹果，10个箱子怎么个放法，不管我拿多少个苹果，都能成箱成箱的拿；
     * 比如第一个箱子放2^0=1,第二个箱子放2^1=2,第三个箱子放2^2=4，如果想拿3个苹果，那么只需拿1号和2号箱子
     * @return
     */
    public int multipleKnapsack_V2() {
        return 0;
    }

}
