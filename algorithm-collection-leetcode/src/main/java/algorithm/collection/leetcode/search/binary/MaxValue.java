package algorithm.collection.leetcode.search.binary;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 *
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 *
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 *
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 *
 *输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 *
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 *
 * @author shadow
 * @create 2023-06-12 22:57
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1802",
        questionTitle = "有界数组中指定下标处的最大值",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target,letters 里至少有两个不同的字符。",
        questionLink = "https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/",
        algorithmCategory = AlgorithmCategory.BINARY_FIND,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MaxValue {

    @MethodTag(
            questionNumber = "1802",
            methodLink = "https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BINARY_FIND
    )
    public int maxValue(int n, int index, int maxSum) {
        //从1-maxsum中找index的最大值
        int left = 1, right = maxSum;
        while (left < right) {
            //如果遇到 right=mid-1，那么 mid 就是 (left + right + 1) >> 1；如果 right = mid，那么 mid 就是 (left + right) >> 1
            //">>>" 是无符号右移位运算符，它将二进制数向右移动指定的位数，并在左侧填充零
            //对于二进制数 11110000，右移两位后，有符号右移位运算符 ">>" 的结果为 11111100
            int mid = (left + right + 1) >>> 1;
            //计算左区间从mid-1递减到1，个数为index + 计算右区间mid递减到1，个数为n - index
            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                //因为要尽可能的大，则left递增
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 假设最大值的索引为index，那么需要计算[0,index]和[index,n-1]的所有元素和
     * 设cnt为区间元素个数，那么左区间数组元素个数为index+1，右区间元素个数为n-index
     * 1. cnt >= x, 那么会有多余的数全部放置为1: cnt - x, 剩下的数为1,2,...x, 和为(x+1)*x/2。
     * 总和 = cnt - x + (x+1)*x/2
     * 2. cnt < x, 那么放置的数为 x - cnt + 1, x - cnt, ...., x即[x-cnt+1, x],
     * 总和 = (2x-cnt+1) * cnt / 2
     *
     * 不管左区间还是右区间都是从x递减到1，所以只需要提供元素个数cnt，则能通过一个函数计算两个不同的区间
     *
     * @param x 最大值
     * @param cnt 数量
     * @return
     */
    private long sum(long x, int cnt) {
        return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
    }

}
