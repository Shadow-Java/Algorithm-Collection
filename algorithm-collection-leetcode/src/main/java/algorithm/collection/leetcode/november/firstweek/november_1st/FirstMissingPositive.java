package algorithm.collection.leetcode.november.firstweek.november_1st;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * @author shadow
 * @create 2024-11-02 12:03
 **/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }

}
