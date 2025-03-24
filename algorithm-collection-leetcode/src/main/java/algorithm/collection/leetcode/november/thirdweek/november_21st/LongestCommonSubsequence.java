package algorithm.collection.leetcode.november.thirdweek.november_21st;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * @author shadow
 * @create 2024-11-21 23:59
 **/
public class LongestCommonSubsequence {

    /**
     * 子数组和子串是连续的，而子序列不是连续的，但有相对顺序
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }
        return dfs(n - 1, m - 1, text1, text2);
    }

    public int[][] memo;

    /**
     * 求的是i长度的字符串和j长度的字符串的公共子序列的长度
     * @param i       当临界值到达0 的时候，此时公共子序列的长度为0
     * @param j       当临界值到达0 的时候，此时公共子序列的长度为0
     * @param text1
     * @param text2
     * @return
     */
    public int dfs(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) {
            //代表两个长度为0的字符串的最长公共子序列的长度为0
            return 0;
        }
        if(memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {//求的是两个字符的公共子序列，即只有相同时才
            return memo[i][j] = dfs(i - 1, j - 1, text1, text2) + 1;
        }
        return memo[i][j] = Math.max(dfs(i - 1, j, text1, text2), dfs(i, j - 1, text1, text2));
    }

}
