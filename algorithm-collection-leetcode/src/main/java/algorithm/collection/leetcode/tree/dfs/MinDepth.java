package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * @author shadow
 * @create 2023-05-04 23:39
 **/
public class MinDepth {

    /**
     * 最优的解法使用dfs或者bfs
     * bfs解决的问题有两类：1.两点之间是否有路径 2.两点之间最短路径
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        int minDepth = 0;
        while (!nodeDeque.isEmpty()){
            //第minDepth层
            minDepth++;
            int n = nodeDeque.size();
            for (int i=0;i<n;i++){
                TreeNode treeNode = nodeDeque.pop();
                /**
                 * 终点即叶子节点
                 */
                if(treeNode.getLeft() == null && treeNode.getRight() == null){
                    return minDepth;
                }
                if(treeNode.getLeft() != null){
                    nodeDeque.add(treeNode.getLeft());
                }
                if(treeNode.getRight() != null){
                    nodeDeque.add(treeNode.getRight());
                }
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeGenerator.generateBinaryTree(4,15);
        BinaryTreeGenerator.printTree(root);
        System.out.println(minDepth(root));
    }

}
