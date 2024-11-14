package algorithm.collection.leetcode.november.secondweek.november_14st;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 输入：s = "([])"
 * 输出：true
 *
 * @author shadow
 * @create 2024-11-14 23:24
 **/
public class IsValid {

    public boolean isValid(String s) {
        //先存起来
        Map<Character,Character> dict = new HashMap<>();
        dict.put('(',')');
        dict.put('[',']');
        dict.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            //该单调栈每次只会弹出一个数值
            if(!stack.isEmpty() && dict.containsKey(stack.peek()) && dict.get(stack.peek()).equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
