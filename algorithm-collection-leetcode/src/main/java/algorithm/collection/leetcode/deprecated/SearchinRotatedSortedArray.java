package algorithm.collection.leetcode.deprecated;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class SearchinRotatedSortedArray {

    /**
     * 由于题目说数字了无重复，举个例子：
     * 1 2 3 4 5 6 7 可以大致分为两类，
     * 第二类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
     *              这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第一类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
     *              这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
     * nums[left] <= nums[mid]是因为  [3,1] target = 1时，系统会判定属于第二种情况，且向左走，就会找不到
     *
     *
     * 二分模板当中有
     *  int mid=left+right+1>>1;
     * 为什么要多加个1才除以2，解释是会出现死循环。 确实是会出现死循环，但为什么left=mid的时候才会出现死循环，而right=mid的时候不会出现死循环；
     *    是因为整数除法是向下取整的。 举个例子。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = n-1,mid = 0;
        while(left <= right){
            mid = (left+right) >> 1;//右移一位
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] > nums[mid]){//第一种情况
                if(target > nums[mid] && target <= nums[right]){//在右边往右边找
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(nums[left] <= nums[mid]){//第二种情况  此处一定是<=
                if(target < nums[mid] && target >= nums[left]){//在左边往左边找
                    right = mid - 1;//要移动，不能left=mid,最后会导致一直循环
                }else{
                    left = mid + 1;
                }
            }
        }
        return nums[mid] == target ? mid:-1;
    }

    public static int test(int[] nums,int target){
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = n-1,mid = 0;
        while(left <= right){
            mid = (left+right) >> 1;//右移一位
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] > nums[mid]){//第一种情况
                if(target > nums[mid] && target <= nums[right]){//在右边往右边找
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(nums[left] <= nums[mid]){//第二种情况
                if(target < nums[mid] && target >= nums[left]){//在左边往左边找
                    right = mid - 1;//要移动，不能left=mid,最后会导致一直循环
                }else{
                    left = mid + 1;
                }
            }
        }
        return nums[mid] == target ? mid:-1;
    }



}
