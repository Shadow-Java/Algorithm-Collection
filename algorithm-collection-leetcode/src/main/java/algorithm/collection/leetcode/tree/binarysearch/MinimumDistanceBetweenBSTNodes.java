package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2023-09-07 23:02
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "783",
        questionTitle = "二叉搜索树节点最小距离",
        relevateClass = SerializeDeserializeBST.class,
        desc = "给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值。",
        questionLink = "https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.BINARY_TREE}
)
public class MinimumDistanceBetweenBSTNodes {

    @QuestionTag(
            difficultyLeve = DifficultyLevel.MEDIUM,
            questionNumber = "783",
            questionTitle = "二叉搜索树节点最小距离",
            relevateClass = SerializeDeserializeBST.class,
            desc = "给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值。",
            questionLink = "https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/",
            algorithmCategory = AlgorithmCategory.OTHER,
            timeComplexity = TimeComplexity.O_N_2,
            dataStructTypes = {DataStructType.BINARY_TREE}
    )
    public static int minDiffInBST(TreeNode root) {
        /**
         * 层序遍历后的数组(可以使用前序中序后序遍历存储数组节点，然后使用dp)
         * 二叉树的中序遍历是依次递增的
         */
        int[] nums = {4,2,6,1,8};
        /**
         * 使用dp求最小值
         */
        Arrays.sort(nums);
        /**
         * dp[i]表示为0---i区间的最小差值
         */
        int[] dp = new int[nums.length];
        dp[0] = Integer.MAX_VALUE;
        for (int i=1;i< nums.length;i++){
            dp[i] = Math.min(Math.abs(nums[i]-nums[i-1]),dp[i-1]);
        }
        return dp[nums.length-1];
    }


    int ans, pre;

    public int minDiffInBSTAnotherWay(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        inorder(root);
        return ans;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre != -1) {
            ans = Math.min(ans, node.val - pre);
        }
        pre = node.val;
        inorder(node.right);
    }



    public static void main(String[] args) {
        System.out.println(minDiffInBST(null));
    }

}
