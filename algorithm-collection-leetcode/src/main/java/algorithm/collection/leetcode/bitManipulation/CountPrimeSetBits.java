package algorithm.collection.leetcode.bitManipulation;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 *
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 *
 * @author shadow
 * @create 2023-06-09 22:25
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "762",
        questionTitle = "二进制表示中质数个计算置位",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）",
        questionLink = "https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/",
        algorithmCategory = AlgorithmCategory.BIT_MANIPULATION,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class CountPrimeSetBits {


    /**
     * lowbit运算---树状数组<br/>
     * https://www.cnblogs.com/fusiwei/p/11752540.html
     * @param left
     * @param right
     * @return
     */
    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BIT_MANIPULATION
    )
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            int countBit = 0;
            while (((i >> 1) & 1) == 1){
                countBit++;
            }
            if(isPrime(countBit)){
                count++;
            }
        }
        return count;
    }

    /**
     * 质数优化
     *
     * 注意到 `right<=10^6<2^20`，因此二进制中的1的个数不会超过19，而不超过的质数只有`2,3,5,7,11,13,17,19`
     *
     * 因此可以用19位二进制数 `mask==665772=(10100010100010101100)₂`来存储这些质数，其中 mask 二进制的从低到高的第i位为1表示i是质数，为0表示i不是质数
     *
     * 设整数x的二进制中1的个数为c，若mask按位与2^c不为0，则说明c是一个质数。
     *
     * 假设x的二进制中1的个数为`2^3=8=(1000)₂` 则mask&8 != 0，说明是质数
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBitsAnotherWay(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int mask = 665772;
            if((mask & (1 << Integer.bitCount(i))) != 0){//1 << Integer.bitCount(i)表示左移多少位，比如2^3=1000
                count++;
            }
        }
        return count;
    }


    /**
     * 统计字符串中1或0的个数
     * @param num
     * @return
     */
    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public int ones(int num){//统计1的个数
        int ans = 0;
        while(num != 0){
            if(num%2==1){
                ans++;
            }
            num /= 2;
        }
        return ans;
    }

    /**
     * 判断一个数是否为质数
     * @param x  1不是质数，2和3是质数
     * @return
     */
    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        /**
         * 只需要判断i=[2,n/2]的这段距离,用n%i==0
         */
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
