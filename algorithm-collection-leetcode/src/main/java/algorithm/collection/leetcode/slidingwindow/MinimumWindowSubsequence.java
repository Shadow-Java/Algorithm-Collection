package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
 *
 * 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
 *
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *
 * @author shadow
 * @create 2023-05-28 17:00
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "727",
        questionTitle = "最小窗口子序列",
        relevateClass = {MinimumWindowSubstring.class},
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/minimum-window-subsequence/description/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        timeComplexity = TimeComplexity.O_N
)
public class MinimumWindowSubsequence {

    /**
     * 1.什么是子序列：即按照T中顺序出现，且包含所有字符的字符串
     * 2.需要最短且左窗口最靠左
     * @param s1
     * @param s2
     * @return
     */
    @MethodTag(
            questionNumber = "727",
            methodLink = "https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/solutions/240717/pai-xu-hua-chuang-by-netcan/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public String minWindow(String s1, String s2) {
        return "";
    }

}
