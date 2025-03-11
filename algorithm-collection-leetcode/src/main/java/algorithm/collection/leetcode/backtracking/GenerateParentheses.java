package algorithm.collection.leetcode.backtracking;

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
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * @author shadow
 * @create 2023-05-18 00:25
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "22",
        questionTitle = "括号生成",
        desc = "数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合",
        questionLink = "https://leetcode.cn/problems/generate-parentheses/",
        algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP}
)
public class GenerateParentheses {

    /**
     * 动态规划  F(n+1)=(+F(i)+)+F(n-i)
     * 从f(1),f(2),...,f(n-1)构建出f(n)
     *
     * 分析一个解的构成：必然从左括号开始，而这个开始的左括号必然对应着一个一个右括号，
     *     因此，任何一个解可以表示为 (A)B。
     * 令f(n) = (A)B  其中A和B是规模更小时问题的合法解，并且A、B可以为空，
     * 并且A中括号对数+B中括号对数之和为n-1
     *
     * 也就是说，可以从f(0),f(1),f(2),...,f(n-1构建出f(n),其中f0 = ""表示空解。
     */
    @MethodTag(
            questionNumber = "22",
            methodLink = "https://leetcode.cn/problems/generate-parentheses/",
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n+1];
        dp[0] = Arrays.asList("");

        for (int p = 1; p <= n; p++) {
            dp[p] = new ArrayList<>();
            for (int q = 0; q < p; q++) {
                for (String a : dp[q]) {
                    for (String b : dp[p-q-1]) {
                        dp[p].add("("+a+")"+b);
                    }
                }
            }
        }
        return dp[n];
    }


    @MethodTag(
            questionNumber = "22",
            methodLink = "https://leetcode.cn/problems/generate-parentheses/solutions/35947/hui-su-suan-fa-by-liweiwei1419/",
            dataStructType = DataStructType.SYSTEM_STACK,
            algorithmCategory = AlgorithmCategory.BACK_TRACKING
    )
    public List<String> generateParenthesisAnotherWay(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        StringBuilder path = new StringBuilder();
        dfs(path, n, n, res);
        return res;
    }

    /**
     * @param path  从根结点到任意结点的路径，全程只使用一份
     * @param left  左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param res
     */
    private void dfs(StringBuilder path, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
            res.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
