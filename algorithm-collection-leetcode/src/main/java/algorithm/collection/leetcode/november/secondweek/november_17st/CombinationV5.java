package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.Arrays;

/**
 *
 * 377. 组合总和 Ⅳ 变种组合
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 2, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 注意：本题计算的是排列，完全背包计算的是组合；即1,2 和 2,1 这两个排列，在本题是有区别的，是两种方案；但在完全背包中这两个排列没有区别，只算一种方案。
 * 从代码上看，计算排列（本题）需要外层循环枚举体积，内层循环枚举物品；计算组合（完全背包）需要外层循环枚举物品，内层循环枚举体积。
 *
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 * @author shadow
 * @create 2025-02-11 23:07
 **/
public class CombinationV5 {

    public int combine(int[] nums, int target) {
        memo = new int[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(nums, nums.length-1, target);
    }

    int[][] memo;
    public int dp(int[] nums,int i,int path) {
        if(i < 0) {
            //当没有物品的时候，如果背包容量递归到0，则为一个方案；否则都为0
            //这种场景适合恰好容量为capacity，如果是最大容量，则不用判断path==0
            return path == 0 ? 1 : 0;
        }
        if(memo[i][path] != -1) {
            return memo[i][path];
        }
        if(nums[i] > path) {
            return memo[i][path] = dp(nums,i-1,path);
        }
        //这里是完全背包，即选择的数可以重复；如果不能重复则为i-1
        return memo[i][path] = (dp(nums,i-1,path) + dp(nums,i,path-nums[i]));
    }

}
