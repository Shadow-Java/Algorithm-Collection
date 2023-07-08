package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.List;

/**
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 * @author shadow
 * @create 2023-06-28 21:28
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "95",
        questionTitle = "不同的二叉搜索树 II",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树",
        questionLink = "https://leetcode.cn/problems/unique-binary-search-trees-ii/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.UNIVERSAL_QUEUE}
)
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

}
