package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给你一个整数数组 nums，和一个整数 k 。
 *
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的任意整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 *
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 *
 * 在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 *
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
 *
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
 *
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 * @author shadow
 * @create 2024-10-20 23:24
 **/
public class SmallestRangeI {

    /**
     * 这道题的问题在于太想套模版了，如果抛开模版，想想是不是就纯数学问题
     * @param nums
     * @param k
     * @return
     */
    @QuestionTag(
            difficultyLeve = DifficultyLevel.EASY,
            questionNumber = "908",
            questionTitle = "最小差值 I",
            relevateClass = FindMaxK.class,
            desc = "给你一个整数数组 nums，和一个整数 k ",
            questionLink = "https://leetcode.cn/problems/smallest-range-i/description/?envType=daily-question&envId=2024-10-20",
            timeComplexity = TimeComplexity.O_N,
            dataStructTypes = {DataStructType.ARRAY_LIST}
    )
    public static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //最大值和最小值差值最小只能为0，不可能为非负数
        // 如果最大值-k后小于等于最小值+k，说明数组所有元素可以变成相同的数，得分为0
        // 否则得分=新的最大值-新的最小值 = maxVal - k - (minVal + k)
        return Math.max(0, max-min-2*k);
    }


    public static void main(String[] args) {
        int[] nums = {1,3,6};
        System.out.println(smallestRangeI(nums,3));
    }

}
