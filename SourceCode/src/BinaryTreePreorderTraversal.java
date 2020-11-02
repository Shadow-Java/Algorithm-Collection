import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreePreorderTraversal {
    /*
    *递归的前序遍历,先遍历根节点，再遍历左节点，其次右节点（以节点为空遍历结束）
    */

    public void recursive(TreeNode root,List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        recursive(root.left,res);
        recursive(root.right,res);
    }

    /**
     * 递归中序遍历，先遍历左节点，再根节点，再右节点
     * @param head
     */
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrderRecur(head.left);
        System.out.print(head.val + " ");
        preOrderRecur(head.right);
    }

    /**
     * 递归后序遍历，先遍历左节点，再右节点，再根节点
     * @param head
     */
    public static void postOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val + " ");
    }


    /**
     * 迭代的前序遍历，利用栈Stack数据结构
     * @param head
     */
    public static void preOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            //注意这里迭代是先加入右节点，因为用的是栈数据结构
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root,res);
        return res;
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
