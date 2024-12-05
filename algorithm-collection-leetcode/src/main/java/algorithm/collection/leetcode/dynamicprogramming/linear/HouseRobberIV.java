package algorithm.collection.leetcode.dynamicprogramming.linear;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 *
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 *
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 *
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 *
 * 另给你一个整数k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 *
 * 返回小偷的 最小 窃取能力。
 *
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 *
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 *
 *
 * @author shadow
 * @create 2023-07-09 16:39
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "2560",
        questionTitle = "打家劫舍 IV",
        relevateClass = HouseRobber.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/house-robber-iv/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.BINARY_TREE}
)
public class HouseRobberIV {

    /**
     * 看到「最大化最小值」或者「最小化最大值」就要想到二分答案，这是一个固定的套路
     * 一般来说，二分的值越大，越能/不能满足要求；二分的值越小，越不能/能满足要求，有单调性，可以二分。
     *
     * 最小化最大值 (Minimax)：尽量减少最坏情况下的不利影响。
     * 想象你正在玩一个游戏，你的目标是确保即使在最坏的情况下，你也能够得到尽可能好的结果。换句话说，你想要找到一个策略，使得无论对手怎么行动，你遭受的损失（或不利情况）是最小的。
     *
     *
     * 例子
     * 分蛋糕：如果有三块大小不同的蛋糕要分给两个朋友，你想让每个朋友拿到的那块蛋糕中的较大一块尽可能小。这样，即使朋友挑了最大的那块，另一块也不会太小。
     * 分配任务：假设你有10个任务要分给3个人完成，每个任务需要的时间不同。你希望安排这些任务，使得最忙的那个人的工作量尽可能少。这样，没有一个人会被压垮
     *
     * 最大化最小值 (Maximin)：尽量提高最差情况下的有利程度。
     * 相反地，如果你的目标是确保每个人都能获得至少一定数量的好处，即使是最少的那个也能得到尽可能多的好处，那么这就是最大化最小值的问题。
     *
     * 例子
     * 公平分配糖果：你有一袋糖果要分给几个孩子，你想保证即使是得到最少糖果的孩子，也能得到尽可能多的糖果。这样，所有孩子都会感到更公平。
     * 比赛奖金分配：在一个比赛中，你要分配固定金额的奖金给前几名选手。你希望设置奖金数额，使得最后一名获奖者也能得到尽可能多的钱。
     *
     *
     * 类似的题目在先前的周赛中出现过多次，例如：
     * TODO list
     * 2439. 最小化数组中的最大值
     * 2513. 最小化两个数组中的最大值
     * 2517. 礼盒的最大甜蜜度
     * 2528. 最大化城市的最小供电站数目
     * @param nums
     * @param k
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/house-robber-iv/solution/er-fen-da-an-dp-by-endlesscheng-m558/",
            questionNumber = "2560",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public static int minCapability(int[] nums, int k) {
        int left = 0, right = (int) 1e9;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int f0 = 0, f1 = 0;
            for (int x : nums) {
                if (x > mid) {
                    f0 = f1;
                } else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            }
            if (f1 >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobberIV.minCapability(nums,2);
    }

}
