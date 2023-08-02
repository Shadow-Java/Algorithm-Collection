package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 *
 * 返回正整数 k ，如果不存在这样的整数，返回 -1
 *
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 *
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 *
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 *
 * @author shadow
 * @create 2023-05-15 00:08
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2441",
        questionTitle = "与对应负数同时存在的最大正整数",
        relevateClass = FindMaxK.class,
        desc = "给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k",
        questionLink = "https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class FindMaxK {

    /**
     * 使用哈希表s记录数组中出现的所有元素，用一个变量记录要求的最大值
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "2441",
            methodLink = "https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public int findMaxK(int[] nums) {
        int ans = -1;
        //记录负数或者整数 hash存储 查找只有O（1）
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int x : s) {
            if (s.contains(-x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

}
