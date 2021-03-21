package SourceCode.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 */
public class ImplementQueueusingStacks {

    List<Integer> stack;
    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        stack = new ArrayList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int num = stack.get(0);
        stack.remove(0);
        return num;
    }

    /** Get the front element. */
    public int peek() {
        return stack.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }


}
