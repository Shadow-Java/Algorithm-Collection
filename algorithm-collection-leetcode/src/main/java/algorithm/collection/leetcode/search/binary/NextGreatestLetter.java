package algorithm.collection.leetcode.search.binary;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 *
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 *
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 解释：letters 中字典上比 'a' 大的最小字符是 'c'。
 *
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。
 *
 * 输入: letters = ["x","x","y","y"], target = "z"
 * 输出: "x"
 * 解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。
 *
 * @author shadow
 * @create 2023-06-09 22:53
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "744",
        questionTitle = "寻找比目标字母大的最小字母",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target,letters 里至少有两个不同的字符。",
        questionLink = "https://leetcode.cn/problems/find-smallest-letter-greater-than-target/",
        algorithmCategory = AlgorithmCategory.BINARY_FIND,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NextGreatestLetter {

    /**
     * 暴力检索:因为是循环出现的，只需要遍历数组，大于则返回；找不到则返回第一个
     *
     * @param letters
     * @param target
     * @return
     */
    @MethodTag(
            questionNumber = "744",
            methodLink = "https://leetcode.cn/problems/find-smallest-letter-greater-than-target/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target ) {
                return letters[i];
            }
        }
        return letters[0];
    }


    /**
     * 因为有序，则可以用二分法查找，而且这是二分寻找边界值的方式
     * @param letters
     * @param target
     * @return
     */
    @MethodTag(
            questionNumber = "744",
            methodLink = "https://leetcode.cn/problems/find-smallest-letter-greater-than-target/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BINARY_FIND
    )
    public char nextGreatestLetterAnotherWay(char[] letters, char target) {
        int len = letters.length;
        int l = 0;
        int r = len - 1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (target < letters[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        /**
         * 循环结束时 l 指向数组中比目标字母大的最小字母，如果目标字母比所有字母都大，则 l = letters.size()，l mod letters.size() = 0，指向数组第一个字母。
         */
        return letters[l % len];
    }

}
