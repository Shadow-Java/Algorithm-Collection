package algorithm.collection.leetcode.list;

import algorithm.collection.leetcode.baseclass.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO
 *
 * @author shadow
 * @date 2023/4/10 9:28
 * @since 1.0
 */
public class NextLargerNodes {


    private int[] ans;
    private final Deque<Integer> st = new ArrayDeque<>(); // 单调栈（节点值）

    public int[] nextLargerNodes(ListNode head) {
        f(head, 0);
        return ans;
    }

    private void f(ListNode node, int i) {
        if (node == null) {
            ans = new int[i]; // i 就是链表长度
            return;
        }
        f(node.next, i + 1);
        while (!st.isEmpty() && st.peek() <= node.val) {
            st.pop(); // 弹出无用数据
        }
        if (!st.isEmpty()) {
            ans[i] = st.peek(); // 栈顶就是第 i 个节点的下一个更大元素
        }
        st.push(node.val);
    }


}
