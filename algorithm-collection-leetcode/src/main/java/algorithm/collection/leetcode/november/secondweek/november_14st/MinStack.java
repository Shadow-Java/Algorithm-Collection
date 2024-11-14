package algorithm.collection.leetcode.november.secondweek.november_14st;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author shadow
 * @create 2024-11-14 23:37
 **/
public class MinStack {

    private PriorityQueue<Integer> queue;
    private Stack<Integer> stack;
    public MinStack() {
        queue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.offer(val);
    }

    public void pop() {
        int val = stack.pop();
        queue.remove(val);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }

}
