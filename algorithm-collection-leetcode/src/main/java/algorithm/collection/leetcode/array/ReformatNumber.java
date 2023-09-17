package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.bitManipulation.CountPrimeSetBits;

/**
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 *
 * 输入：number = "123 4-567"
 * 输出："123-45-67"
 * 解释：数字是 "1234567".
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * 连接这些块后得到 "123-45-67" 。
 * @author shadow
 * @create 2023-09-17 17:16
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "1694",
        questionTitle = "重新格式化电话号码",
        relevateClass = CountPrimeSetBits.class,
        desc = "给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。",
        questionLink = "https://leetcode.cn/problems/reformat-phone-number/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class ReformatNumber {

    @MethodTag(
            questionNumber = "1694",
            methodLink = "https://leetcode.cn/problems/reformat-phone-number/description/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public String reformatNumber(String number) {
        String s = number.replace("-", "").replace(" ", "");
        int idx = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        for (; idx < n - 4; idx += 3) {
            sb.append(s.substring(idx, idx + 3));
            sb.append("-");
        }
        if (n - idx == 4) {
            sb.append(s.substring(idx, idx + 2));
            idx += 2;
            sb.append("-");
        }
        sb.append(s.substring(idx, n));
        return sb.toString();
    }

}
