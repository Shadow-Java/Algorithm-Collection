package algorithm.collection.leetcode.tree.binaryIndexedTree;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * @author shadow
 * @create 2023-09-17 19:52
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "1719",
        questionTitle = "重构一棵树的方案数",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个数组 pairs ，其中 pairs[i] = [xi, yi] ，并且满足：",
        questionLink = "https://leetcode.cn/problems/number-of-ways-to-reconstruct-a-tree/description/",
        algorithmCategory = AlgorithmCategory.BIT_MANIPULATION,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class ReconstructNumberScenariosTree {


    public int checkWays(int[][] pairs) {
        return 0;
    }
}
