package algorithm.collection.leetcode.stack;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.slidingwindow.MinimumWindowSubstring;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author shadow
 * @create 2023-05-18 00:33
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "42",
        questionTitle = "接雨水",
        relevateClass = {MinimumWindowSubstring.class},
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/valid-parentheses/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        dataStructTypes = DataStructType.MONOTONIC_STACK,
        timeComplexity = TimeComplexity.O_N
)
public class TrappingRainWater {

    /**
     * 按行求，即先求高度为1，高度为2....高度为max的值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int maxVal = Integer.MIN_VALUE;
        for (int h : height) {
            maxVal = Math.max(maxVal, h);
        }
        int curHeight = 1, res = 0;
        //curHeight从1到最高递增
        while (curHeight <= maxVal) {
            //求高度为count的水容量
            for (int h : height) {
                if (curHeight > h) {
                    res += 1;
                }
            }
            curHeight++;
        }
        return res;
    }


    /**
     * 首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
     *
     * @param height
     * @return
     */
    @MethodTag(
            questionNumber = "42",
            methodLink = "https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int trapAnotherWay(int[] height) {
        int sum = 0;
        //用两个数组记录，当前节点的左边最大值和右边最大值
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        //求当前高度的左边最大
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        //求当前高端的右边最大
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        //
        for (int i = 1; i < height.length - 1; i++) {
            //根据漏桶算法，两边取决于短板，找到当前高度的短板
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 单调栈结构实现，可以类比括号比对
     *
     * @param height
     * @return
     */
    @MethodTag(
            questionNumber = "42",
            methodLink = "https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.MONOTONIC_STACK,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public static int trapAnotherWaySecond(int[] height) {
        int ans = 0;
        //单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        //遍历整个柱子
        for (int i = 0; i < n; ++i) {
            //在低洼的池子中，每次拿出栈顶元素为基准计算装水；直到栈中元素为空
            //为什么能把之前入栈的元素出栈，因为是计算了该基准柱子的容积，后面就用不到了（遇到了第一个比其大的数）
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //弹出形成低洼的柱子
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                //计算弹出后的柱子和当前柱子形成的低洼宽度
                int currWidth = i - left - 1;
                //计算形成的高度
                int currHeight = Math.min(height[left], height[i]) - height[top];
                //满足条件则加入水的容量
                ans += currWidth * currHeight;
            }
            //将当前柱子加入计算下一个低洼区域
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapAnotherWaySecond(heights));
    }

}
