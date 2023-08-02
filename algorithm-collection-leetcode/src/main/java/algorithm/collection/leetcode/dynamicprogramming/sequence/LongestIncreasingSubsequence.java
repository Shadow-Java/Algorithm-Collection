package algorithm.collection.leetcode.dynamicprogramming.sequence;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.linear.HouseRobber;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 *
 */
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "300",
        questionTitle = "最长递增子序列",
        relevateClass = HouseRobber.class,
        desc = "给你一个整数数组 nums ，找到其中最长严格递增子序列的长度",
        questionLink = "https://leetcode.cn/problems/longest-increasing-subsequence/",
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
class LongestIncreasingSubsequence {
    //其实dp[i]代表着记录，我们假设已经求出了前i的最大上升子序列，那么我将前i的长度记录在dp[i]上
    //比如第一个字母的上升子序列我记录在dp[0]上，第0个字母和第一个字母的最长上升子序列我记录在dp[1]上
    //依次类推我可以将前i个子序列记录在dp[i]上，那么最后的dp[i]就是我们需要的最长上升子序列
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/",
            questionNumber = "300",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            //代表着每个序列都至少有一个上升子序列
            for(int j = 0;j < i ;j++){
                //其实这里假设nums[i]为dp[j]的严格递增单元数
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);//最后一轮的dp[i]不一定是最大的，所以最后需要对整个dp求最大
        }
        return res;
    }

    /**
     * 子序列的问题->动态规划。
     *
     * 使用数组 cell 保存当前的最长递增子序列。
     * cell[i] 代表含第 i 个元素的最长上升子序列的长度。
     * 求解 cell[i] 时，向前遍历找出比 i 元素小的元素 j，令 cell[i] 为 max（cell[i],cell[j]+1)。
     *
     * 假设我有个数组1，5，10，2，3，4
     * 维护一个tail数组，用来记录递增数据
     * 遍历nums[i],遇到递增的情况就直接记录到tail中，当遍历到2时，此时tail为1，5，10，
     * 并且此时发现不再递增了，这时候就要将2替换掉tail中比2大的那个数，也就是5,此时的tail就算1，2，10
     * 也许此时看来这个tail中记录的顺序是错的，但这就是贪心算法：先预知未来的情况，也许此刻看来是错的，但未来的某一刻就是对的了，
     * 不过也可能未来永远都不会有对的那一刻，那么最后也可以撤回此刻的决定或者说也不会影响题中所要求的数据
     * 例如此题，如果后面有比5小，比2大的数（递增数列更长）的时候（例如此题的3），此刻选择2和选择5对结果无影响：选择2是1，2，3，而选择5，则是1，5，10，长度都是3。但如果在3后面还有比2大比5小的数，那就赚了（例如此题的4），选择2是1，2，3，4，而选择5是1，5，10
     *
     * @param nums
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/",
            questionNumber = "300",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public static int lengthOfLISAnotherway(int[] nums) {
        //tail保存当前的最长递增子序列
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            //因为tail存的是递增子序列，那么j表示长度
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            //找到比num大的数的位置，然后替换掉
            tails[i] = num;
            if(res == j) {
                res++;
            }
        }
        return res;
    }
}