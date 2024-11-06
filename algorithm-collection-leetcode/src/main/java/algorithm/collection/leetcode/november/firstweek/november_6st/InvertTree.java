package algorithm.collection.leetcode.november.firstweek.november_6st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * @author shadow
 * @create 2024-11-06 23:40
 **/
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

}
