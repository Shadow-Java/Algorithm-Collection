package algorithm.collection.leetcode.stack;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.doublepointer.NextGreaterElementIII;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shadow
 * @create 2024-03-30 10:15
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "739",
        questionTitle = "每日温度",
        relevateClass = NextGreaterElementIII.class,
        desc = "如果有两个中间结点，则返回第二个中间结点。",
        questionLink = "https://leetcode.cn/problems/maximum-score-of-a-good-subarray/description/?envType=daily-question&envId=2024-03-19",
        algorithmCategory = AlgorithmCategory.MONOTONE_STACK,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.MONOTONIC_STACK}
)
public class DailyTemperatures {

    @MethodTag(
            questionNumber = "739",
            methodLink = "https://leetcode.cn/problems/daily-temperatures/submissions/518247386/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.MONOTONIC_STACK,
            algorithmCategory = AlgorithmCategory.MONOTONE_STACK
    )
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        //存储数组下标，因为题目要的是几天后温度会上升，计算的是坐标，
        stack.push(temperatures.length-1);
        res[temperatures.length-1] = 0;
        for (int i=temperatures.length-2;i>=0;i--) {
            int curVal = temperatures[i];
            int len = 0;
            //可能存在没有比其大的温度，一直出栈
            while (!stack.isEmpty()) {
                //比当前数小于等于的数都出栈，大于的数不出栈，计算其下标
                if(curVal < temperatures[stack.peek()]) {
                    //计算其下标
                    len = stack.peek()-i;
                    break;
                } else {
                    stack.pop();
                }
            }
            res[i] = len;
            //每次都把当前温度坐标入栈
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

}
