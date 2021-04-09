package SourceCode.src;

public class FindMinimumRotatedSortedArrayII {


    public static int findMin(int[] nums) {
        int left = 0,right = nums.length-1,mid = 0;
        if(nums.length == 1){
            return nums[0];
        }
        while(nums[left] >= nums[right]){//说明是旋转后的数组
            mid = (left + right) / 2;//我们是要找最小值
            if(mid + 1 == right){
                break;
            }
            if(nums[mid] <= nums[right]){//如果旋转较多，左边都是大数,右边是小数，那么尽量靠左走
                right = mid;
            }
            if(nums[mid] >= nums[left] ){//旋转较少,右边是小数多，那么尽量往右走
                left = mid;
            }
        }
        return nums[mid];
    }

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

    public static void main(String[] args) {
        int[] nums = {4,1,2,2};
        System.out.println(findMin_2(nums));
    }

}
