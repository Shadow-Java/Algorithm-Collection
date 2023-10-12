package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * @author shadow
 * @create 2023-10-08 00:00
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "55",
        questionTitle = "跳跃游戏",
        relevateClass = FindMaxK.class,
        desc = "给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。",
        questionLink = "https://leetcode.cn/problems/jump-game/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class JumpingGame {

    /**
     * 维护每个当前位置能达到的最远距离
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "2562",
            methodLink = "https://leetcode.cn/problems/find-the-array-concatenation-value/solutions/2420231/zhao-chu-shu-zu-de-chuan-lian-zhi-by-lee-4aam/?envType=daily-question&envId=2023-10-12",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i=0;i< nums.length;i++){
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
