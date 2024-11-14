package algorithm.collection.leetcode.november.secondweek.november_13st;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * @author shadow
 * @create 2024-11-14 20:16
 **/
public class SearchRange {

    /**
     * 问题：返回有序数组中第一个大于等于8的位置，如果所有数都小于8，返回数组长度；
     * 一、
     *   ①取L=0、R=n-1分别指向左右边界，即闭区间[L,R]，M指向正在询问的数
     *      1.如果当前nums[M] < target,那么说明[L,M]都是小于target
     *      2.如果当前nums[M] >= target,那说明[M,R]也是大于等于target
     *   ②如果区间有偶数个数，那么区偏左边的数，即M=L+(R-L) >> 1;
     *   ③红色背景表示false,即<target的区间；蓝色表示true，即>=target的区间；
     *   ④当更新L时，表示[L,M]都是小于target，但[M+1,R]是不确定的，即更新L=M+1；当更新R时，表示[M,R]都是大于等于target，但[L,M-1]是不确定的，即更新R=M-1
     *   ⑤如果存在target，那么最终L落在target位置，而R落在target上一个位置；即最终结果可以为L或者R+1
     *   ⑥为什么L会更新M+1,因为每时每刻处理的是闭区间；如果L更新的是M，那么就是(M,R]；这样如果只有一个元素，将L=M，那么会死循环
     *   ⑦终止条件L<=R；假设只有一个元素时，R=M-1在target的左边，L在target上(为false)
     *
     * 二、当要求的位置不是大于等于target呢，如果是>、<或者<=呢
     *   ① >=  转换为num[mid] > target
     *   ② >  转换为num[mid] >= target+1
     *   ③ <  转换为(num[mid] >= target)-1（大于等于taget左边那个数，即8左边的7）   比如5 7 7 8 8 10
     *   ④ <= 转换为(num[mid] > target)-1
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums,target);
        if(start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        //>8的最后一个数转换为  大于等于9的左边那个数
        int end = lowerBound(nums,target+1) -1;
        return new int[]{start,end};
    }

    /**
     * 这道题的答案求是大于等于8的数
     * @param nums
     * @param target
     * @return
     */
    public int lowerBound(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;//闭区间[L,R]
        while (left <= right) {
            int mid = left + (right-left) >>1;
            if(nums[mid] < target) {
                left = mid+1; //[mid+1,R]
            } else {
                right = mid-1;//[L,M-1]
            }
        }
        //当数组都小于等于target，那么left最终为数据长度；
        //left会落在第一个为false的位置上；R也是如此
        return left;
    }

    /**
     * 二、左闭右开区间
     *        ①将R初始为n，那么区间为[L,R);那么更新时将R=M
     *        ②终止条件L==R,判断条件L<R,此时L和R都指向target
     *
     * @param nums
     * @param target
     * @return
     */
    public int lowerBoundV2(int[] nums, int target) {
        int left =0;
        int right = nums.length;//左闭右开区间[L,R)
        while (left < right) {//区间不为空
            int mid = left + (right-left) >>1;
            if(nums[mid] < target) {
                left = mid+1;//[mid+1,R)
            } else {
                right = mid;//[L,M)
            }
        }
        //当数组都小于等于target，那么left最终为数据长度；
        //L和R都落在target上
        return left;
    }

    /**
     * 三、左开右开区间
     *        ①将R初始为n，那么区间为[L,R);那么更新时将R=M
     *        ②终止条件L==R,判断条件L<R,此时L和R都指向target
     *
     * @param nums
     * @param target
     * @return
     */
    public int lowerBoundV3(int[] nums, int target) {
        int left =-1;
        int right = nums.length;//左开右开区间(L,R)
        while (left + 1 < right) {//区间不为空
            int mid = left + (right-left) >>1;
            if(nums[mid] < target) {
                left = mid;//(mid,R)
            } else {
                right = mid;//(L,M)
            }
        }
        //当数组都小于等于target，那么left最终为数据长度；
        //R落在target上
        return right;
    }

}
