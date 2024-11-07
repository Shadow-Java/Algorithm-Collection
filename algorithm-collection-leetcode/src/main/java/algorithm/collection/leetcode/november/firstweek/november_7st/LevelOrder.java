package algorithm.collection.leetcode.november.firstweek.november_7st;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 输入：root = []
 * 输出：[]
 *
 * @author shadow
 * @create 2024-11-07 23:09
 **/
public class LevelOrder {

    /**
     * 二叉树的层序遍历：因为是先进先出的顺序，所以用的是队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i=1;i<=n;i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

}
