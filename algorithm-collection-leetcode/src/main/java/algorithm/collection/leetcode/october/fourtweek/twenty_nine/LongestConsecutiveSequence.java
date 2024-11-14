package algorithm.collection.leetcode.october.fourtweek.twenty_nine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * 128. 最长连续序列
     * 给你一个未排序的整数数组 nums，请找出其中最长的连续子序列的长度。连续子序列是指元素值连续递增的子序列
     * 输入: nums = [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长的连续子序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * todo 最长有效字符串
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        Set<Integer> windowSet = new HashSet<>();
        windowSet.add(nums[0]);
        //不定长窗口，只有窗口没有left，即只需要更新窗口即可
        for (int right =1;right< nums.length;right++) {
            windowSet.add(nums[right]);
            if(nums[right-1]+1 != nums[right] && nums[right-1] != nums[right]) {
                max = Math.max(windowSet.size()-1,max);
                windowSet.clear();
                windowSet.add(nums[right]);
            }
        }
        max = Math.max(windowSet.size(),max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        /**
         * 两种思路：
         *    1.滑动窗口或者双指针
         *    2.使用hashMap：判断是否是开头值，不是则跳过，是的话则轮询查下一个值是否存在
         */
        System.out.println(longestConsecutive(nums));
    }

}
