package algorithm.collection.leetcode.bitManipulation;

import java.util.HashSet;

/**
 * 2521. 数组乘积中的不同质因数数目
 * 给你一个正整数数组 nums ，对 nums 所有元素求积之后，找出并返回乘积中 不同质因数 的数目。
 *
 * 注意：
 *
 * 质数 是指大于 1 且仅能被 1 及自身整除的数字。
 * 如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。
 *
 * 输入：nums = [2,4,3,7,10,6]
 * 输出：4
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7 。
 * 共有 4 个不同的质因数，所以返回 4 。
 *
 *
 * 输入：nums = [2,4,8,16]
 * 输出：1
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 8 * 16 = 1024 = 210 。
 * 共有 1 个不同的质因数，所以返回 1 。
 *
 * @author shadow
 * @create 2025-03-02 16:52
 **/
public class DistinctPrimeFactors {

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            for (int i = 2; i * i <= x; i++)
                if (x % i == 0) {
                    set.add(i);
                    while (x % i == 0)
                        x /= i;//将当前的质数全部整除掉
                }
            if (x > 1) //如何还有自身，那么将其添加
                set.add(x);
        }
        return set.size();
    }

}
