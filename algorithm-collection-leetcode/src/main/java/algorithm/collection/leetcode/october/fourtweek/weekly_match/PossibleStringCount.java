package algorithm.collection.leetcode.october.fourtweek.weekly_match;

/**
 * @author shadow
 * @create 2024-10-30 00:29
 **/
public class PossibleStringCount {


    /**
     * 3330. 找到初始输入字符串 I
     * 计算可能的字符串数量，在至多失误一次的情况下，如果多个字段重复，只能重复其中的一个字符 java
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
