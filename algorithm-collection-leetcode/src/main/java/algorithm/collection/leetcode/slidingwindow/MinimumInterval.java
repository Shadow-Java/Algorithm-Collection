package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.List;

/**
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 *
 * @author shadow
 * @create 2023-05-28 17:05
 **/
@QuestionTag(
        questionNumber = "632",
        questionTitle = "最小区间",
        difficultyLeve = DifficultyLevel.HARD,
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        timeComplexity = TimeComplexity.O_N
)
public class MinimumInterval {

    /**
     * 1.需要区间最小，计算区间最小的是：定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     * 2.给的参数集 至少有一个元素在该区间内
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "632",
            methodLink = "https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public int[] smallestRange(List<List<Integer>> nums) {
        return new int[]{};
    }

}
