package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
 *
 * 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
 *
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *
 * @author shadow
 * @create 2023-05-28 17:00
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "727",
        questionTitle = "最小窗口子序列",
        relevateClass = {MinimumWindowSubstring.class},
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/minimum-window-subsequence/description/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        timeComplexity = TimeComplexity.O_N
)
public class MinimumWindowSubsequence {

    /**
     * 1.什么是子序列：即按照T中顺序出现，且包含所有字符的字符串
     * 2.需要最短且左窗口最靠左
     * @param S
     * @param T
     * @return
     */
    @MethodTag(
            questionNumber = "727",
            methodLink = "https://leetcode.cn/problems/minimum-window-subsequence/solutions/143339/zui-xiao-chuang-kou-zi-xu-lie-by-leetcode/",
            timeComplexity = TimeComplexity.O_NK,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public String minWindow(String S, String T) {
        int N = S.length();
        int[] last = new int[26];
        int[][] next = new int[N][26];
        Arrays.fill(last, -1);

        for (int i = N - 1; i >= 0; --i) {
            last[S.charAt(i) - 'a'] = i;
            for (int k = 0; k < 26; ++k) {
                next[i][k] = last[k];
            }
        }

        List<int[]> windows = new ArrayList();
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == T.charAt(0))
                windows.add(new int[]{i, i});
        }
        for (int j = 1; j < T.length(); ++j) {
            int letterIndex = T.charAt(j) - 'a';
            for (int[] window: windows) {
                if (window[1] < N-1 && next[window[1]+1][letterIndex] >= 0) {
                    window[1] = next[window[1]+1][letterIndex];
                }
                else {
                    window[0] = window[1] = -1;
                    break;
                }
            }
        }

        int[] ans = {-1, S.length()};
        for (int[] window: windows) {
            if (window[0] == -1) break;
            if (window[1] - window[0] < ans[1] - ans[0]) {
                ans = window;
            }

        }
        return ans[0] >= 0 ? S.substring(ans[0], ans[1] + 1) : "";
    }

    @MethodTag(
            questionNumber = "727",
            methodLink = "https://leetcode.cn/problems/minimum-window-subsequence/discussion/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public String minWindowAnotherway(String S, String T){
        int[][] dp = new int[2][S.length()];

        for (int i = 0; i < S.length(); ++i) {
            dp[0][i] = S.charAt(i) == T.charAt(0) ? i : -1;
        }

        /*At time j when considering T[:j+1],
          the smallest window [s, e] where S[e] == T[j]
          is represented by dp[j & 1][e] = s, and the
          previous information of the smallest window
          [s, e] where S[e] == T[j-1] is stored as
          dp[~j & 1][e] = s.
        */
        for (int j = 1; j < T.length(); ++j) {
            int last = -1;
            Arrays.fill(dp[j & 1], -1);
            //Now we would like to calculate the candidate windows
            //"dp[j & 1]" for T[:j+1].  'last' is the last window seen.
            for (int i = 0; i < S.length(); ++i) {
                if (last >= 0 && S.charAt(i) == T.charAt(j)) {
                    dp[j & 1][i] = last;
                }
                if (dp[~j & 1][i] >= 0) {
                    last = dp[~j & 1][i];
                }
            }
        }

        //Looking at the window data dp[~T.length & 1],
        //choose the smallest length window [s, e].
        int start = 0, end = S.length();
        for (int e = 0; e < S.length(); ++e) {
            int s = dp[~T.length() & 1][e];
            if (s >= 0 && e - s < end - start) {
                start = s;
                end = e;
            }
        }
        return end < S.length() ? S.substring(start, end+1) : "";
    }

}
