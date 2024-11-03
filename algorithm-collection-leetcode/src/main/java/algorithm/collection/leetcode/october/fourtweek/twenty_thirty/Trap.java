package algorithm.collection.leetcode.october.fourtweek.twenty_thirty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 难点：
 *
 * @author shadow
 * @create 2024-11-02 11:51
 **/
public class Trap {

    /**
     * 提前存储当前区域的左边最大值和右边最大值
     * leftMax = [0,1,1,2,2,2,2,3,3,3,3]
     * right   = [3,3,3,3,3,3,3,3,2,2,2]
     * @param height
     * @return
     */
    public int trap_V1(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            //比较当前值和leftMax和rightMax是否能形成低洼
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        //利用一个单调递减栈，每当遇到当前高度比栈顶高则出栈计算容积
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            //要形成低洼需三个位置，即最左边的高度和最右边的高度，其次是能形成低洼的中间高度
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //形成低洼的中间高度
                int top = stack.pop();
                //如果只有中间高度，则不能计算容积则跳出循环
                if (stack.isEmpty()) {
                    break;
                }
                //最左边的高度
                int left = stack.peek();
                int currWidth = i - left - 1;
                //计算当前的容积
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            //先用当前的高度进行判断，然后入栈
            stack.push(i);
        }
        return ans;
    }

    /**
     * 双指针：如果leftMax > rightMax，那么当前容积的大小就由rightMax决定；即由最小的高度决定；
     * 如果一端有更高的条形块(例如右端)，积水高度依赖于当前方向的高度(从左往右)；
     * 当我们发现另一侧的(右侧)的高度不是最高的，我们开始从相反的方向遍历(从右往左)
     * @param height
     * @return
     */
    public int trap_V3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        //记录形成低洼的左边的最大值和右边的最大值
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            //更新左边的柱子高度
            leftMax = Math.max(leftMax, height[left]);
            //更新右边的柱子高度
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                //左边的高度小于右边的高度，右边高了能够形成低洼，即移动左指针即可；不管左边最大高度和当前高度有多少柱子，都能形成低洼；
                //因为是一个柱子一个柱子计算容积的
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

}
