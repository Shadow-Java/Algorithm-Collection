package SourceCode.src;

import java.util.Arrays;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串
 *
 *
 *
 * 题解：
 * 一、先定义一个二维数组，我们定义 设 g(i, j)表示 s[i..j]是否为回文串，那么g[0][1]表示s[0]-s[1]为回文子串，即true
 * 二、其次，设状态变量f[i]表示字符串的前缀s[0..i] 的最少分割次数，那么f[1] 表示s[0..1]的最小分割回文次数，f[n]表示s[0..n]的最小回文分割次数
 * 三、状态方程：g[i][j] = true,i >= j; g[i][j] = g[i+1][j-1] and s[i]=s[j],i < j;
 * 四、解释：正常情况下，i <= j,i=j 表明 下标相等，长度为1，肯定是回文子串，即true；当i < j时，如果g[i][j] 为回文，那么递归为g[i+1][j-1] and s[i]=s[j]为回文。
 */
public class PalindromePartitioningII {
    /**
     * 求的是最小分割次数
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        //将所有情况设置初始值
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }
        //i < j时的情况，通过s[i] == s[j]来赋值
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        //状态量
        int[] f = new int[n];
        //因为要比较最小，所以将初始值设置为最大
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {//s[0..i]为回文串则最小分割数为1
                f[i] = 0;
            } else {//该s[0..i]不是回文串，遍历子串是否回文，是则比较最小值
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

}
