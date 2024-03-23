package algorithm.collection.leetcode.matrix;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.tree.binarysearch.GenerateTrees;

/**
 * @author shadow
 * @create 2024-03-23 22:41
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2549",
        questionTitle = "统计桌面上的不同数字",
        relevateClass = GenerateTrees.class,
        desc = "给你一个正整数 n ，开始时，它放在桌面上。在 109 天内，每天都要执行下述步骤",
        questionLink = "https://leetcode.cn/problems/count-distinct-numbers-on-board/description/?envType=daily-question&envId=2024-03-23",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DistinctIntegers {

    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }

}
