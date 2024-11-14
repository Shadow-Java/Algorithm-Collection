package algorithm.collection.leetcode.november.secondweek.november_13st;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * @author shadow
 * @create 2024-11-14 21:09
 **/
public class FindPeakElement {

    /**
     * 一、可能存在多个封顶，但只返回一个封顶
     *    ①红蓝染色法：定义红色背景为false，即目标峰顶左侧；蓝色表示为true，即峰顶及其右侧
     *    ②没有target，使用的是nums[mid] < nums[mid+1]
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left =0;
        int right = nums.length-1;
        while (left < right) {//结束值为left < right
            int mid = left + (right-left) >>1;
            if(nums[mid] <= nums[mid+1]) {//可能存在数组越界，当只有一个数时，结果为当前索引
                left = mid+1;//峰值在mid右侧，且mid不可能是峰值，放心更新为mid+1
            } else {
                right = mid;//峰值在mid左侧，且mid可取
            }
        }
        // left 和 right 相遇时，left 即为峰值的位置
        return left;
    }

}
