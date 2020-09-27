import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorBinary {
    //因为是二叉搜索树，对于父结点和子结点的关系是父结点位置*2==左子结点位置，父结点位置*2+1=右子结点
    //二叉搜索树是左结点小于root，右节点大于root
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root,p,q);
        return res;
    }

    public void search(TreeNode root, TreeNode p, TreeNode q){
        if((root.val - p.val) * (root.val - q.val) <= 0){
            res = root;
        }
        if(root.val > p.val && root.val > q.val){
            search(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            search(root.right,p,q);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

