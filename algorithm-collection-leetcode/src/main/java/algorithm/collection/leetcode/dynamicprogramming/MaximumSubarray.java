package algorithm.collection.leetcode.dynamicprogramming;

/**
 * 53.最大子数组
 * @Date 2023/4/18 17:35
 * @Created by Shadow
 */
public class MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     *
     * @param nums
     */
    public static void maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        for (int val: dp) {
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

}
