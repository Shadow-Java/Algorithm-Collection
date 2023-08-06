package algorithm.collection.leetcode.dynamicprogramming.sequence;


import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;


/**
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 *
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * @author shadow
 * @create 2023-08-06 15:28
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "583",
        questionTitle = "两个字符串的删除操作",
        relevateClass = LongestCommonSubsequence.class,
        desc = "给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数",
        questionLink = "https://leetcode.cn/problems/delete-operation-for-two-strings/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DeleteOperationforTwoStrings {


    /**
     * 问题等价于求解两字符的「最长公共子序列」，若两者长度分别为 nnn 和 mmm，而最长公共子序列长度为 maxmaxmax，则 n−max+m−maxn - max + m - maxn−max+m−max 即为答案
     *
     * @param word1
     * @param word2
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/delete-operation-for-two-strings/solutions/1016018/gong-shui-san-xie-cong-liang-chong-xu-li-wqv7/",
            questionNumber = "583",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int minDistance(String word1, String word2) {
        /**
         * dp[i][j]表示word1[0..i]到words[0...j]的最小步数
         */
        char[] cs1 = word1.toCharArray(), cs2 = word2.toCharArray();
        int n = word1.length(), m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        // 假定存在哨兵空格，初始化 f[0][x] 和 f[x][0]
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j <= m; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (cs1[i - 1] == cs2[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        int max = f[n][m] - 1; // 减去哨兵空格
        return n - max + m - max;
    }


    /**
     * 定义 f[i][j] 代表考虑 s1 的前 i 个字符、考虑 s2 的前 j 个字符（最终字符串不一定包含 s1[i] 或 s2[j]）时形成相同字符串的最小删除次数
     *
     * s1[i]==s2[j]: f[i][j]=f[i−1][j−1]，代表可以不用必然删掉 s1[i] 和 s2[j] 形成相同字符串;
     * s1[i]!=s2[j]: f[i][j]=min(f[i−1][j]+1,f[i][j−1]+1)，代表至少一个删除 s1[i] 和 s2[j] 中的其中一个
     *
     * @param word1
     * @param word2
     * @return
     */
    public int anotherWay(String word1, String word2){
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (cs1[i - 1] == cs2[j - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }
            }
        }
        return f[n][m];
    }

}
