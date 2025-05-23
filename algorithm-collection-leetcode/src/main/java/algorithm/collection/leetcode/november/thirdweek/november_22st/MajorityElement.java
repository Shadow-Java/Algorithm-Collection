package algorithm.collection.leetcode.november.thirdweek.november_22st;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * @author shadow
 * @create 2024-11-23 21:38
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }

}
