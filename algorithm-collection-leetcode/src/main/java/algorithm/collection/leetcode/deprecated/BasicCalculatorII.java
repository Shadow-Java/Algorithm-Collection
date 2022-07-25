package algorithm.collection.leetcode.deprecated;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 思路：先将数存储起来，“最后”对数进行求和
 * 记录一个前字符preSign，如果前字符preSign是“+”或“-”，则当前字符入队；如果前字符preSign是“*”或“/”，则计算后再入队。
 */
public class BasicCalculatorII {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == ' '){
                continue;
            }
            //如果是字符串，则记录pre，如果是数字则判断
            if(Character.isDigit(cur)){
                int curInt = cur-'0';
                if(preSign == '+'){
                    stack.push(curInt);
                }
                if(preSign == '-'){
                    stack.push(-curInt);
                }
                if(preSign == '*'){
                    stack.push(stack.pop()*curInt);
                }
                if(preSign == '/'){
                    stack.push(stack.pop()/curInt);
                }
            }else{
                preSign = cur;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res = res + stack.pop();
        }
        return res;
    }

    public int calculate_2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char preSign = '+';
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
            }
            if (!Character.isDigit(chars[i]) && chars[i] != ' ' || i == chars.length - 1) {
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (preSign == '/') {
                    stack.push(stack.pop() / num);
                }
                preSign = chars[i];
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
