package algorithm.collection.leetcode.dynamicprogramming;

import algorithm.collection.common.datastruct.array.ArrayRandomGenerator;
import algorithm.collection.common.datastruct.linklist.LinkListRandomGenerator;
import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.QuestionTag;


/**
 * TODO 添加jmh测试工具
 */
@QuestionTag(
        questionNumber = "632",
        questionTitle = "最小区间",
        relevateClass = MaximumSubarray.class
)
public class MaximumSubarrayTest {

    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int maxSize = Integer.MIN_VALUE;
        for (int val: dp) {
            maxSize = Math.max(maxSize,val);
        }
        return maxSize;
    }


    public static void main(String[] args) {
        System.out.println("--------------测试用例1000次--------------");
        for(int i=0;i<10000;i++){
            int[] nums = ArrayRandomGenerator.generateRandomArray(5,7,10);
            int maxVal = MaximumSubarray.maxSubArray(nums);
            if(maxVal != maxSubArray(nums)){
                System.out.println("代码出错！");
                ArrayRandomGenerator.printArray(nums);
                break;
            }
        }
        System.out.println("--------------测试用例结束--------------");
    }

}