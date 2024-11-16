package algorithm.collection.leetcode.november.secondweek.november_14st;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 *
 * @author shadow
 * @create 2024-11-15 20:59
 **/
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString("3[a]2[bc]");
    }

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if(ch.equals(']')) {
                String dict = "";
                while (!stack.isEmpty() && (stack.peek() >= 'a' && stack.peek() <= 'z')) {
                    dict = stack.pop()+dict;
                }
                int num = 0;
                if(!stack.isEmpty() && (stack.peek() >= '1' && stack.peek() <= '9')) {
                    num = stack.pop()-'0';
                }
                for (int i = 1;i<=num;i++) {
                    for (Character re:dict.toCharArray()) {
                        stack.push(re);
                    }
                }
            } else if(ch.equals('[')) {
                continue;
            } else {
                stack.push(ch);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop()+res;
        }
        return res;
    }

}
