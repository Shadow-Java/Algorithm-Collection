package algorithm.collection.leetcode.stack;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.slidingwindow.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 输入：s = "(]"
 * 输出：false
 *
 * @author shadow
 * @create 2023-05-18 00:33
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "20",
        questionTitle = "有效的括号",
        relevateClass = {MinimumWindowSubstring.class},
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/valid-parentheses/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        dataStructTypes = DataStructType.MONOTONIC_STACK,
        timeComplexity = TimeComplexity.O_N
)
public class VaildParentheses {

    /**
     * 括号肯定是成对出现的，那么只需要将前n/2入栈，后面n/2根据出栈匹配即可
     *
     * @param s
     * @return
     */
    @MethodTag(
            questionNumber = "20",
            methodLink = "https://leetcode.cn/problems/valid-parentheses/solutions/1974649/you-xiao-de-gua-hao-by-leetcode-learning-p2qg/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.UNIVERSAL_QUEUE,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        /**
         * 只有匹配到左括号才入栈
         * todo 如果改成deque则会通过不了用例"([)]"
         */
        Stack<Character> stack = new Stack<>();
        List<Character> leftChs = List.of('(', '{', '[');
        /**
         * 括号字典集合
         */
        Map<Character, Character> dicMap = new HashMap<>();
        dicMap.put(')', '(');
        dicMap.put('}', '{');
        dicMap.put(']', '[');
        for (char ch : s.toCharArray()) {
            //只有左括号才入栈
            if (leftChs.contains(ch)) {
                stack.add(ch);
            } else {
                //可能出现没有左括号只有右括号的情况，dicMap.get(ch).equals(stack.pop()) 必须是左右匹配才行
                if (!dicMap.containsKey(ch) || stack.isEmpty() || !dicMap.get(ch).equals(stack.pop())) {
                    return false;
                }
            }
        }
        //可能存在只有左括号没有右括号
        return stack.isEmpty();
    }

}
