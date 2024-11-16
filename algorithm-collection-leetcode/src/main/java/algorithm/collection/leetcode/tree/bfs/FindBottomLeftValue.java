package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * @author shadow
 * @create 2024-11-16 16:33
 **/
public class FindBottomLeftValue {

    /**
     * 找罪底层左边的节点，那么使用层序遍历，将入队顺序换一下，先入队右边再入队左边，那么最后一个节点就是最左边第一个节点
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        TreeNode ans = root;
        while (!deque.isEmpty()) {
            ans = deque.pollFirst();
            if(ans.right != null) {
                deque.offerLast(ans.right);
            }
            if(ans.left != null) {
                deque.offerLast(ans.left);
            }
        }
        return ans.val;
    }

}
