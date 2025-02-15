package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author shadow
 * @create 2024-11-19 01:35
 **/
public class Rob {

    /**
     * 枚举第i个房子选或者不选：dfs(i) = max(dfs(i-1),dfs(i-2)+nums[i])
     * dfs(i)表示在前[0,i-1]已经处理的情况下，是否选择第i个；
     * 不选：从前i-1个房子中得到的最大金额和
     * 选：从前i-2个房子中得到的最大金额和
     * 在定义dfs或者dp时，它只能从一些元素中算出的结果，而不能从一个元素中算出的结果
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; i++) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }

    /**
     * 使用回溯,最终结果就是dfs(n-1)
     * 动态规划能够构建一课搜索树(再根据搜索树优化成dp)：
     *                                 4
     *                    （不选）  /        \ （选）
     *                            3          2
     *                           /  \       / \
     *                          2    1     1   0
     *                         / \  /     /
     *                        1   0 0    0
     *                       /
     *                      0
     *  以2为顶点的树在两次计算的过程中是一样的，所以在第一次计算的时候存储在hash表中
     *
     * @param i
     * @return
     */
    public int dfs(int[] nums,int i) {
        if(i < 0) {
            return 0;
        }
        return Math.max(dfs(nums,i-1),dfs(nums,i-2)+nums[i]);
    }


    /**
     * 优化后的搜索树
     *                                 4
     *                    （不选）  /        \ （选）
     *                            3          2
     *                           /  \
     *                          2    1
     *                         / \
     *                        1   0
     *                       /
     *                      0
     *  以2为顶点的树在两次计算的过程中是一样的，所以在第一次计算的时候存储在hash表中
     *  优化后的搜索树只有N个节点，所以时间复杂度也优化到了O(N);
     *  递归搜索+保存计算结果=记忆化搜索
     *
     *  时间复杂度如何计算：状态个数*单个状态所需要的时间，状态个数为N，单个状态时间为O(1)
     *
     * @param i
     * @return
     */
    public int dfsV2(int[] nums,int i) {
        if(i < 0) {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        int res = Math.max(dfs(nums,i-1),dfs(nums,i-2)+nums[i]);
        cache[i] = res;
        return res;
    }
    public static int[] cache = new int[10];
    static {
        Arrays.fill(cache,-1);
    }


    /**
     * 优化空间复杂度：
     * 按照上面的搜索树，是从上往下递，从下往上归；那么去掉递的过程，直接用归，直接从下面往上计算；
     * 自顶向下计算=记忆化搜索
     * 自底向上算=递推
     *
     * 1：1翻译递推
     *    1、dfs -> f数组
     *    2、递归 ->循环
     *    3、递归边界 ->数组初始值
     * dfs(i) = max(dfs(i-1),dfs(i-2)+nums[i])
     * f[i] = max(f[i-1],f[i-2]+nums[i])
     * f[i+2] = max(f[i+1],f[i]+nums[i])  (防止下标越界，直接对公式加2；或者对f[0]或f[1]特殊处理下)
     * @param nums
     * @return
     */
    public int robV2(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; i++) {
            //将表达式自增2，这样i在nums数组时不会越界，代表的含义也是正确的
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }

    public int robV4(int[] nums) {
        //要清楚的知道f代表的含义，是枚举1-n个房间的偷盗的最大价值和
        //最终要求的是f[n],其中f[i]对应的是nums[i-1]
        int[] f = new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        return f[nums.length];
    }

    /**
     * 看f[i] = max(f[i-1],f[i-2]+nums[i])式子得知，需要三个值，f[i]、f[i-1]、f[i-2]
     * 计算一个f[i]只需要知道上一个和上上一个的值；
     * 设f0表示上上一个，f1表示上一个，newF表示当前要计算的
     * newF=max(f1,f0+nums[i])
     * f0 = f1
     * f1=newF
     * @param nums
     * @return
     */
    public int robV3(int[] nums) {
        int n = nums.length;
        int f0=0,f1=0;

        int[] f = new int[n + 2];
        for (int i = 0; i < n; i++) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0=f1;
            f1=newF;
        }
        //f1是最后一次算出的newF
        return f1;
    }

}
