package SourceCode.src;

/**
 * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 *
 * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 *
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 *
 * k 个数字的 平均值 为这些数字求和后再除以 k 。
 *
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
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
public class FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int remain = (rolls.length+n)*mean;
        for(int i=0;i<rolls.length;i++){//得到剩下的值
            remain -= rolls[i];
        }
        int min = n;int max=n*6;
        if(remain < min || remain > max){//不能分解
            return new int[]{};
        }
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
