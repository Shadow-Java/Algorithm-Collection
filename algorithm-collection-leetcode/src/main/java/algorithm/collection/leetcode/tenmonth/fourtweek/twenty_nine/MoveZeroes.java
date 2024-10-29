package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_nine;

/**
 * @author shadow
 * @create 2024-10-29 22:04
 **/
public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * 示例 1:
     *
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for(int i=j;i<nums.length;i++) {
            nums[i] = 0;
        }
    }

}
