package algorithm.collection.leetcode.deprecated;

import java.util.Arrays;
import java.util.Collections;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 */
public class FindMinimuminRotatedSortedArray {
    /**
     * 时间复杂度O(N)，需要排序
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        //Collections.sort();对集合进行排序
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * 二分法
     * @param nums
     * @return
     */
    public int findMin_2(int[] nums){
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            //这里有个编程技巧
            //因为l<r 所以最后一轮肯定是(r,r+1)
            //那么mid 肯定是取值l 当判断条件是mid与l比时 会出现与自身比 造成出现等于情况 不好判断
            //所以判断条件时mid 与 r比 这样肯定是不同的两个数比
            if (nums[mid] < nums[r]) {  // mid可能为最小值
                r = mid;
            } else { // 没有重复值
                l = mid+1;      // mid肯定不是最小值
            }
        }
        return nums[mid];
    }

}
