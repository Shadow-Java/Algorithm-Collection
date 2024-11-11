package algorithm.collection.leetcode.october.fourtweek.twenty_thirty_one;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * @author shadow
 * @create 2024-10-31 20:34
 **/
public class SubarraySum {

    /**
     * 1.怎么找子数组
     * 2.统计个数
     * 此题暴力破解，复杂度O(N^2)，空间复杂度O(1)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int cur = nums[i];
            int sum = cur;
            if(sum == k) {
                count++;
            }
            for(int j=i+1;j<nums.length;j++) {
                sum = sum + nums[j];
                //不能提前退出，可能存在负数
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
