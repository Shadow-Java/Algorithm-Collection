package algorithm.collection.leetcode.november.secondweek.november_17st;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 *
 * 70. 爬楼梯
 * 746. 使用最小花费爬楼梯
 * 377. 组合总和 Ⅳ 本质是爬楼梯，相当于每次往上爬
 * nums
 * [
 * 𝑖
 * ]
 * nums[i] 步
 * 2466. 统计构造好字符串的方案数 1694
 * 2266. 统计打字方案数 1857
 * 2533. 好二进制字符串的数量（会员题）同 2466 题
 *
 *
 * @author shadow
 * @create 2024-11-18 20:30
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "70",
        questionTitle = "70. 爬楼梯",
        relevateClass = Rob.class,
        timeComplexity = TimeComplexity.O_N,
        algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class ClimbStairs {

    private int ans = 0;

    public static void main(String[] args) {
        int n = 4;
        ClimbStairs cl = new ClimbStairs();
        System.out.println(cl.climbStairs(n));
    }
    public int climbStairs(int n) {
        dfs(n,0,n);
        return ans;
    }

    public void dfs(int n,int path,int remain) {
        if(path == n) {
            ans++;
            return;
        }
        //当前有两种情况可以选，可以选1 也可以选2
        for (int i=1;i<=2;i++) {
            //当剩余的台阶数小于当前可选的台阶，那么就可以选
            if(remain >= i) {
                path += i;//选择后将路径加上相应的台阶数
                dfs(n,path,remain-i);
                path -= i;
            }
        }
    }

    /**
     *         int[] memo = new int[n+1];
     *         Arrays.fill(memo,-1);
     *     public int dfs(int i) {
     *         if(i < 0) {
     *             return 0;
     *         }
     *         if(i == 0) {
     *             memo[i] = 1;
     *             return 1;
     *         }
     *         if(memo[i] != -1) {
     *             return memo[i];
     *         }
     *         return memo[i] = dfs(i-1)+dfs(i-2);
     *     }
     * @param i
     * @return
     */
    public int dfs(int i) {
        if(i <=1) {//递归边界
            return 1;
        }
        return dfs(i-1)+dfs(i-2);
    }

    /**
     * 这题和打家劫舍的不同点：
     *    1、打家劫舍的dp为金额，每抢一个家累计一个金额，所以比较好思考
     *    2、爬楼梯的N则跟打家劫舍的总金额是一样的，每次可选择跳一步或者两步，然后累计到N；
     *    3、打家劫舍的dp[i],其中i为第i家，dp[i]为选择第i家后的总金额；而该题的dp[i]中i为累计到了第i步，dp[i]为到第i步的方案数
     * 方程定义：从0爬到i，定义dfs(i)表示从0爬到i有多少不同的方法
     * 如果最后一步爬了1个台阶，那得先爬到i-1个台阶，那么问题缩小为0到i-1有多少种不同的方法
     *
     * 本题是从 n 开始递归，i 最小是 0，所以翻译之后 f 数组的长度是 n+1。打家劫舍是从 n-1 开始递归，i 最小是 -2，所以翻译之后 f 数组的长度是 n+2。
     * @param n
     * @return
     */
    public int climbStairsV2(int n) {
        int[] f = new int[n+1];
        f[0] = 1;//一定要自己举例才知道起始值为多少 比如f[2] = f[0]+f[1]
        f[1] = 1;
        //一定要明确枚举的对象和dp数组的含义，为了防止数组越界从2开始
        for (int i = 2; i <= n; i++) {
            //f[i-1]表示选择了走一步的情况下的总方案数，i-1
            //f[i-2]表示选择了走二步的情况下的总方案数
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }

    public int climbStairsV3(int n) {
        int f0 = 1;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            int newF = f1 + f0;
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

}
