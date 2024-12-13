package algorithm.collection.leetcode.november.thirdweek.november_18st;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 * @author shadow
 * @create 2024-11-24 21:31
 **/
public class LongestPalindromeSubseq {

    /**
     * 1.区间DP：
     *      ①区别：
     *          ·线性DP：一般是在前缀/后缀上转移
     *          ·区间DP：从小区间转移到大区间
     *      ②选或者不选
     *          ·从两侧向内缩小问题规模
     *          ·516最长回文子序列
     *      ③枚举选哪个
     *          ·分割成多个规模更小的子问题
     *          ·1039多边形三角剖分的最低得分
     * 2.思路一：求s和反转后s的LCS（最长公共子序列）
     * 3.思路二：[选或者不选]从两侧向内缩小问题规模
     *                       eacbba
     *              (不选e)/        \ (不选a)
     *                acbba         eacbb
     *                 /(两侧a都选)   /    \
     *               cbb           acbb    eacb
     *              /   \          /   \    /   \
     *            bb     cb      cbb   acb acb   eac
     *                  /  \
     *                 b    c
     * 4.为什么从两端向内枚举是正确的？当s[i]==s[j]的时候需要证明dfs(i+1,j-1)是个回文串吗？不需要，因为只要求子序列，保持前后一样就行。因为子序列不是连续的，是相对顺序不变
     * 5.状态转移方程：
     *      ①定义dfs(i,j)表示从s[i]到s[j]的最长回文子序列的长度
     *      ②dfs(i,j) = dfs(i+1,j-1)+2                     s[i]=s[j]
     *      ③dfs(i,j) = max(dfs(i+1,j),dfs(i,j-1))         s[i]!=s[j]   要么不选i，要么不选j
     * 6.递归边界
     *      ①dfs(i,i) =1     一个字母是一个回文
     *      ②dfs(i+1,i)=0
     *      比如遇到bb时，会从dfsdfs(i,i+1)递归到dfs(i+1,i)
       *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        return dfs(s,0,s.length()-1);
    }

    /**
     * 时间复杂度：
     * 状态个数看是一维数组还是二维数组 * 每个状态的处理时间
     * 状态有O(N^2)个，每个状态只需要O(1)的计算；因为是二维数组，所以是O(N^2)
     * @param s
     * @param i
     * @param j
     * @return
     */
    public int dfs(String s,int i,int j) {
        if(i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dfs(s,i+1,j-1)+2;
        }
        return Math.max(dfs(s,i+1,j),dfs(s,i,j-1));
    }

    /**
     * 记忆化搜索，将memo内存数组初始值为-1，表示没有计算过
     * @param i
     * @param j
     * @param s
     * @param memo
     * @return
     */
    private int dfs(int i, int j, char[] s, int[][] memo) {
        if (i > j) {
            return 0; // 空串
        }
        if (i == j) {
            return 1; // 只有一个字母
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        if (s[i] == s[j]) {
            return memo[i][j] = dfs(i + 1, j - 1, s, memo) + 2; // 都选
        }
        return memo[i][j] = Math.max(dfs(i + 1, j, s, memo), dfs(i, j - 1, s, memo)); // 枚举哪个不选
    }


    /**
     * 1:1翻译为递推
     * 1.方程式
     *      a.f[i][j]  = 0              i>j
     *      b.f[i][j]  = 1              i=j
     *      c.f[i+1][j-1]  = 2          s[i]=s[j]
     *      d.max(f[i+1][j],f[i][j-1])  s[i] =/= s[j]
     * 2.循环顺序
     *      a.f[i]从f[i+1]转移过来，所以i要倒序枚举
     *      b.f[i][j]从f[i][j-1]转移过来，所以j要正序枚举
     * 3.答案是f[0][n-1]
     * @param S
     * @return
     */
    public int longestPalindromeSubseqV2(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if(s[i] == s[j]) {
                    f[i][j] =f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    /**
     * 空间优化：
     * 把 f 数组的第一个维度去掉。相当于把 f[i] 和 f[i+1] 保存到同一个一维数组中。
     *
     * 但一个萝卜一个坑，f[j−1] 要么保存的是 f[i+1][j−1]，要么保存的是 f[i][j−1]，怎么妥当地处理新旧数据？对于本题来说，可以用变量 pre 记录 f[i+1][j−1] 的值。计算到 f[j] 时，f[j−1] 保存的是新数据 f[i][j−1]，旧数据 f[i+1][j−1] 可以从 pre 中取到。
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseqV3(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            f[i] = 1;
            int pre = 0; // 初始值为 f[i+1][i]
            for (int j = i + 1; j < n; j++) {
                int tmp = f[j];
                f[j] = S[i] == S[j] ? pre + 2 : Math.max(f[j], f[j - 1]);
                pre = tmp;
            }
        }
        return f[n - 1];
    }

}
