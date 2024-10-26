package algorithm.collection.primary.dynamicprogramming;

/**
 * 完全背包：有n种物品，第i种物品的体积为w[i],价值为v[i],每种物品无限次重复选，求体积和不超过capacity时的最大价值和
 *
 * 回溯三问：
 *        1.当前操作枚举第i种物品的选一个或者不选；不选，剩余容量不变；选一个，剩余容量减少w[i]
 *        2.子问题：在剩余容量为c时，从前i种物品中得到的最大价值和
 *        3.下一子子问题，分类讨论： 不选，在剩余容量为c时，从前i个物品中得到的最大价值和；选一个，在剩余容量为c-w[i]时，从前i种物品中得到的最大价值和
 * dfs(i,c) = max(dfs(i-1,c),dfs(i,c-w[i])+v[i])
 * 常见变形：
 *       1.至多装capacity，求方案数/最大价值和
 *       2.恰好装capacity，求方案数/最大/最小价值和
 *       3.至少装capacity，求方案数/最小价值和
 *  思考将价值变为1，将最大求最小，那么就有dfs(i,c) = min(dfs(i-1,c),dfs(i,c-w[i])+1)
 * @author shadow
 * @create 2024-10-26 20:20
 **/
public class CompleteKnapsack {

    private static int[] weight = {1, 2, 3};
    private static int[] value = {6, 10, 12};

    public int completeKnapsack() {
        int n = weight.length;
        int capacity = 5;
        return dfs(n-1,capacity);
    }

    /**
     * 空间复杂度较大，需要降低空间复杂度；将回溯改为递推
     * @param i
     * @param capacity
     * @return
     */
    public static int dfs(int i,int capacity) {
        //一个物品都没有
        if(i < 0) {
            return 0;
        }
        if(capacity < weight[i]) {
            return dfs(i-1, capacity);
        }
        //区别在于当前是dfs(i,capacity-weight[i])
        return Math.max(dfs(i-1,capacity), dfs(i, capacity-weight[i])+value[i]);
    }

}
