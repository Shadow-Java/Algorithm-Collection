package algorithm.collection.leetcode.twentyfile.march;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2025-03-15 19:11
 **/
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(productExceptSelf.productExceptSelf(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 1;
        leftSum[1] = nums[0];
        rightSum[nums.length-1] = 1;
        rightSum[nums.length-2] = nums[nums.length-1];
        for (int i = 2; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] * nums[i-1];
        }
        for (int i = nums.length - 3; i >= 0; i--) {
            rightSum[i] = nums[i+1] * rightSum[i+1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftSum[i] * rightSum[i];
        }
        return ans;
    }

}
