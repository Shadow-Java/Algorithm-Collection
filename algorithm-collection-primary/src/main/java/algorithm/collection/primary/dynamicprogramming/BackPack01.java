package algorithm.collection.primary.dynamicprogramming;

/**
 * 0-1背包是每件物品的状态就是取或者不取，取是1，不取是0；假设物品总数为n，那么穷举的总数为2^n
 * 假设有      重量      价值      背包重量为6
 *     气球    2         3
 *     矿泉水  3         5
 *     西瓜    4         6
 *  对于每一个单元格，都需要判断weight > j
 *        背包重量      0       1       2       3       4       5       6
 *  0物品              0       0       0       0       0       0       0
 *  气球(2,3)          0       0       3       3       3       3       3
 *  矿泉水(3,5)        0       0       3       5       5       8       8
 *  西瓜(4,6)          0       0       3       5      6       8       9
 *
 *  dfs(i,c)为前i个物品的最大价值和
 *  例如当背包容量为2时：1.不选气球，dfs(0,2)为前0个物品 容量为2的最大价值和
 *                   2.选气球，那么容量就少2-2=0，前0个物品的最大价值和+选了气球的价值
 *                   3.dfs(1,2) = max(dfs(0,2),dfs(0,0)+3) = 3
 *  dfs(1,2) = max(dfs(0,2),dfs(0,0)+3);
 *
 *  例如当背包容量为2时,在矿泉水列时，矿泉水的容量3>2，故当前不能选矿泉水，只能选有一种选择，即不选矿泉水；所以dfs(2,2) = dfs(1,2)=3
 *
 *  例如当背包容量为5时，在矿泉水的容量为3，所以矿泉水可选也可不选,那么dfs(2,5)：
 *                   1.不选矿泉水，为dfs(1,5)
 *                   2.选矿泉水，dfs(1,2)+5
 *                   3.max(dfs(1,5),dfs(1,2)+5) = 8
 * @author shadow
 * @create 2024-10-26 00:08
 **/
public class BackPack01 {

    private static int[] weight = {1, 2, 3};
    private static int[] value = {6, 10, 12};

    public static void main(String[] args) {
        /**
         * 1.首先使用回溯思考01背包问题：dfs()
         * 2.dp是递归+记忆化搜索
         */
        int n = weight.length;
        System.out.println(dfs(n-1,5));
        System.out.println(knapsack(weight,value,5));
    }

    /**
     * 0-1背包问题:有n个物品，第i个物品的体积为w[i],价值为v[i];每个物品至多选择一个，求体积不超过capacity时的最大价值和
     * 回溯三问：1.当前操作：枚举第i个物品选或者不选；不选，剩余容量不变；选，剩余容量减少w[i]
     *         2.子问题：在剩余容量为c时，从前i个物品中得到的最大价值和
     *         3.下一个问题分类讨论：不选，在剩余容量为c时，从前i-1个物品中得到的最大价值和；选，在剩余容量为c-w[i]时，从前i-1个物品中得到的最大价值和
     * 定义方法dfs(i,c)为容量为c时，从前i个物品的得到的最大价值和(递归就是这样，定义好方法利用本地栈回溯)
     * dfs(i,c) = max(dfs(i-1,c),dfs(i-1,c-w[i])+v[i]);
     *
     *
     * 常见变形：
     *       1.至多装capacity，求方案数/最大价值和
     *       2.恰好装capacity，求方案数/最大、最小价值和
     *       3.至少装capacity，求方案数/最小价值和
     * 数组是无序的，但是可以选择性的拿物品
     * @param weight   重量数组
     * @param value    价值数组
     * @param capacity 总容量
     * @return
     */
    public static int zeroOneKnapsack(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        return dfs(n-1,5);
    }

    public static int dfs(int i,int capacity) {
        //一个物品都没有
        if(i < 0) {
            return 0;
        }
        if(capacity < weight[i]) {
            return dfs(i-1, capacity);
        }
        return Math.max(dfs(i-1,capacity), dfs(i-1, capacity-weight[i])+value[i]);
    }

    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[] dp = new int[W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = W; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }

        return dp[W];
    }

}
