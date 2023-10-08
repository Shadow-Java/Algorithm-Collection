package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * @author shadow
 * @create 2023-09-17 21:37
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "99",
        questionTitle = "恢复二叉搜索树",
        relevateClass = DeepWidthSearch.class,
        desc = "给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。",
        questionLink = "https://leetcode.cn/problems/recover-binary-search-tree/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.UNIVERSAL_QUEUE}
)
public class RestoreBinarySearchTree {

    //用两个变量x，y来记录需要交换的节点
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;
    /**
     * 当二叉搜索树的值紊乱时，两种解决方式：
     * 1.利用层序遍历将树的值保存在一个数组中，利用中序遍历重新构建一个二叉搜索树
     * 2.这道题刚好是两个节点被错误交换，利用中序遍历记录上一个节点，然后和当前节点进行交换
     * @param root
     */
    @MethodTag(
            questionNumber = "99",
            methodLink = "https://leetcode.cn/problems/recover-binary-search-tree/solutions/271778/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.BINARY_SEARCH_TREE,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public void recoverTree(TreeNode root) {
        dfs(root);
        //如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
    private void dfs(TreeNode node) {
        if(node==null) {
            return;
        }
        dfs(node.left);
        if(pre==null) {
            pre = node;
        } else {
            if(pre.val>node.val) {
                y = node;
                if(x==null) {
                    x = pre;
                }
            }
            pre = node;
        }
        dfs(node.right);
    }

    /**
     * 给定一个升序数组，利用中序遍历构建一个二叉搜索树
     * @param inorder
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildBST(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = buildBST(inorder, start, mid - 1);
        root.right = buildBST(inorder, mid + 1, end);

        return root;
    }

    public TreeNode buildBSTFromInorder(int[] inorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        return buildBST(inorder, 0, inorder.length - 1);
    }

}
