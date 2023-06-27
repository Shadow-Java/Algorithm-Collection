package algorithm.collection.leetcode.rangesumquery;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.list.AddTwoNumbers;

/**
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 *
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数
 *
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 *
 * @author shadow
 * @create 2023-06-26 22:27
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2485",
        questionTitle = "找出中枢整数",
        relevateClass = AddTwoNumbers.class,
        desc = "给你一个正整数 n ，找出满足下述条件的 中枢整数 x",
        questionLink = "https://leetcode.cn/problems/find-the-pivot-integer/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class FindThePivotInteger {

    /**
     * 记从正整数x加到正整数y，y >= x的和为：sum(x,y)=x+(x+1)+⋯+y<br/>
     * 由等差数列求和公式得：sum(x,y)=（x+y）*（y-x+1）/2<br/>
     * 于是sum(1,x)=sum(x,n)<br/>
     * 进一步简化为x =
     *
     * @param n
     * @return
     */
    @MethodTag(
            questionNumber = "2485",
            methodLink = "https://leetcode.cn/problems/find-the-pivot-integer/solution/zhao-chu-zhong-shu-zheng-shu-by-leetcode-t7gn/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.MATH
    )
    public int pivotInteger(int n) {
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }

}
