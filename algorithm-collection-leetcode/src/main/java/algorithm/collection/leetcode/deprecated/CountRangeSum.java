package algorithm.collection.leetcode.deprecated;

/**
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 解释：i和j表示的是nums数组的索引，即下标。当i=0时，迭代的子数组为[-2]；[-2,5]；[-2,5,-1]；三个子数组表示的和为-2,3,2
 * 只有-2,3,2在【-2,2】中，即[0,0],[0,2].当i=1时，迭代的子数组为[5],[5,-1].和为5,4 都不在子数组中
 * 当i=2时[2],在[-2,2]中，即[2,2],所以总共三个
 *
 *
 *
 * 一维前缀和
 */
public class CountRangeSum {

    /**
     * 暴力解，时间复杂度O(n^2)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;//计数器
        for(int i=0;i<nums.length;i++){//第i轮
            long sum = 0;//注意是long型，数组内数字都是长整数
            for(int j = i;j<nums.length;j++){//每一轮迭代相加
                sum += nums[j];
                if(sum >= lower && sum <= upper){//每加一次会判断是否在区间内
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 一维前缀和  前缀和数组的第 i 项就是一个序列前面 i 个数的总和
     *
     *    void init() {
     *         sum[0] = 0;
     *         for(int i = 1; i <= n; i++)
     *             sum[i] = sum[i - 1] + a[i];
     *     }
     */

}
