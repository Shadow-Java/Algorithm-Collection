package algorithm.collection.leetcode.november.secondweek.november_11st;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 用选或者不选的思路更好写
 * @author shadow
 * @create 2024-11-11 23:01
 **/
public class GenerateParenthesis {

    /**
     * 前k个括号中，左括号一定大于等于右括号的数量；右括号的个数不能超过左括号的个数，当左右括号相等时，只能选左括号
     * 左右括号的个数都必须等于n;
     * 可以看成从2n个位置中选n个位置放左括号，其余位置放右括号；第i个位置选他放左括号，不选则右括号；
     * 要画出一课搜索树，当n=3的时候，左括号的个数不能超过3，所以一旦等于3了，其他就是选右括号了；当左右括号相等的时候，就只能选左括号了
     *
     * 需要选n个左括号，只要open<n就可以选左括号；右括号的个数为i-open;如果右括号的个数小于左括号的个数，则i-open < open则可以选右括号
     *
     *               dfs(i+1,open+1) 选左括号
     *            /
     * dfs(i,open)
     *           \
     *              dfs(i+1,open)   选右括号
     *
     * 时间复杂度：O(N*C(2N,N))
     *
     * 了解下卡特兰数
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2]; // 所有括号长度都是一样的 n*2
        dfs(0, 0);//从0，0出发开始递归
        return ans;
    }

    private int n;
    private final List<String> ans = new ArrayList<>();
    private char[] path;

    // i = 目前填了多少个括号
    //第i个位置，即在当前i时，左右括号数和为i
    // open = 左括号个数，i-open = 右括号个数
    private void dfs(int i, int open) {
        if (i == n * 2) { // 括号构造完毕
            ans.add(new String(path)); // 加入答案
            return;
        }
        if (open < n) { // 左括号的个数小于n，可以填左括号
            path[i] = '('; // 直接覆盖
            dfs(i + 1, open + 1); // 多了一个左括号
        }
        if (i - open < open) { // 右括号的个数小于左括号的个数可以填右括号
            path[i] = ')'; // 直接覆盖
            dfs(i + 1, open);
        }
    }

}
