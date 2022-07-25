package intermittent.lying.continuous.progress.deprecated;

import java.util.Stack;

/**
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 */
public class ClumsyFactorial {
    /**
     * 对于计算器的策略：可以利用栈的特性，对于乘除的算法将栈顶和当前数的结果入栈，对于“-”，则将负数入栈，最后栈里全是整型数，求和即可
     * 栈的实现方法：Stack<Integer> stack = new Stack<>();
     * Deque<Integer> stack=new LinkedList<>();
     * 时间复杂度：O（N），栈不需遍历，求和时近似于O（N）
     * 空间复杂度：O（N），Stack<Integer> stack = new Stack<>();
     * @param N
     * @return
     */
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);int index = 0;
        for(int i=N-1;i > 0;i--){
            if(index == 0){
                stack.push(stack.pop()*i);
            }
            if(index == 1){
                stack.push(stack.pop()/i);
            }
            if(index == 2){
                stack.push(i);
            }
            if(index == 3){//不处理
                stack.push(-i);
                index = -1;
            }
            index++;
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }


    /**
     * 数学解法：我们知道a*b/c+d是固定的，所以可以按四位一组进行计算
     * @param n
     * @return
     */
    public int clumsy_2(int n) {
        int[] special = new int[]{1,2,6,7};
        int[] diff = new int[]{1,2,2,-1};
        if (n <= 4) return special[(n - 1) % 4];
        return n + diff[n % 4];
    }

}
