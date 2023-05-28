package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * @author shadow
 * @create 2023-05-28 16:55
 **/
@QuestionTag(
        questionNumber = "567",
        questionTitle = "字符串的排列",
        difficultyLeve = DifficultyLevel.MEDIUM,
        desc = "给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。",
        questionLink = "https://leetcode.cn/problems/permutation-in-string/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP,DataStructType.ARRAY_LIST}
)
public class PermutationString {

    /**
     * @param s
     * @return
     */
    @MethodTag(
            questionNumber = "567",
            methodLink = "https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public String[] permutation(String s) {
        return new String[]{};
    }

}
