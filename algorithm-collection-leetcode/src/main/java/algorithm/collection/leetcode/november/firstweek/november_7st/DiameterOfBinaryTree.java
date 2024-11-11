package algorithm.collection.leetcode.november.firstweek.november_7st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 *
 * 输入：root = [1,2]
 * 输出：1
 *
 *
 * @author shadow
 * @create 2024-11-07 22:30
 **/
public class DiameterOfBinaryTree {

    int ans;
    /**
     * 遍历二叉树，在计算最长链的同时，随便把直径算出来（跟二叉树的最大深度类似）
     * 在当前节点[拐弯]的直径长度 = 左子树的最长链+右子树的最长链+2
     * 返回给父节点的是以当前节点为根的子树的最长链 = max(左子树的最长链，右子树的最长链)+1
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans-1;
    }

    /**
     * 最大深度指的是节点数，如下深度为2（两个节点），如果只有一个节点则深度为1；如果在直径的计算上
     *       1
     *      / \
     *     2   3
     *
     * @param root
     * @return
     */
    public int depth(TreeNode root){
        if (root == null) return 0;//深度为节点数，没有节点则为0
        //先考虑最下层的空节点

        int L = depth(root.left);
        int R = depth(root.right);
        //考虑中间层的左边的深度以及右节点的深度

        ans = Math.max(ans, L + R );
        //上层的深度更新

        return Math.max(L, R) + 1;//返回的深度
        //返回给更上一层的深度
        //底层->中间层->上层->更上层
    }

}
