package algorithm.collection.leetcode.november.secondweek.november_14st;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @author shadow
 * @create 2024-11-15 20:40
 **/
public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++) {
            //单调递减栈，存储的下标
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int left = stack.pop();
                ans[left] = i-left;
            }
            stack.push(i);
        }
        return ans;
    }

}
