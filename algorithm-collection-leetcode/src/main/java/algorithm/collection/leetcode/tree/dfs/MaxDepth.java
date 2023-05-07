package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @author shadow
 * @create 2023-05-07 16:37
 **/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left+1,right+1);
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeGenerator.generateBinaryTree(4,13);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(root));
    }

}
