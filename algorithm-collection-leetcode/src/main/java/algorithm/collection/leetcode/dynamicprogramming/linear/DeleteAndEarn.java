package algorithm.collection.leetcode.dynamicprogramming.linear;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * @author shadow
 * @create 2023-07-09 01:34
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "740",
        questionTitle = "删除并获得点数",
        relevateClass = HouseRobber.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/delete-and-earn/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DeleteAndEarn {

    /**
     * 打家劫舍问题：即强盗选择一条线上的i房屋进行打劫，但要求不能打劫相邻的房屋(i+1和i-1),那么需要讨论出最优的打劫方案，使其打劫的收益最大<br/>
     * nums = [2, 2, 3, 3, 3, 4]                                <br/>
     * all=[0, 0, 2, 3, 1]  表示2出现2两次，3出现3次，4出现4次       <br/>
     * 对数组中的数字进行打家劫舍，对于每个当前值分为打劫和不打劫          <br/>
     * dp[i] = max(dp[i-1],all[i]*i+dp[i-2])                    <br/>
     * 相当于对数组进行排序，全都排成连续的数字数组，对出现次数进行打家劫舍  <br/>
     *
     * @param nums
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/delete-and-earn/",
            questionNumber = "740",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public static int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Integer.max(max, num);
        }
        int[] counter = new int[max + 1];
        for (int num : nums) {
            ++counter[num];
        }
        int[] dp = new int[max + 3];
        for (int i = max; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + counter[i] * i);
        }
        return dp[0];
    }

    public int deleteAndEarnAnotherWay(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        //构造一个新的数组all 记录数字出现的次数
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        // 动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }

}
