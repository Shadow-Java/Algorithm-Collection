package algorithm.collection.leetcode.deprecated;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 */
public class MaximumGap {
    /**
     * 我啪的一下sort，很快嘛
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);//升序排序
        int res = 0;
        for(int i=nums.length-1;i>0;i--){//求每个字符之间的间距
            int sd = nums[i] - nums[i-1];
            if(sd > res) res = sd;
        }
        return res;
    }
}
