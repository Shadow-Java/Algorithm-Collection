package SourceCode.src;

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
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0,right = nums.length-1,mid = 0;
        while(nums[left] >= nums[right]){//如果nums[left] <= nums[right] 则是未经过旋转，排序好的，则取numg[0]
            if(left + 1 == right){//结束条件
                return mid;
            }
            if(nums[left] <= nums[mid]){//说明左边是旋转后的升序
                left = mid;
            }
            if(nums[mid] <= nums[right]){//说明左边正常升序的多，移动右节点
                right = mid;
            }
        }
        return nums[mid];
    }

}
