package algorithm.collection.leetcode.dynamicprogramming.linear;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.MaximumSubarray;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *
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
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "740",
        questionTitle = "删除并获得点数",
        relevateClass = MaximumSubarray.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/delete-and-earn/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DeleteAndEarn {

    /**
     * 打家劫舍问题：即强盗选择一条线上的i房屋进行打劫，但要求不能打劫相邻的房屋(i+1和i-1),那么需要讨论出最优的打劫方案，使其打劫的收益最大
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
    public int deleteAndEarn(int[] nums) {
        return 0;
    }

}
