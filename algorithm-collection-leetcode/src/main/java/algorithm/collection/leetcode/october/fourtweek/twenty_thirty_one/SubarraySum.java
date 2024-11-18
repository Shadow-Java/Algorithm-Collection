package algorithm.collection.leetcode.october.fourtweek.twenty_thirty_one;

import java.util.HashMap;
import java.util.Map;

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
     * 前缀和：前缀和是指从数组的起点到当前位置的所有元素的和。
     * 哈希表：使用哈希表记录每个前缀和出现的次数。
     * 遍历数组：
     *    1、对于每个元素，计算当前的前缀和。
     *    2、检查当前前缀和减去目标值 K 是否已经在哈希表中存在。如果存在，说明从某个位置到当前位置的子数组和为 K。
     *    3、更新哈希表中当前前缀和的次数。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumV3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // 初始化前缀和为0的情况

        for (int num : nums) {
            prefixSum += num;
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

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

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumV2(int[] nums, int k) {
        int count = 0;
        int left=0;
        int windowSum =0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= k) {
                if(windowSum == k) {
                    count++;
                    windowSum -= nums[left];
                    left++;
                } else {
                    windowSum -= nums[left];
                    left++;
                }
            }
        }
        return count;
    }

}
