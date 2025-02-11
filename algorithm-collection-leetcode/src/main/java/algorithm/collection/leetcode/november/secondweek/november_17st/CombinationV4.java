package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
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
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
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
 *
 */
public class CombinationV4 {

    public int combine(int[] nums, int target) {
        return dp(nums, nums.length-1, target);
    }

    /**
     * 两种思路:
     * 1.一种是枚举可能性，即方法名是从可能性中出发，方法名是可能性；方法名为物品种类，从方案出发，这样方案不会重复；即1，2和2，1是是相同的方案
     * 2.第二种是枚举背包容量，即从背包容量出发；这种计算的是组合，即1，2和2，1是不同的方案
     * @param nums
     * @param i
     * @param path
     * @return
     */
    public int dp(int[] nums,int i,int path) {
        if(i < 0) {
            //当没有物品的时候，如果背包容量递归到0，则为一个方案；否则都为0
            //这种场景适合恰好容量为capacity，如果是最大容量，则不用判断path==0
            return path == 0 ? 1 : 0;
        }
        if(nums[i] > path) {
            return dp(nums,i-1,path);
        }
        //这里是完全背包，即选择的数可以重复；如果不能重复则为i-1
        return dp(nums,i-1,path) + dp(nums,i,path-nums[i]);
    }

    static int[] memo;

    /**
     * 站在target的角度，枚举所有的情况；每选择一种情况都算一种方案
     * 然后将结果通过mmemory数组记录下来
     * @param nums  物品的可能性
     * @param i     当前还剩多少容量
     * @return
     */
    public int dp(int[] nums,int i) {
        if(i <= 0) {
            return 0;
        }
        int res = 0;
        for (int item : nums) {
            if(item <= i) {
                res += dp(nums, i-item);
            }
        }
        return res;
    }

    public int combineV1(int[] nums, int target) {
        int[] f = new int[target + 1];
        //初始值是否等于1还是0，需要自己带入target=1、2、3然后去算
        f[0] = 1;
        for (int i = 1; i <= target; i++) {//dfs是倒着枚举，而一维数组是正向枚举
            int res = 0;
            for (int item : nums) {
                if (item <= i) {
                    res += f[i - item];
                }
            }
            f[i] = res;
        }
        return f[target];
    }

    public static void main(String[] args) {
        CombinationV4 combine = new CombinationV4();
        int[] nums = {1,2,3};
        int target = 4;
        memo = new int[target+1];
        Arrays.fill(combine.memo,-1);
        System.out.println(combine.combine(nums,2));
    }

}
