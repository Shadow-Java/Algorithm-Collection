package algorithm.collection.leetcode.dynamicprogramming.linear;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.MaximumSubarray;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author shadow
 * @create 2023-07-09 01:51
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "198",
        questionTitle = "打家劫舍",
        relevateClass = MaximumSubarray.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/house-robber/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class HouseRobber {

    /**
     * 返回的最大利益
     * @param nums   数组入参
     * @return       打劫的最大利益
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/delete-and-earn/",
            questionNumber = "198",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public static int rob(int[] nums) {
        int len = nums.length;
        //[0,i]为直线房屋打劫的最大利益dp[i]
        int[] dp = new int[len];
        //因为打劫了i房屋，不能打劫i-1房屋，所以起始值为2，那么就需要定义初始值dp[0]和dp[1]
        dp[0] = nums[0];
        if (len == 1) {
            return dp[0];
        }
        //因为0和1是相邻的，只能打劫一个
        dp[1] = Math.max(nums[1], nums[0]);
        if (len == 2) {
            return dp[1];
        }
        /**
         * 一个直线的房屋如果打劫了i房屋，就不能打劫i-1和i+1房屋<br/>
         * 如果打劫了i房屋，那么当前的dp[i]=dp[i-2]+nums[i]<br/>
         * 如果不打劫，则当前的dp[i]=dp[i-1]<br/>
         */
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int max = dp[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //空间查询优化，提前保存搜索树
    private int[] cache;
    public int robV3(int[] nums) {
        //dp[i] = max(dp[i-1],dp[i-2]+nums[i]);
        int[] f = new int[nums.length+2];
        f[0] = 0;
        f[1] =0;
        for(int i =0;i<nums.length;i++) {
            f[i+2]= Math.max(f[i+1],f[i]+nums[i]);
        }
        return f[nums.length+1];
    }

    public int dfs(int[] nums,int i) {
        if(i < 0) {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        int previous = Math.max(dfs(nums,i-1),dfs(nums,i-2)+nums[i]);
        cache[i] = previous;
        return previous;
    }

    /**
     * 空间优化的基本原理是，很多时候我们并不需要始终持有全部的 DP 数组。对于小偷问题，我们发现最后计算f(n)的时候，实际上只用到了f(n-1)和f(n-2)的结果
     * n-3之前的子问题
     * @param nums
     * @return
     */
    public int robAnotherWay(int[] nums) {
        //空间复杂度从O(n)降到了O(1)
        int prev = 0;
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

}
