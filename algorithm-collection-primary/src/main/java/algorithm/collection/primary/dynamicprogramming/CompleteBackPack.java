package algorithm.collection.primary.dynamicprogramming;

/**
 * 完全背包：设有n种物品，每种物品有一个重量及一个价值。但每种物品的数量是无限的，同时有一个背包，最大载重量为CAPACITY，今从n种物品中选取若干件（同一种物品可以多次选取），使其重量的和小于等于M，而价值的和为最大
 * 每件物品的重量为w[i],价值为v[i]
 * 当背包容量为10时，w[i]为物品重量，v[]
 *   w    v          0    1   2   3   4   5   6   7   8   9   10
 *                   0    0    0   0   0   0   0   0   0   0   0   0
 * A  2    1     1    0    0   1   1   2   2   3   3   4   4   5
 * B  3    3     2    0    0   1   3   3   4   6
 * C  4    5     3
 * D  7    9     4
 *
 * dp[2][6]是通过dp[1][6]和dp[2,3];dp[2][3]的意思是当拿了物品B时，还剩容量3且还能拿物品B
 *
 * 转台转移方程式：dp[i][j] = max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
 * 空间优化的一维数组和01背包是一样的，但是01背包是从后往前推，完全背包是从前往后推：
 * dp[j] = Math.max(dp[j],dp[j-weights[i-1]]+values[i-1]);
 * @author shadow
 * @create 2024-10-30 00:16
 **/
public class CompleteBackPack {

    /**
     * 朴素方法：每个物品可以拿0个  1个  ...n个，能拿的下限为0个，能拿的上限为j/w[i];穷举的背包容量除以物品重量
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public static int CompleteBackPack_V1(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[] dp = new int[capacity+1];
        for(int i=1;i<n;i++) {
            for(int j=capacity;j>=1;j--) {//反向
                for(int k=0;k<=j/weight[i];k++) {
                    //k为拿的个数，依次枚举
                    dp[j] = Math.max(dp[j],dp[j-k*weight[i-1]]+k*value[i-1]);
                }
            }
        }
        return dp[capacity];
    }

    public static int CompleteBackPack_V2(int[] weight, int[] value, int capacity) {
        int n = weight.length;

        int[] dp = new int[capacity+1];

        for (int i = 1; i <= n; i++) {
            //j从weight[i-1]开始推
            for (int j = 0; j <= capacity; j++) {
                //从前往后推，因为dp[i]轮的数据时新产生的，不会覆盖
                if(j > weight[i-1]) {

                    dp[j] = Math.max(dp[j],dp[j- weight[i-1]]+value[i-1]);
                }
            }
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[capacity];
    }
}
