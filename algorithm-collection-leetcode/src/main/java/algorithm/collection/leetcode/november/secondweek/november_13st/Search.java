package algorithm.collection.leetcode.november.secondweek.november_13st;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * @author shadow
 * @create 2024-11-14 22:12
 **/
public class Search {

    public int searchV2(int[] nums, int target) {
        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (isBlue(nums, target, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }

    private boolean isBlue(int[] nums, int target, int i) {
        int x = nums[i];
        int end = nums[nums.length - 1];
        if (x > end) {
            return target > end && x >= target;
        }
        return target > end || x >= target;
    }

    public int search(int[] nums, int target) {
        int n = nums.length, i = findMin(nums);
        if (target > nums[n - 1]) { // target 在第一段
            return lowerBound(nums, -1, i, target); // 开区间 (-1, i)
        }
        // target 在第二段
        return lowerBound(nums, i - 1, n, target); // 开区间 (i-1, n)
    }

    // 153. 寻找旋转排序数组中的最小值
    private int findMin(int[] nums) {
        int n = nums.length;
        int left = -1;
        int right = n - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    // 有序数组中找 target 的下标
    private int lowerBound(int[] nums, int left, int right, int target) {
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return nums[right] == target ? right : -1;
    }

}
