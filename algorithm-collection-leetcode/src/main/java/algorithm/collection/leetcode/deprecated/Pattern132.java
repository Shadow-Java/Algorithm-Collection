package algorithm.collection.leetcode.deprecated;

import java.util.Stack;

public class Pattern132 {


    /**
     * 暴力解：定位到“3”这个最大数，只需求在左边的最小数，和比3和1之间的数即可
     * 时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    public boolean find132pattern_1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int min = nums[0];
            int max = nums[i];
            for(int j = 0;j<=i;j++){
                if(min > nums[j]){
                    min = nums[j];
                }
            }
            for(int j = i;j < nums.length;j++){
                if(max > nums[j] && nums[j] > min){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：使用单调栈
     * 什么是单调栈：单调递增或递减的栈，从小到大或从大到小
     */
    public static boolean find132pattern(int[] nums) {
        int[] minLeft = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int min = nums[0];minLeft[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min){
                min = nums[i];
            }
            minLeft[i] = min;
        }
        stack.push(nums[nums.length-1]);
        for (int i = nums.length-2; i >= 0; i--) {
            int nextMax = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                nextMax = stack.pop();
            }
            if(nextMax > minLeft[i]){
                return true;
            }
            stack.push(nums[i]);
            stack.push(nextMax);
        }
        return false;
    }

}
