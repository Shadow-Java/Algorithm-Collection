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
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author shadow
 * @create 2023-10-08 20:36
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "108",
        questionTitle = "将有序数组转换为二叉搜索树",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。",
        questionLink = "https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class SortedArrayToBST {

    /**
     * 二分法插入节点
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "108",
            methodLink = "https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/313508/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.BALANCE_BINARY_SEARCH_TREE,
            algorithmCategory = AlgorithmCategory.RECURSION
    )
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBalanceBST(nums,0, nums.length-1);
    }

    public TreeNode buildBalanceBST(int[] nums,int i,int j){
        //递归创建平衡二叉树
        if(i > j){
            return null;
        }
        //如果是i+(j-i)/2是中间偏左，如果是i+(j-i+1)/2则找的是中间偏右的节点
        int mid = i+(j-i+1)/2;
        //找到中间节点获取节点值
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalanceBST(nums,i,mid-1);
        root.right = buildBalanceBST(nums,mid+1,j);
        return root;
    }

}
