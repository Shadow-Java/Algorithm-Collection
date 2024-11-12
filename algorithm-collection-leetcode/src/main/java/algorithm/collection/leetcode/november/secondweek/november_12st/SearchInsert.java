package algorithm.collection.leetcode.november.secondweek.november_12st;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * @author shadow
 * @create 2024-11-12 23:32
 **/
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) >>1;
            if(target > nums[mid]) {
                left = mid+1;
            } else if(target < nums[mid]) {
                right = mid-1;
            } else {
                return mid;
            }
        }
        return left+1;
    }

}
