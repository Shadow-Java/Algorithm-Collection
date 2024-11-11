package algorithm.collection.leetcode.october.fourtweek.weekly_match;

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
public class PossibleStringCount {


    /**
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
