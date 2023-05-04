package algorithm.collection.leetcode.dynamicprogramming;

/**
 * 最大子数组
 * @Date 2023/4/18 17:35
 * @Created by Shadow
 */
public class MaximumSubarray {

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
