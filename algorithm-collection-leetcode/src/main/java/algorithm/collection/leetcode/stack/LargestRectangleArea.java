package algorithm.collection.leetcode.stack;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shadow
 * @create 2024-03-30 22:23
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "84",
        questionTitle = "柱状图中最大的矩形",
        relevateClass = TrappingRainWater.class,
        desc = "给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 ",
        questionLink = "https://leetcode.cn/problems/largest-rectangle-in-histogram/description/",
        algorithmCategory = AlgorithmCategory.MONOTONE_STACK,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.MONOTONIC_STACK}
)
public class LargestRectangleArea {

    /**
     * 计算当前柱子的最大矩形：找左边第一个比其矮的柱子left和右边第一个高的柱子right
     * 宽度width：right-left-1
     * 高度height：heights[mid]（以基准柱子的高度计算）
     * 矩形：width*height
     * @param heights
     * @return
     */
    @MethodTag(
            questionNumber = "84",
            methodLink = "https://leetcode.cn/problems/largest-rectangle-in-histogram/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.MONOTONIC_STACK,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public static int largestRectangleArea(int[] heights) {
        int[] newHeight = Arrays.copyOf(heights,heights.length + 1);
        //防止最后一个元素没有计算
        newHeight[heights.length] = 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i< newHeight.length;i++) {
            //计算每个柱子的最大矩形，主要三个值；当前基准值 left和当前遍历的值
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int mid = stack.peek();
                //拿到基准值，弹出是为了拿left值
                stack.pop();
                if(stack.isEmpty()) {
                    //对第一次遇到小于当前的数，做的处理，也可在数组第一个元素添加0
                    int height = newHeight[mid];
                    int width = i;
                    res = Math.max(res,height*width);
                    break;
                }
                int left = stack.peek();
                int height = newHeight[mid];
                int width = i-left-1;
                //计算以mid为基准的最大矩形，最左边的肯定是比mid高度要小，因为栈中数据是单调递减的；所以拿第一个left数据进行计算
                res = Math.max(res,height*width);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

}
