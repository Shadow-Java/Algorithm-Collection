package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2023-09-17 21:03
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "897",
        questionTitle = "递增顺序搜索树",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。",
        questionLink = "https://leetcode.cn/problems/increasing-order-search-tree/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.UNIVERSAL_QUEUE}
)
public class IncreasingSequentialSearchTree {

    @MethodTag(
            questionNumber = "897",
            methodLink = "https://leetcode.cn/problems/increasing-order-search-tree/solutions/742210/fu-xue-ming-zhu-fen-xiang-er-cha-shu-san-hljt/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.BINARY_SEARCH_TREE,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public TreeNode increasingBST(TreeNode root) {
        /**
         * 二叉搜索树是左节点小于等于节点，右节点大于等于节点值
         * 中序遍历是先访问左节点，再访问根节点，故中序遍历能让二叉搜索树的值从小到大递增（需要先访问）
         */
        List<Integer> nodeList = new ArrayList<>();
        inOrder(root,nodeList);
        TreeNode leaft = new TreeNode();
        TreeNode preNode = leaft;
        for(Integer val:nodeList){
            leaft.right = new TreeNode(val);
            leaft = leaft.right;
        }
        return preNode.right;
    }

    public void inOrder(TreeNode root, List<Integer> nodeList){
        if(root == null){
            return;
        }
        inOrder(root.left,nodeList);
        nodeList.add(root.val);
        inOrder(root.right,nodeList);
    }

}
