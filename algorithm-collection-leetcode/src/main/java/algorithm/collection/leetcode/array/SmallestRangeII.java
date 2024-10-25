package algorithm.collection.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shadow
 * @create 2024-10-20 23:58
 **/
public class SmallestRangeII {

    public int smallestRangeII(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 0;
        }
        Stack<Integer> stack = new Stack<>();
        return 0;
    }

}
