package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.slidingwindow.PermutationString;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * @author shadow
 * @create 2023-05-28 17:49
 **/
@QuestionTag(
        questionNumber = "剑指 Offer 38",
        questionTitle = "字符串的排列",
        relevateClass = {PermutationString.class,MaxDepth.class, DeepWidthSearch.class},
        difficultyLeve = DifficultyLevel.MEDIUM,
        desc = "输入一个字符串，打印出该字符串中字符的所有排列。即全排列",
        questionLink = "https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_LOG_N,
        dataStructTypes = {DataStructType.UNIVERSAL_STACK}
)
public class PermutationofString {

    /**
     * 深度优先搜索
     * TODO
     * @param s
     * @return
     */
    @MethodTag(
            questionNumber = "剑指 Offer 38",
            methodLink = "https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/",
            timeComplexity = TimeComplexity.O_LOG_N,
            dataStructType = DataStructType.UNIVERSAL_STACK,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public String[] permutation(String s) {

        return new String[]{};
    }

}
