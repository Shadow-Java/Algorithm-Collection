package algorithm.collection.leetcode.november.firstweek.november_8st;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 * @author shadow
 * @create 2024-11-08 23:26
 **/
public class Flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Flatten flatten = new Flatten();
        flatten.flatten(root);
    }


    public void flatten_V2(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    public void flatten(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (int val : ans) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        //只是改变了root变量的引用，但不会对root这棵树的指针引起改变
        root = dummy.right;
    }

    public void preOrder(TreeNode root,List<Integer> ans) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }

}
