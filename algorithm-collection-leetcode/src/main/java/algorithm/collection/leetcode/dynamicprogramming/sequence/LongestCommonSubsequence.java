package algorithm.collection.leetcode.dynamicprogramming.sequence;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.linear.HouseRobber;

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0
 */
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1143",
        questionTitle = "最长公共子序列",
        relevateClass = HouseRobber.class,
        desc = "在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数",
        questionLink = "https://leetcode.cn/problems/longest-common-subsequence/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class LongestCommonSubsequence {
    /**
     * 动态规划
     *
     * 首先，区分两个概念：子序列可以是不连续的；子数组（子字符串）需要是连续的；
     * 另外，动态规划也是有套路的：单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；
     * 当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j]，其含义是在 A[0:i] 与 B[0:j]之间匹配得到的想要的结果。
     *
     * 定义是dp[i][j]是text[0..i-1] text2[0..j-1]的最长子串
     * @param text1
     * @param text2
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/longest-common-subsequence/solution/gong-shui-san-xie-zui-chang-gong-gong-zi-xq0h/",
            questionNumber = "1143",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        //跟单数组一样，拓展一位可以减少dp[1]的初始化，动态规划一般是初始化前两位
        //为什么要使用二维数组:因为是比较两个字符串，dp[i][j]的含义是s1[0...i]和s2[0...j]的公共子序列的最长长度
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {//新增一位，要么两位相等，要么不等
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {//当前的值i-1
                    dp[i][j] = dp[i - 1][j - 1] + 1;//dp[i]为text[i-1]的最长序列
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

}
