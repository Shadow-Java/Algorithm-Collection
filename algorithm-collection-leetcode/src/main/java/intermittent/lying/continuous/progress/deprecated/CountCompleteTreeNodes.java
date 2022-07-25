package intermittent.lying.continuous.progress.deprecated;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class CountCompleteTreeNodes {

    /**
     * 递归DFS求解，太秒了
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    public int countNodes_BFS(TreeNode root) {
        if(root == null) return 0;
        //层序遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int length = 0;
        while(!q.isEmpty()){
            TreeNode pre = q.poll();
            length++;
            if(pre.left != null) q.offer(pre.left);
            if(pre.right != null) q.offer(pre.right);

        }
        return length;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
