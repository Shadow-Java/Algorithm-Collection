package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2023-08-24 00:32
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "594",
        questionTitle = "最长和谐子序列",
        desc = "和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 ",
        questionLink = "https://leetcode.cn/problems/longest-harmonious-subsequence/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP}
)
public class LongestHarmoniousSubsequence {


    /**
     * 对于数组{1, 3, 2, 2, 5, 2, 3, 7},其中我们求的是[3,2,2,2,3];
     * 起初以为排序后打乱相对顺序，但排序后为[2,2,2,3,3]，虽然相对顺序变化，但最大最小值的差值仍然是1，即长度没变，求解没变
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "594",
            methodLink = "https://leetcode.cn/problems/longest-harmonious-subsequence/solutions/1111541/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-quuh/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public int findLHS(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序

        int result = 0;
        int start = 0; // 和谐子序列的起始位置
        //当前位置i,判断起始位置和当前位置的差值是否为1，如果大于1则更新start
        //排序后的数组为[1, 2, 2, 2, 3, 3, 5, 7]
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[start] > 1) {
                start++; // 移动起始位置，直到满足和谐条件
            }

            if (nums[i] - nums[start] == 1) {
                result = Math.max(result, i - start + 1);
            }
        }

        return result;
    }

}
