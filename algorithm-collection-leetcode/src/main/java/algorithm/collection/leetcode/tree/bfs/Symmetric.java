package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 101.给你一个二叉树的根节点 root ， 检查它是否轴对称
 *
 * @author shadow
 * @create 2023-05-07 23:02
 **/
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    /**
     * 递归实现
     *   算法的时间复杂度为O(n),因为要遍历n个节点
     *   空间复杂度为O(n) 空间复杂度为树的深度
     * @param left   左树
     * @param right  右树
     * @return
     */
    public boolean isSymmetric(TreeNode left,TreeNode right){
        /**
         * base case 即两个节点什么是对称的
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

    /**
     * bfs遍历
     * @param root
     * @return
     */
    public boolean isSymmetricByBfs(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        /**
         * 使用链表做为队列实现，链表的节点可以为null
         * 如果是使用Deque的ArrayDeque 则不能为空节点
         */
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if(left==null && right==null) {
                continue;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode treeNode = null;
        queue.add(treeNode);
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.add(treeNode);
    }


}
