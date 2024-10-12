package algorithm.collection.leetcode.dynamicprogramming;

public class DistinctSubsequences {

    /**
     * 1.初始化：
     *    dp[i][0] 应该初始化为 1，因为一个空串是任何字符串的子序列。
     *    dp[0][j] 应该初始化为 0，因为一个非空串不可能是空串的子序列。
     * 2.状态转移方程：
     *    如果 s[i-1] == t[j-1]，那么有两种情况：
     *      s 的第 i 个字符可以匹配 t 的第 j 个字符，此时 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。
     *      s 的第 i 个字符不匹配 t 的第 j 个字符，此时 dp[i][j] = dp[i-1][j]。
     *    如果 s[i-1] != t[j-1]，那么 dp[i][j] = dp[i-1][j]。
     * 3.最终答案：
     *    dp[s.length()][t.length()] 即为最终的答案。
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        //技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始
        //同时由于往头部插入相同的（不存在的）字符，不会对结果造成影响，而且可以使得f[i][0]=1，可以将1这个结果滚动下去
        int n = s.length(), m = t.length();
        s = "" +s;
        t = "" +t;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        //f(i,j)代表考虑「s中的下标为0~i字符」和「t中下标为0~j字符」是否匹配
        int[][] f = new int[n + 1][m + 1];
        //原字符只有小写字符，当往两个字符插入空格之后，f[i][0]=1是一个显而易见的初始化条件
        for (int i=0; i<=n; i++) f[i][0] = 1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                //包含两种决策：
                //不使用cs[i]进行匹配，则有f[i][j]=f[i-1][j]
                f[i][j] = f[i-1][j];
                //使用cs[i]进行匹配，则要求cs[i]==ct[j]，然后有f[i][j]+=f[i-1][j-1]
                if (cs[i] == ct[j]) {
                    f[i][j] += f[i-1][j-1];
                }
            }
        }
        return f[n][m];
    }

}
