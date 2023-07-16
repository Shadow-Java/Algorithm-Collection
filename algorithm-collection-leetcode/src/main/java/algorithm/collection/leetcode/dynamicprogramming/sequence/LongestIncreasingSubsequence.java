package algorithm.collection.leetcode.dynamicprogramming.sequence;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    //其实dp[i]代表着记录，我们假设已经求出了前i的最大上升子序列，那么我将前i的长度记录在dp[i]上
    //比如第一个字母的上升子序列我记录在dp[0]上，第0个字母和第一个字母的最长上升子序列我记录在dp[1]上
    //依次类推我可以将前i个子序列记录在dp[i]上，那么最后的dp[i]就是我们需要的最长上升子序列
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            //代表着每个序列都至少有一个上升子序列
            for(int j = 0;j < i ;j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);//最后一轮的dp[i]不一定是最大的，所以最后需要对整个dp求最大
        }
        return res;
    }
}