package algorithm.collection.leetcode.october.fourtweek.twenty_thirty_one;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分
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
 * @author shadow
 * @create 2024-10-31 23:41
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * -2, 1, -3, 4, -1, 2, 1, -5, 4
     * -2  1  -2  4  3   5  6  1   5
     * @param nums
     * @return
     */
    public int maxSubArray_dp(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
