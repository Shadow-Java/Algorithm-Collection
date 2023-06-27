package algorithm.collection.leetcode.rangesumquery;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.deprecated.AppendKIntegersWithMinimalSum;
import algorithm.collection.leetcode.list.AddTwoNumbers;

/**
 * 现有一份 n + m次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 *
 * 给你一个长度为 m 的整数数组 rolls ，其中rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 *
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 *
 * k个数字的 平均值 为这些数字求和后再除以k 。
 *
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被n + m整除。
 *
 * 归根结底就是：将n分配m次，且m次中只有1-6这个几个数字
 *
 * 思路：将remain均分为n份且值为res，然后将余数分到n份的res上
 * 比如16分3次，则res=5，有三个是5+1；
 *
 * 时间复杂度：O(n) 执行时间2ms，超过100%用户
 *
 * 同类型的题：2195. 向数组中追加 K 个整数{@link AppendKIntegersWithMinimalSum}
 *
 */
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2028",
        questionTitle = "找出缺失的观测数据",
        relevateClass = AddTwoNumbers.class,
        desc = "给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n ",
        questionLink = "https://leetcode.cn/problems/find-missing-observations/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class FindMissingObservations {

    @MethodTag(
            questionNumber = "2028",
            methodLink = "https://leetcode.cn/problems/find-missing-observations/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.MATH
    )
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int remain = (rolls.length+n)*mean;
        for(int i=0;i<rolls.length;i++){//得到剩下的值
            remain -= rolls[i];
        }
        int min = n;int max=n*6;
        if(remain < min || remain > max){//不能分解
            return new int[]{};
        }
        /**
         * 构造返回值
         */
        int res = remain/n,mod = remain%n;//将remain均分为n份且值为res，然后将余数分到n份上
        int[] resRoll = new int[n];
        for(int i=0;i<n;i++){
            resRoll[i] = res;
            if(i<mod){
                resRoll[i]++;
            }
        }
        return resRoll;
    }

}
