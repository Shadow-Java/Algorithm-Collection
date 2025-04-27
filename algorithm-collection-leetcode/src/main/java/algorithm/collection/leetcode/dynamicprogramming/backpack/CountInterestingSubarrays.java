package algorithm.collection.leetcode.dynamicprogramming.backpack;

import java.util.HashMap;
import java.util.List;

/**
 * 2845 统计趣味子数组的个数
 * 给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。
 *
 * 请你找出并统计数组中 趣味子数组 的数目。
 *
 * 如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ：
 *
 * 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
 * 以整数形式表示并返回趣味子数组的数目。
 *
 * 注意：子数组是数组中的一个连续非空的元素序列
 *
 *
 */
public class CountInterestingSubarrays {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        return 0;
    }

    /**
     * 统计趣味子数组的个数
     *  子数组中所有元素的乘积等于 k。
     * 请你返回数组中“趣味子数组”的个数
     * 示例1：
     * 输入：nums = [2, 3, 6], k = 6
     * 输出：2
     *
     * 前缀积的原理：
     * 例如，对于数组 [2, 3, 6]：
     *
     * prefixProduct[0] = 2
     * prefixProduct[1] = 2 * 3 = 6
     * prefixProduct[2] = 2 * 3 * 6 = 36
     *
     * subarrayProduct(i,j)=  prefixProduct[j]/prefixProduct[i−1]
     *
     * 子数组 [3, 6] 的乘积可以表示为subarrayProduct(1,2)= prefixProduct[2]/prefixProduct[0] = 36/2 = 18
     *
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, int k) {
        // 哈希表用于记录前缀积出现的次数
        HashMap<Long, Integer> countMap = new HashMap<>();
        countMap.put(1L, 1); // 初始前缀积为1，表示空子数组

        long prefixProduct = 1; // 当前前缀积
        int result = 0; // 记录满足条件的子数组数量

        for (int num : nums) {
            // 更新前缀积
            prefixProduct *= num;

            // 检查是否存在满足条件的前缀积
            if (prefixProduct % k == 0) {
                long target = prefixProduct / k;
                result += countMap.getOrDefault(target, 0);
            }

            // 将当前前缀积加入哈希表
            countMap.put(prefixProduct, countMap.getOrDefault(prefixProduct, 0) + 1);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums2 = {1, 1, 1};
        int k2 = 1;
        CountInterestingSubarrays subarrays = new CountInterestingSubarrays();
        System.out.println(subarrays.countSubarrays(nums2, k2)); // 输出: 6
    }

}
