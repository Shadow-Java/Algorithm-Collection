package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 100. 相同的树
 * {@link algorithm.collection.leetcode.tree.bfs.Symmetric}
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author shadow
 * @create 2023-05-07 23:48
 **/
public class SameTree {

    /**
     * 题类型和101号对称的树类似
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
         * base case即两个节点什么时候相同
         * 包含true和false，那么需要在base包含这两种情况
         * true的最终情况为p == null && q == null
         * false有两种情况
         * 只要把一定为true的情况，和一定为false的情况写上，其他情况则向下递归
         */
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
