package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.array.ArrayRandomGenerator;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * @author shadow
 * @create 2023-05-18 00:15
 **/
public class SumClosest {

    /**
     * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
     *
     * 返回这三个数的和
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     *
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *
     * 难点：1.如何更简单的遍历  2.求最接近
     *
     * label：double pointer
     *
     * 时间复杂度：O(nlogn)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        if(nums.length == 3){
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int closest = Math.abs(target-res);
        for(int i=0;i<nums.length;i++){
            int L = i+1,R = nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while (L < R){
                int curRes = nums[i]+nums[L]+nums[R];
                int curClosest = Math.abs(target-curRes);
                if(curClosest < closest){
                    closest = curClosest;
                    res = curRes;
                }
                /**
                 * 怎么往前移动，双指针是一起向中间移动还是只移动L或者只移动R
                 * 移动的前提：已经排好序<br/>
                 */
                if(curRes < target) L++;
                if(curRes > target) R--;
                if(curRes == target) return res;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = ArrayRandomGenerator.generateRandomArray(5,7,10);
        ArrayRandomGenerator.printArray(nums);
        int target = nums[0]+nums[3]+nums[4];
        System.out.println(target);
        System.out.println(threeSumClosest(nums,target));
    }

}
