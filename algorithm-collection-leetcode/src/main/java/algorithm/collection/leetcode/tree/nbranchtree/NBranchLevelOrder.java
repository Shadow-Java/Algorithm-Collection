package algorithm.collection.leetcode.tree.nbranchtree;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;
import cn.hutool.core.lang.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * @author shadow
 * @create 2023-06-11 22:42
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "429",
        questionTitle = "N 叉树的层序遍历",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target,letters 里至少有两个不同的字符。",
        questionLink = "https://leetcode.cn/problems/n-ary-tree-level-order-traversal/",
        algorithmCategory = AlgorithmCategory.BINARY_FIND,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NBranchLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        return new ArrayList<>();
    }

}
