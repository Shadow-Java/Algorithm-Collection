package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tree.NTreeNode;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1.怎么遍历一棵树，递归的前序中序，dfs和bfs
 * 2.不同的树怎么遍历，二叉搜索树，索引树怎么遍历
 * @author shadow
 * @create 2023-09-07 23:12
 **/
public class TreeBase {


    /**
     * 先序遍历
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * N叉树遍历
     */
    public void preOrderN(NTreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        for (NTreeNode child : root.children){
            preOrderN(child,res);
        }
    }

    public void traverse(NTreeNode root){
        if(root == null){
            return;
        }
        List<Integer> nodeValList = new ArrayList<>();
        Deque<NTreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while (!nodeDeque.isEmpty()){
            NTreeNode curNode = nodeDeque.pop();
            nodeValList.add(curNode.val);
            List<NTreeNode> childrenNodes = curNode.children;
            nodeDeque.addAll(childrenNodes);
        }
    }

    public static void main(String[] args) {
        /**
         * 1.当使用 Deque 作为队列时，通常使用以下方法进行操作：
         *
         * addLast() 或 offerLast()：将元素添加到队列的尾部。
         * removeFirst() 或 pollFirst()：移除并返回队列的头部元素。
         * peekFirst()：返回队列的头部元素，但不进行移除操作。
         * add()添加和poll()移除
         *
         * 2.当使用 Deque 作为栈时，通常使用以下方法进行操作：
         *
         * push() 或 addFirst()：将元素添加到栈的头部。
         * pop() 或 removeFirst()：移除并返回栈的头部元素。
         * peek() 或 peekFirst()：返回栈的头部元素，但不进行移除操作。
         *
         * poll() 方法在队列为空时返回 null，而 pop() 方法在队列为空时抛出异常。
         * poll() 是安全的方法，可以在队列为空时返回 null，而 pop() 是非安全的方法，在队列为空时会抛出异常。
         *
         * offer() 方法在队列已满时返回 false，而 add() 方法在队列已满时抛出异常。
         * offer() 是安全的方法，可以在队列已满时返回 false，而 add() 是非安全的方法，在队列已满时会抛出异常。
         */
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque.poll());
        System.out.println(4);
    }


}
