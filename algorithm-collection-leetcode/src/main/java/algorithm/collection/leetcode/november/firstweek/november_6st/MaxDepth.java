package algorithm.collection.leetcode.november.firstweek.november_6st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
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
