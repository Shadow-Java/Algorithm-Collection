package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.tree.binarysearch.GenerateTrees;

/**
 * @author shadow
 * @create 2023-10-14 02:18
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "96",
        questionTitle = "不同的二叉搜索树",
        relevateClass = GenerateTrees.class,
        desc = "给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。",
        questionLink = "https://leetcode.cn/problems/unique-binary-search-trees/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DifferentBinarySearchTree {

    /**
     * G(n): 长度为 nnn 的序列能构成的不同二叉搜索树的个数
     * F(i,n): 以 iii 为根、序列长度为 nnn 的不同二叉搜索树个数 (1≤i≤n)
     * 动态规划G（i）=f(0)+...+f(i)+...f(n)
     * 总的f(i) = G(i-1)*G(n-i)
     * 创建以 3 为根、长度为 7 的不同二叉搜索树，整个序列是 [1,2,3,4,5,6,7]，我们需要从左子序列 [1,2]构建左子树，从右子序列 [4,5,6,7] 构建右子树，然后将它们组合（即笛卡尔积）
     *
     */
    @MethodTag(
            questionNumber = "96",
            methodLink = "https://leetcode.cn/problems/unique-binary-search-trees/description/",
            timeComplexity = TimeComplexity.O_LOG_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){//根节点
            for(int j=1;j<i+1;j++){//该轮中有i个节点的树
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }
}
