package src;

public class FindArray {
    public int[] searchRange(int[] nums, int target) {
        return recur(0, nums.length - 1, nums, target);
    }

    public int[] recur(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[left] != target) {
                    // 因为left不是target需要向右移动
                    left = recur(left + 1, mid, nums, target)[0];
                }
                if (nums[right] != target) {
                    right = recur(mid, right - 1, nums, target)[1];
                }
                return new int[] {left, right};//都是的话，左右边界找到
            }
        }
        return new int[] {-1, -1};
    }
}
