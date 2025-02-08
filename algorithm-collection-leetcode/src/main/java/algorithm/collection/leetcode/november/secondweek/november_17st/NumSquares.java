package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * @author shadow
 * @create 2024-11-19 02:57
 **/
public class NumSquares {
    private static final int N = 10000;
    private static final int[] f = new int[N + 1];

    public int numSquares(int n) {
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i * i <= N; i++) {
            for (int j = i * i; j <= N; j++) {
                f[j] = Math.min(f[j], f[j - i * i] + 1); // 不选 vs 选
            }
        }
        return f[n];
    }

    int res;
    public int numSquaresV2(int n) {
        res = Integer.MAX_VALUE;
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            squares.add(i*i);
        }
        dp(n,squares,0,new ArrayList<>());
        return res;
    }

    private void dp(int n,List<Integer> squares,int path,List<Integer> onPath) {
        if(path == n) {
            res = Math.min(onPath.size(),res);
            System.out.println(onPath);
            return;
        }
        //每种场景下有squares种情况可以选，在path + item <= n才可以选择，即剪枝
        for (Integer item : squares) {
            if(path + item <= n) {
                path += item;
                onPath.add(item);
                dp(n,squares,path,onPath);
                path -= item;
                onPath.remove(onPath.size()-1);
            }
        }
    }

}
