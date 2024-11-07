package algorithm.collection.leetcode.november.firstweek.november_7st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * @author shadow
 * @create 2024-11-07 22:30
 **/
public class DiameterOfBinaryTree {

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }
    public int depth(TreeNode root){
        if (root == null) return 0;
        //先考虑最下层的空节点

        int L = depth(root.left);
        int R = depth(root.right);
        //考虑中间层的左边的深度以及右节点的深度

        ans = Math.max(ans, L + R + 1);
        //上层的深度更新

        return Math.max(L, R) + 1;
        //返回给更上一层的深度
        //底层->中间层->上层->更上层
    }

}
