package src;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 */
public class BinarySearchTreeIterator {

    List<Integer> nodes = new ArrayList<>();

    /**
     * 该题目前提是一个二叉搜索树，是前提有序，那么每次中序遍历都能获取到最小值
     */
    /**
     * 第一种方法：先存值再遍历，时间复杂度O（N）
     * 利用一个队列或者栈或者list集合，去依次递归存入中序遍历的值，每次获取则出栈或删除该节点
     * @param root
     */
    public BinarySearchTreeIterator(TreeNode root) {//bfs广度优先搜索
        bfs(root,nodes);
    }

    /**
     * 第二种方法：迭代遍历，使用时才遍历，均摊时间复杂度O（N）
     * 这样做的效果就是，当需要的节点在头结点时，只需O（1）就能完成
     *
     * 实现方法：维护一个单调递减栈（从插入顺序来说是递减的），我初始状态只遍历左节点（构造函数），将左节点依次入栈
     * 我需要时（调用next方法），就将当前的栈顶出栈（最小值，且无右子节点），其次再遍历该栈顶节点是否有右子树（以该右节点为主节点，迭代获取他的左节点），再返回值
     *
     * @param root
     * @param nodes
     */

    public void bfs(TreeNode root,List<Integer> nodes){//递归调用
        if(root == null) return;
        if(root.left != null){
            bfs(root.left,nodes);
        }
        nodes.add(root.val);
        if(root.right != null){
            bfs(root.right,nodes);
        }
    }

    public int next() {
        int node = nodes.get(0);
        nodes.remove(0);
        return node;
    }

    public boolean hasNext() {
        if(!nodes.isEmpty()){
            return true;
        }
        return false;
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
