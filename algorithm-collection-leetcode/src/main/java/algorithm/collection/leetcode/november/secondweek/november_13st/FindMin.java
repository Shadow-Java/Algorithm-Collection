package algorithm.collection.leetcode.november.secondweek.november_13st;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
 *
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 *
 * @author shadow
 * @create 2024-11-14 21:48
 **/
public class FindMin {

    /**
     * 这道题的target是最后一个数，那么最后一个数要么是最小值要么是在最小值右侧
     * 红色背景表示false，即最小值左侧；蓝色背景为true，即最小值及其右侧
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int L =-1;
        int R = nums.length-1;
        while (L+1 < R) {
            int mid = L + (R-L)>>1;
            if(nums[mid] < nums[nums.length-1]) {
                R = mid;//蓝色
            } else {
                L = mid;
            }
        }
        return nums[R];
    }


    public int findMinV2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] < nums[right]) {
                // 最小值在左半部分，包括 mid
                right = mid;
            } else {
                // 最小值在右半部分，不包括 mid
                left = mid + 1;
            }
        }

        return nums[left];
    }

}
