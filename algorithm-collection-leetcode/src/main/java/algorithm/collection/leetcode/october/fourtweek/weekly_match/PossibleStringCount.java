package algorithm.collection.leetcode.october.fourtweek.weekly_match;

import algorithm.collection.common.datastruct.tag.*;
import algorithm.collection.leetcode.slidingwindow.PermutationString;
import algorithm.collection.leetcode.tree.dfs.MaxDepth;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 3330. 找到初始输入字符串 I
 * Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
 * 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
 * 请你返回 Alice 一开始可能想要输入字符串的总方案数。
 *
 * 输入：word = "abbcccc"
 * 输出：5
 *
 * 解释：
 * 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。
 *
 * 输入：word = "abcd"
 * 输出：1
 *
 * 解释：
 * 唯一可能的字符串是 "abcd" 。
 *
 * 输入：word = "aaaa"
 * 输出：4
 * 计算可能的字符串数量，在至多失误一次的情况下，如果多个字段重复，只能重复其中的一个字符 java
 *
 * @author shadow
 * @create 2024-10-30 00:29
 **/
@QuestionTag(
        questionNumber = "3330. 找到初始输入字符串 I",
        questionTitle = "找到初始输入字符串 I",
        relevateClass = {PermutationString.class, MaxDepth.class, DeepWidthSearch.class},
        difficultyLeve = DifficultyLevel.MEDIUM,
        desc = "Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次",
        algorithmCategory = AlgorithmCategory.BACK_TRACKING,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class PossibleStringCount {


    /**
     * 她可能在一个按键上按太久，导致一个字符被输入多次；表示一个字母可能被输入了多次，而不只是一次；比如a -> aaaa(多输入了三次)
     *
     * dp为了处理边界情况，通常比平时多一个空间；for的遍历是从1到n，是对dp的，但相对于word是dp[i]对于word.charAt(i - 1);
     * 所以i表示dp的前i个字符的总方案数，第i个字符为word.charAt(i - 1)；
     *
     * 对于当前i：
     *        1.不选第i个字符，则dp[i] = dp[i - 1]
     *        2.选择第i个字符，则比较当前字符是否与上一个字符相同，相同则
     * @param word
     * @return
     */
    public int possibleStringCount(String word) {
        //至多失误一次，如果有多个字段重复，只能重复其中的一个字符
        int n = word.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];  // 每个字符单独作为一个字符串
            if (i > 1 && word.charAt(i - 1) == word.charAt(i - 2)) {
                dp[i] += dp[i - 2];  // 如果当前字符和前一个字符相同，则可以将它们合并成一个字符串
            }
        }

        return (int) dp[n];
    }

}
