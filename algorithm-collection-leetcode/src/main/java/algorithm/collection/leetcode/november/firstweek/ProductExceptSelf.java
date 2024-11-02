package algorithm.collection.leetcode.november.firstweek;

/**
 * 238. 除自身以外数组的乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 难点：在空间复杂度为O(1)的情况下完成
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 * @author shadow
 * @create 2024-11-01 22:15
 **/
public class ProductExceptSelf {

    /**
     * 原数组：       [1       2       3       4]
     * 左部分的乘积：   1       1      1*2    1*2*3
     * 右部分的乘积： 2*3*4    3*4      4      1
     * 结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //还可以将left压缩至ans中
        int[] left = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        //计算左边乘积
        for(int i=1;i<n;i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        int right = 1;
        //计算右边乘积
        for(int i=n-2;i>=0;i--) {
            ans[i+1] = right* left[i+1];
            right = right*nums[i+1];
        }
        ans[0] = right;
        return ans;
    }

}
