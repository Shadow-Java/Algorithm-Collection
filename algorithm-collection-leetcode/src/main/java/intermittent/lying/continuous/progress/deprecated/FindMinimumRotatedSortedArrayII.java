package intermittent.lying.continuous.progress.deprecated;

public class FindMinimumRotatedSortedArrayII {

    /**
     * 二分法是二段性，不是单调性，一旦存在重复数字则二分会存在问题
     * 只要一段满足某个性质，另外一段不满足某个性质，就可以用「二分」。
     * @param nums
     * @return
     */
    public static int findMin_2(int[] nums){
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

    /**
     * 二分查找,返回目标值在数组中的索引
     * 存在情况：
     *          1.如果数组是偶数个，mid会先进中左（中间偏左）
     *          2.如果数组是奇数个，mid直接中间的数
     * 最终会走到一个left+1 = right的情况（即相邻），如果此时left和right都没有，则会一直循环mid = right|left
     * @param nums
     * @param target
     */
    public static int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1,mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target >= nums[mid]){//右移
                left = mid;
            }
            if(target < nums[mid]){//左移
                right = mid;
            }
        }
        return mid;
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if (nums[mid] < nums[right]) {
                right = mid;
            }else {
                right = right - 1;
            }
        }
        return nums[left];
    }

}
