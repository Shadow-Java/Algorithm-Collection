package algorithm.collection.common.datastruct.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class BinaryTreeGenerator {

    public static TreeNode generateBinaryTree(int depth, int maxValue) {
        if (depth < 1) {
            return null;
        }
        Random random = new Random();
        TreeNode root = new TreeNode(random.nextInt(maxValue + 1));
        root.left = generateBinaryTree(depth - 1, maxValue);
        root.right = generateBinaryTree(depth - 1, maxValue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateBinaryTree(3, 10);
        // 输出生成的二叉树
        //printTree(root);
        printTreeByOrderLevel(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeByOrderLevel(TreeNode root) {
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelLists = new ArrayList<>();
        return dfs(root,levelLists);
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
