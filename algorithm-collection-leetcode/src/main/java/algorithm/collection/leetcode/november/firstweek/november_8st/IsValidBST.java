package algorithm.collection.leetcode.november.firstweek.november_8st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * @author shadow
 * @create 2024-11-08 22:04
 **/
public class IsValidBST {


    /**
     * 1.二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
     * @param root
     * @return
     */
    public boolean isValidBST_V2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right &&
                isValidBST(node.left, left, x) &&
                isValidBST(node.right, x, right);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }
        if(root.right == null && root.left == null) {
            return true;
        }
        return root.val > max(root.left) && root.val < min(root.right);
    }

    public int max(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int min = Math.max(min(root.left),min(root.right));
        return Math.max(root.val,min);
    }

    public int min(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int min = Math.min(min(root.left),min(root.right));
        return Math.min(root.val,min);
    }

}
