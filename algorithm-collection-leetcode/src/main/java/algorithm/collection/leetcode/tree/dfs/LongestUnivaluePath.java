package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 * @author shadow
 * @create 2023-09-16 22:58
 **/
public class LongestUnivaluePath {

    // 最长同值长度，最后肯定是 '∧' 型长度 ， 用 max 记录
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 树形DP，这种题目一般就是分为两大类情况来考虑：(1) 包括头结点的路径；(2) 不包括头结点的路径。每个节点记录5个信息：
     *
     * 1.当前节点的值；
     *
     * 2.包括当前节点，并能和左右两边接起来的长度（横跨头结点的同值路径长度）；
     *
     * 3.包括当前节点，能和右边接起来的长度（往右延伸的最大同值长度）；
     *
     * 4.包括当前节点，能和左边接起来的长度（往左延伸的最大同值长度）；
     *
     * 5.不包括当前节点，从子树传上来的最大同值长度。
     * 返回以当前 root节点 为根节点出发的 最长'/'型 或 '\' 同值长度
     * @param root
     * @return
     */
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        // 得到左子树的最长'/'型 或 '\' 同值长度
        int maxLeft = dfs(root.left);
        // 得到右子树的最长'/'型 或 '\' 同值长度
        int maxRight = dfs(root.right);

        // 现在是左子树有 一条 '/' 型路径，右子树有一条 '\' 型路径，我们要判断这个'/' + '\' 能不能连通当前根节点 形成最长 '∧' 型同值路径
        int curLeft = 0,curRight = 0;

        // 若根节点和左根值相同，那么 根节点 到 左根之间 形成通路，根节点的 左最大同值分支 '/' 可以加上根节点 形成 长度+1 的 '/'
        // 否则只是表示 从 当前根节点 的 左根节点出发 有路径，但是和当前根节点连接断开，故当前根节点的 左出发同值路径，'/' 为0
        if(root.left!=null && root.left.val==root.val)
            curLeft = maxLeft + 1;

        // 若根节点和右根值相同，那么 根节点 到 右根之间 形成通路，根节点的 右最大同值分支 '\' 可以加上根节点 形成 长度+1 的'\'
        // 否则只是表示 从 当前根节点 的 右根节点出发 有路径，但是和当前根节点连接断开，故当前根节点的 右出发同值路径，'\' 为0
        if(root.right!=null && root.right.val==root.val)
            curRight = maxRight + 1;

        // 连接根节点的新的 '/' 和'\' 再形成 新的大 '∧'，从而让 max 记录下了 整颗树中 任意节点能形成的 最大 '∧' 同值路径长度，也是题目要求的
        max = Math.max(max,curLeft+curRight);

        // 返回 左 '/'或 右'\'中分支的长度 最长的 一支长度(若根节点和左右子树都断开，那么显然返回的是 0 ，但递归时max已经记录下了最长'∧'的长度)
        return Math.max(curLeft, curRight);
    }

}
