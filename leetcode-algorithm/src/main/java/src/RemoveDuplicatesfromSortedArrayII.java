package src;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
    /**
     * 思路：定义两个指针,当前两个指针都是指向同一个索引，每次nums[slow-2] 和 nums[fast]进行比较，如果相等则不更新slow，不相等则更新slow
     * 总结：本题最重要的是理解双指针的含义，每个指针变量是怎样更新的？
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int fast = 0;
        int slow = 0;

        while (fast < n){
            if (slow < 2 || nums[fast] > nums[slow - 2]) {
                nums[slow]  = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }

    public int removeDuplicates_2(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast<nums.length;fast++){
            if(slow < 2 || nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    /**
     * 通用解法：
     * 为了让解法更具有一般性，我们将原问题的「保留 2 位」修改为「保留 k 位」。
     *
     * 对于此类问题，我们应该进行如下考虑：
     *
     * 由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留
     * 对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留
     * 举个🌰，我们令 k=2，假设有如下样例
     *
     * [1,1,1,1,1,1,2,2,2,2,2,2,3]
     *
     * 首先我们先让前 2 位直接保留，得到 1,1
     * 对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 k 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，得到 1,1,2
     * 继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
     * 这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3
     *
     * @param nums
     * @return
     */
    public int removeDuplicates_3(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }



}
