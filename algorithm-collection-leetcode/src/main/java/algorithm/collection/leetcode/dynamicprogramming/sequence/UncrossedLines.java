package algorithm.collection.leetcode.dynamicprogramming.sequence;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.dynamicprogramming.linear.HouseRobber;

/**
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i]和 nums2[j]的直线，这些直线需要同时满足满足：
 *    ·nums1[i] == nums2[j]
 *    ·且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 *
 * @author shadow
 * @create 2023-07-15 15:48
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1035",
        questionTitle = "不相交的线",
        relevateClass = HouseRobber.class,
        desc = "在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数",
        questionLink = "https://leetcode.cn/problems/uncrossed-lines/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //最多的连线其实就是在求最长公共子序列
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {

            for (int j = 1; j <= nums2.length; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

}
