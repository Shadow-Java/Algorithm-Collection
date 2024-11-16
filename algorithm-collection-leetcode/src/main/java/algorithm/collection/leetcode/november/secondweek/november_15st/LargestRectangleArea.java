package algorithm.collection.leetcode.november.secondweek.november_15st;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 输入： heights = [2,4]
 * 输出： 4
 * @author shadow
 * @create 2024-11-15 22:21
 **/
public class LargestRectangleArea {

    /**
     * 1、暴力：
     *      ①计算每个高度固定场景下的所能勾勒的最大矩形，即高度固定，向左右延伸使其宽度最大
     *      ②优化：提前存储每个下标左右最小的数，计算其矩形面积
     * 2、单调栈
     *      ①如果单调栈是递减(从栈底到栈顶)的话，求的是左边第一个比它大的数；如果是单调递增(从栈底到栈顶)的话，那么求的是左边第一个比他小的数；
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        //添加了哨兵，哨兵就是在左右多添加一个节点(因为可能数组一直是单调递增的，那么单调栈就计算不了结果，只有遇到最小值才会计算)
        //比如链表添加一个头结点，也叫哨兵
        //最少需要三个元素，那么如果遇到[8,6,4,2]这栈中只有一个元素，所以需要在数组前也加一个哨兵left
        int[] newHeight = Arrays.copyOf(heights,heights.length + 1);
        newHeight[heights.length] = 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i< newHeight.length;i++) {
            //遇到最近比栈顶小的数
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int mid = stack.peek();
                stack.pop();//以栈顶top为基准高度，找左边第一个小的
                if(stack.isEmpty()) {//因为加了哨兵，所以为空的话只有计算第一个的时候才问空
                    int height = newHeight[mid];
                    int width = i;
                    res = Math.max(res,height*width);
                    break;
                }
                int left = stack.peek();//因为是递增栈(从栈底到栈顶)，所以left肯定比mid小，那么[left,mid,newHeight[i]]形成一个可计算区域
                int height = newHeight[mid];
                int width = i-left-1;
                res = Math.max(res,height*width);
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 暴力：每道题都需要考虑极端情况，对于单调栈场景，需要考虑仅单调递增数组和单调递减数组
     * @param heights
     * @return
     */
    public int largestRectangleAreaV2(int[] heights) {
        //计算每个位置左边第一个小的数和右边第一个小的数
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int RIGHT_LIMIT = heights.length;
        int LEFT_LIMIT = -1;
        Arrays.fill(left,LEFT_LIMIT);
        Arrays.fill(right,RIGHT_LIMIT);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<heights.length;i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i=heights.length-1;i >= 0 ;i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0;i<heights.length;i++) {
            //添加的哨兵，定义对应每个位置递增，那么right[i] = RIGHT_LIMIT
            //定义如果每个位置递减，那么left[i] = LEFT_LIMIT
            ans = Math.max(heights[i]*(right[i]-left[i]-1),ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        largestRectangleArea.largestRectangleAreaV2(height);
    }


}
