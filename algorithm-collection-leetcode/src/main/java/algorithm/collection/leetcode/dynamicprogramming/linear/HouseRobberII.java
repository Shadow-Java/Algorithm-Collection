package algorithm.collection.leetcode.dynamicprogramming.linear;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.MaximumSubarray;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 * @author shadow
 * @create 2023-07-09 03:39
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "213",
        questionTitle = "打家劫舍 II",
        relevateClass = HouseRobber.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/house-robber-ii/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class HouseRobberII {

    /**
     * 因为是个环形排列，第一个房子和最后一个房子只能选择一个偷窃，那么可以分成两个直线排列的数组<br/>
     * 第一个房屋不偷窃，即num[0]跳过，计算[1,nums.length-1]的最大值P1 <br/>
     * 最后一个房屋不偷窃，即nums[nums.length-1]跳过，计算[0,nums.length-2]的最大值P2  <br/>
     * 计算Math.max(P1,P2)
     *
     * 那么第一个房屋不偷窃，那么最后一个房屋可能偷窃可能不偷窃，但是偷窃的最大利益肯定大于不偷窃，即f(n1,n2,n3) <= f(n1,n2,n3,n4)；
     * 在这种情况下第一个房屋不偷窃，最后一个房屋不偷窃的情况就能被忽略，因为肯定是有最后一个房屋的收益大
     * @param nums
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/house-robber-ii/solution/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/",
            questionNumber = "213",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //对于第一个房间来说，存在偷与不偷的情况，如果偷，则最后一家一定不能偷，将其置为0即可，以此数组为基准运行198题的代码得到一个结果。
        // 如果不偷，那么把第一家置为0，最后一家无所谓，运行198题代码，又得到一个结果。返回两个结果较大的一个即可。
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 分类讨论，考虑是否偷 nums[0]：
     *
     * 如果偷 nums[0]，那么 nums[1] 和 nums[n−1] 不能偷，问题变成从 nums[2] 到 nums[n−2] 的非环形版本，调用 198 题的代码解决；
     * 如果不偷 nums[0]，那么问题变成从 nums[1] 到 nums[n−1] 的非环形版本，同样调用 198 题的代码解决。
     *
     * @param nums
     * @return
     */
    public int robV2(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
    }

    // 198. 打家劫舍
    private int rob1(int[] nums, int start, int end) { // [start,end) 左闭右开
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i < end; i++) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    /**
     * 解法跟198题的方法一样,使用空间优化降低复杂度
     * @param nums
     * @return
     */
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
