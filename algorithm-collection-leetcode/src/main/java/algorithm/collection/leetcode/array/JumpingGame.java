package algorithm.collection.leetcode.array;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @author shadow
 * @create 2023-10-08 00:00
 **/
public class JumpingGame {

    /**
     * 维护每个当前位置能达到的最远距离
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i=0;i< nums.length;i++){
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
