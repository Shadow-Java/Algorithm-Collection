package src;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 */

public class EvaluateReversePolishNotation {

    /**
     * 使用栈处理
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        //利用栈结构，如果是数字则进栈，遇到op，则计算前两个数，值则入栈
        Stack<String> stack = new Stack();
        List<String> ops = Arrays.asList("*","+","-","/");
        for(String token : tokens){
            if(!ops.contains(token)){
                stack.push(token);
            }else{
                int val_1 = Integer.parseInt(stack.pop());
                int val_2 = Integer.parseInt(stack.pop());
                int result = 0;
                if("*".equals(token)){
                    result = val_1 * val_2;
                }
                if("+".equals(token)){
                    result = val_2 + val_1;
                }
                if("-".equals(token)){
                    result = val_2 - val_1;
                }
                if("/".equals(token)){
                    result = val_2 / val_1;
                }
                stack.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
