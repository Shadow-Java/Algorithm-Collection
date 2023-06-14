package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
 * <p>
 * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
 * <p>
 * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间[1, i] 内的所有位都是 1 ，而其他位都是 0 。
 * <p>
 * 返回二进制字符串在翻转过程中 前缀一致 的次数。
 *
 * @author shadow
 * @create 2023-06-14 07:20
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1375",
        questionTitle = "二进制字符串前缀一致的次数",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）",
        questionLink = "https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/",
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NumTimesAllBlue {

    @MethodTag(
            questionNumber = "1375",
            methodLink = "https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public int numTimesAllBlue(int[] flips) {
        int[] arr = new int[flips.length];
        int count = 0;
        int max = flips[0];
        for (int x : flips) {
            arr[x - 1] = 1;
            //最大的下标，就是中间不能为0，比如1101
            max = Math.max(x, max);
            if (!exist0(arr, 0, max - 1)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @return [left, right]是否存在0
     */
    private boolean exist0(int[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                return true;
            }
        }
        return false;
    }

    @MethodTag(
            questionNumber = "1375",
            methodLink = "https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public int numTimesAllBlueAnotherWay(int[] flips) {
        int maxVal = 0, n = flips.length, res = 0;
        //当前最大值和下标相等时说明前缀一致
        for (int i = 0; i < n; ++i) {
            maxVal = Math.max(maxVal, flips[i]);
            if (maxVal == i + 1)
                ++res;
        }
        return res;
    }

}
