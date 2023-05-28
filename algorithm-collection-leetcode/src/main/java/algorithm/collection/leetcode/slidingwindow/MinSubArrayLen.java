package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target;找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组
 *
 * @author shadow
 * @create 2023-05-27 01:03
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "209",
        questionTitle = "长度最小的子数组",
        relevateClass = {LongestSubstring.class},
        questionLink = "https://leetcode.cn/problems/minimum-size-subarray-sum/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N
)
public class MinSubArrayLen {

    /**
     * 通常队列这种数据类型非常适合滑动窗口，但是代码中使用了双指针来表示窗口的左右边界。
     * <p>
     * 1.先将右指针向右滑动，左指针不动，当左右指针表示的窗口中所有元素的sum值满足条件，则更新满足条件的最小窗口大小，并尝试将左指针也向右移动。
     * 2.左指针向右移动后，再次判断是否仍然满足条件，如果仍然满足，则重复第二步。
     * 3.直到不满足条件时，继续第一步的操作。
     * 4.最后返回result。
     * <p>
     * 主要以右指针为边界，看[left,right]的窗口值
     *
     * @param target
     * @param nums
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/minimum-size-subarray-sum/",
            questionNumber = "209",
            timeComplexity = TimeComplexity.O_N,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public int minSubArrayLen(int target, int[] nums) {
        int leftPoint = 0;
        int rightPoint = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        //当右指针小于数组的最大程度
        while (rightPoint < nums.length) {
            //累计窗口中的所有元素
            sum = sum + nums[rightPoint];
            //如果sum值达到target值
            while (sum >= target) {
                //更新result的值
                result = Math.min(rightPoint - leftPoint, result);
                //去除左边界的元素，如果仍然满足sum>=s的条件，则会再次判断，否则右指针向右滑动
                sum = sum - nums[leftPoint];
                leftPoint++;
            }
            //走下一个右边界，因为是需要连续数组，不是连续的是有问题
            rightPoint++;
        }
        return result == Integer.MAX_VALUE ? 0 : result + 1;
    }

}
