package algorithm.collection.leetcode.dynamicprogramming;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 53.最大子数组
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @Date 2023/4/18 17:35
 * @Created by Shadow
 */
@QuestionTag(
        questionNumber = "53",
        questionTitle = "最大子数组",
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionLink = "https://leetcode.cn/problems/maximum-subarray/",
        algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING,
        timeComplexity = TimeComplexity.O_N
)
public class MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     *
     * @param nums
     */
    @MethodTag(
            questionNumber = "53",
            methodLink = "https://leetcode.cn/problems/maximum-subarray/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int maxSum = nums[0];
        for (int val: dp) {
            maxSum = Math.max(maxSum,val);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

}
