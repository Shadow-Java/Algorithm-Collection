package algorithm.collection.leetcode.november.firstweek.november_6st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * 输入：root = [1,null,2]
 * 输出：2
 * @author shadow
 * @create 2024-11-06 23:38
 **/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }

}
