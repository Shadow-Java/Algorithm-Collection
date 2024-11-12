package algorithm.collection.leetcode.november.firstweek.daily;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * @author shadow
 * @create 2024-11-11 20:52
 **/
public class SingleNonDuplicate {

    /**
     * 题目有两个已知条件：
     *
     * 数组是有序的。
     * 除了一个数出现一次外，其余每个数都出现两次。
     * 第二个条件意味着，数组的长度一定是奇数。
     *
     * 第一个条件意味着，出现两次的数，必然相邻，不可能出现 1,2,1 这样的顺序。
     *
     * 这也意味着，只出现一次的那个数，一定位于偶数下标上。
     *
     * 这启发我们去检查偶数下标 2k。
     *
     * 示例 1 的 nums=[1,1,2,3,3,4,4,8,8]：
     *
     * 如果 nums[2k] = nums[2k+1]，说明只出现一次的数的下标 >2k。
     * 如果 nums[2k] =/= nums[2k+1]，说明只出现一次的数的下标 ≤2k。
     * 也就是说，随着 k 的变大，不等式 nums[2k]=nums[2k+1] 越可能满足，有单调性，可以二分

     * @param nums
     * @return
     */
    public int singleNonDuplicate_V2(int[] nums) {
        int left = -1;
        //如果是奇数，则往偶数移动
        int right = nums.length / 2;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right * 2];
    }

    /**
     * 使用异或运算，相同为0不同为1，两两抵消的方法
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++) {
            ans = ans^nums[i];
        }
        return ans;
    }



}
