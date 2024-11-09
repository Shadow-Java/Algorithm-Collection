package algorithm.collection.leetcode.november.firstweek.november_8st;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 *
 *
 * @author shadow
 * @create 2024-11-08 22:55
 **/
public class RightSideView {

    public List<Integer> rightSideView_V2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) { // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }


    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i=1;i<=n;i++) {
                if(i == 1) {
                    ans.add(deque.poll().val);
                }
                if(root.right != null) {
                    deque.offer(root.right);
                }
                if(root.left != null) {
                    deque.offer(root.left);
                }
            }
        }
        return ans;
    }

    public void dfs(TreeNode root,List<Integer> ans) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        if(root.right != null) {
            dfs(root.right,ans);
        } else {
            dfs(root.left,ans);
        }
    }

}
