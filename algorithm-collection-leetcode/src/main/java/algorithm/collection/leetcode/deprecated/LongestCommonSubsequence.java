package algorithm.collection.leetcode.deprecated;

public class LongestCommonSubsequence {
    /**
     * 求两个数组或者字符串的最长公共子序列问题，肯定是要用动态规划的。下面的题解并不难，你肯定能看懂。
     *
     * 首先，区分两个概念：子序列可以是不连续的；子数组（子字符串）需要是连续的；
     * 另外，动态规划也是有套路的：单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j] ，其含义是在 A[0:i] 与 B[0:j] 之间匹配得到的想要的结果。
     *
     * 定义是dp[i][j]是text[0..i-1] text2[0..j-1]的最长子串
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
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
