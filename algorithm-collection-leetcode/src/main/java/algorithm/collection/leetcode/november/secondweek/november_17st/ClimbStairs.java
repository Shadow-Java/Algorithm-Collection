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
        for (int i=1;i<=2;i++) {
            if(remain >= i) {
                path += i;
                dfs(n,path,remain-i);
                path -= i;
            }
        }
    }

    public int dfs(int i) {
        if(i <=1) {//递归边界
            return 1;
        }
        return dfs(i-1)+dfs(i-2);
    }

    /**
     * 方程定义：从0爬到i，定义dfs(i)表示从0爬到i有多少不同的方法
     * 如果最后一步爬了1个台阶，那得先爬到i-1个台阶，那么问题缩小为0到i-1有多少种不同的方法
     *
     * 本题是从 n 开始递归，i 最小是 0，所以翻译之后 f 数组的长度是 n+1。打家劫舍是从 n-1 开始递归，i 最小是 -2，所以翻译之后 f 数组的长度是 n+2。
     * @param n
     * @return
     */
    public int climbStairsV2(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        //一定要明确枚举的对象和dp数组的含义，为了防止数组越界从2开始
        for (int i = 2; i <= n; i++) {
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
