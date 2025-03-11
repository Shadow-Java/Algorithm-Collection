package algorithm.collection.leetcode.twentyfile.march;

/**
 * 2012 数组美丽值求和
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 *
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 2
 * 示例 2：
 *
 * 输入：nums = [2,4,6,4]
 * 输出：1
 * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
 * - nums[1] 的美丽值等于 1
 * - nums[2] 的美丽值等于 0
 * 示例 3：
 *
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 0
 *
 * 算法要求：最低要求一定要暴力破解
 */
public class SumOfBeauties {

    /**
     * 2：当前对于1<= i <= nums.length-2的数都需要左边的任何数都小于当前，右边的所有数都大于该数
     * 1：对于1<= i <= nums.length-2的数，仅需要相邻的左边的小于当前数，相邻的右边的数大于当前数
     * 0: 什么都不满足
     * @param nums
     * @return
     */
    public int sumOfBeauties(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length-2; i++) {
            int left = i-1;
            int right = i+1;
            int score = 0;
            while (nums[left] < nums[i] && nums[i] < nums[right]) {
                score = 1;
                if(left == 0 && right == nums.length - 1) {
                    score = 2;
                    break;
                }
                if(left > 0) {
                    left--;
                }
                if(right < nums.length -1) {
                    right++;
                }
            }
            ans += score;
        }
        return ans;
    }


    /**
     * 当前i比较的话是与最左边最小值和右边最大值进行比较；
     * 所以该题为求前缀最大值和后缀最小值的方案
     * @param nums
     * @return
     */
    public int sumOfBeautiesV2(int[] nums) {
        return 0;
    }

}
