package algorithm.collection.leetcode.november.secondweek.november_16st;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * @author shadow
 * @create 2024-11-16 22:42
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            int zy = nums[i]+i;
            if(last <= nums.length-1 && (nums[last]+last) < i) {
                continue;
            }
            if(zy > last) {
                last = zy;
            }
        }
        return last >= nums.length-1;
    }

    public boolean canJumpV2(int[] nums) {
        int max = 0;//一步一步的跳，记录每次能跳的最大距离
        for (int i = 0; i < nums.length; i++) {
            if (i > max) { // 如果最大距离连i都无法到达
                return false;
            }
            max = Math.max(max, i + nums[i]); // 从 i 最右可以跳到 i + nums[i]
        }
        return true;
    }

}
