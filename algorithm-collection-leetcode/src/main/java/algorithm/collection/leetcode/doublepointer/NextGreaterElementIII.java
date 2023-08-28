package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 * 输入：n = 12
 * 输出：21
 *
 * 输入：n = 21
 * 输出：-1
 * @author shadow
 * @create 2023-08-24 22:38
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "556",
        questionTitle = "下一个更大元素 III",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1",
        questionLink = "https://leetcode.cn/problems/next-greater-element-iii/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NextGreaterElementIII {

    /**
     * 下一个更大的数：1234下一个更大的数为1243，且4321没有下一个更大的数；再比如12476，下一个更大的数为12674；
     * 即需要找到最后的一个升序对，/\,从后往前找第一个降序位置i，且[i,length-1]中比nums[i]第一个大的数
     * @param n
     * @return
     */
    @MethodTag(
            questionNumber = "556",
            methodLink = "https://leetcode.cn/problems/next-greater-element-iii/solutions/1642334/by-lfool-vi69/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public static int nextGreaterElement(int n) {
        // 转换成 char[]
        char[] s = String.valueOf(n).toCharArray();
        // 从后向前查找第一个相邻升序的元素对
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                // 从 i 开始排序
                Arrays.sort(s, i, s.length);
                // 从 i 开始向后找第一个比 i - 1 大的元素
                for (int j = i; j < s.length; j++) {
                    // 找到就交换
                    if (s[j] > s[i - 1]) {
                        char t = s[i - 1];
                        s[i - 1] = s[j];
                        s[j] = t;
                        // 判断是否为 32 位整数
                        long ans = Long.parseLong(String.valueOf(s));
                        if (ans > Integer.MAX_VALUE) {
                            return -1;
                        }
                        return (int) ans;
                    }
                }
            }
        }
        // 没有下一个更大的元素
        return -1;
    }
}
