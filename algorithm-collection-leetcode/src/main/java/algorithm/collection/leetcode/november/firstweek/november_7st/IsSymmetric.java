package algorithm.collection.leetcode.november.firstweek.november_7st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * @author shadow
 * @create 2024-11-07 22:08
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left==null && root.right==null)) {
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        /**
         * base case 即什么是对称的
         */
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

}
