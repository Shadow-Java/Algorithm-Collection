package algorithm.collection.leetcode.november.secondweek.november_14st;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 输入：s = ""
 * 输出：0
 *
 * 为什么叫求最长子串？比如s = "()((()())",其中有两个子字符串里面有有效括号"()"、"(()())",那么结果求的就是后者为6
 *
 * @author shadow
 * @create 2024-11-14 23:27
 **/
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()()";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        longestValidParentheses.longestValidParentheses(s);
    }

    /**
     * 最长有效括号
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        //提前存一个无效值,存的是下标
        stack.push(-1);//每次让有效的最后括号下标减去-1
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {//栈中只存左括号
                stack.push(i);
            } else {//如果当前遇到了右括号，将栈中左括号弹出
                stack.pop();
                if (stack.isEmpty()) {//如果栈中没有值，则存入右括号
                    stack.push(i);
                } else {//计算当前右括号的下标减去左括号的下标
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

}
