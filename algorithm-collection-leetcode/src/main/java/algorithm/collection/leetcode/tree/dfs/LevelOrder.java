package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static algorithm.collection.common.datastruct.tree.BinaryTreeGenerator.generateBinaryTree;
import static algorithm.collection.common.datastruct.tree.BinaryTreeGenerator.printTree;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelLists = new ArrayList<>();
        return dfs(root,levelLists);
    }

    public static void main(String[] args) {
        TreeNode root = generateBinaryTree(3, 10);
        System.out.println("----------------二叉树的形状----------------");
        printTree(root);
        System.out.println("");
        System.out.println("----------------二叉树的层序遍历----------------");
        levelOrder(root);
    }

    public static List<List<Integer>> dfs(TreeNode root,List<List<Integer>> levelList){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while(!nodeDeque.isEmpty()){
            int n = nodeDeque.size();//每一层的节点数
            List<Integer> levelNodeVals = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curNode = nodeDeque.pop();
                levelNodeVals.add(curNode.getVal());
                System.out.print(curNode.getVal()+" ");
                if(curNode.getLeft() != null){
                    nodeDeque.add(curNode.getLeft());
                }
                if(curNode.getRight() != null){
                    nodeDeque.add(curNode.getRight());
                }
            }
            System.out.println("");
            levelList.add(levelNodeVals);
        }
        return levelList;
    }

}
