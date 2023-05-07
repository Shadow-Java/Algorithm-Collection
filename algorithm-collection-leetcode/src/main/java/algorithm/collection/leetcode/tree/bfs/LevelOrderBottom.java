package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author shadow
 * @create 2023-05-04 23:23
 **/
public class LevelOrderBottom {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelValList = new ArrayList<>();
        if(root == null){
            return levelValList;
        }
        Deque<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()){
            int n = levelQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<n;i++){
                TreeNode treeNode = levelQueue.pop();
                list.add(treeNode.getVal());
                if(treeNode.getLeft() != null){
                    levelQueue.add(treeNode.getLeft());
                }
                if(treeNode.getRight() != null){
                    levelQueue.add(treeNode.getRight());
                }
            }
            levelValList.add(list);
        }
        Collections.reverse(levelValList);
        return levelValList;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeGenerator.generateBinaryTree(4,14);
        BinaryTreeGenerator.levelOrder(root);
        levelOrderBottom(root).forEach(list ->{
            System.out.println("");
            list.forEach(val -> System.out.print(val+"  "));
        });
    }

}
