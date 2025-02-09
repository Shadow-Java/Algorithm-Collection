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
        //f代表的是背包容量，那么其实是在穷举在（1、4、9、16）这么多种情况下每种背包的容量，一直穷举到背包容量为n时的物品数
        //为什么会用到之前的fi,因为对于每个fi都有（1、4、9、16）这么多种情况，当fi选择了某种情况（1或4或9），那么就能递归到f(i-4);这时候只需要求f(i-4)即可
        //而f(i-4)在从0-i-4的时候已经遍历过，所以可以直接得出结果
        for (int i = 1; i * i <= N; i++) {//所有的平方数
            for (int j = i * i; j <= N; j++) {//背包容量，如果在选择i*i的情况下，背包容量至少得从i*i开始
                //选择i*i物品  或  不选择i*i
                //选择i*i的话，那需要在f[j - i * i]方案上加1
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
        dfs(n,squares,0,new ArrayList<>());
        return res;
    }

    /**
     * 也可以类比于零钱兑换或者0-1背包，即给一个容量为n的背包，里面可以装多少的物品（1，4，9）
     * 方法一：使用dfs(i)表达的含义和dp(i)一样，穷举的是背包容量，那么dfs(i)的方式和上面这种背包记忆的方式一样，如果是dfs(i)的话那么需要有个记忆数组将存下来
     * 方法二：直接用dfs，深度优先搜索。穷举所有情况，通过visited做拦截
     * @param n
     * @param squares
     * @param path
     * @param onPath
     */
    private void dfs(int n,List<Integer> squares,int path,List<Integer> onPath) {
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
                dfs(n,squares,path,onPath);
                path -= item;
                onPath.remove(onPath.size()-1);
            }
        }
    }

}
