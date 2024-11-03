package algorithm.collection.leetcode.november.firstweek.november_3st;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * @author shadow
 * @create 2024-11-03 17:01
 **/
public class MinSubArrayLen {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int ans = Integer.MAX_VALUE;
        int window = 0;
        for(int right = 0;right < nums.length;right++) {
            //当right从0开始，那么得先加了之后再判断
            window += nums[right];
            while(window >= target) {
                //一步一步更新，也可以提前跳出循环
                ans = Math.min(ans,right-left+1);
                window = window - nums[left];
                left++;
            }
        }
        //如果没有最小的区间，则返回0
        return ans == Integer.MAX_VALUE ? 0:ans;
    }

}
