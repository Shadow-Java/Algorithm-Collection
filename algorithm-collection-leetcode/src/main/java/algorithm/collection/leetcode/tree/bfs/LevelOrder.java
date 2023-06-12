package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static algorithm.collection.common.datastruct.tree.BinaryTreeGenerator.generateBinaryTree;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelLists = new ArrayList<>();
        return bfs(root,levelLists);
    }

    public static void main(String[] args) {
        TreeNode root = generateBinaryTree(3, 10);
        System.out.println("----------------二叉树的形状----------------");
        BinaryTreeGenerator.printTreeByOrderLevel(root);
        System.out.println("");
        System.out.println("----------------二叉树的层序遍历----------------");
        levelOrder(root);
    }

    /**
     * 宽度优先遍历实现层序遍历
     * @param root  头结点
     * @param levelList 层序遍历的结果
     * @return
     */
    public static List<List<Integer>> bfs(TreeNode root,List<List<Integer>> levelList){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while(!nodeDeque.isEmpty()){
            int n = nodeDeque.size();//每一层的节点数
            //存储下一层的节点
            List<Integer> levelNodeVals = new ArrayList<>();
            for(int i=0;i<n;i++){
                //遍历该节点
                TreeNode curNode = nodeDeque.pop();
                levelNodeVals.add(curNode.getVal());
                System.out.print(curNode.getVal()+" ");
                //将该节点数的左右子节点加入队列
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
