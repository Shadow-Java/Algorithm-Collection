package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * @author shadow
 * @create 2023-05-28 16:51
 **/
@QuestionTag(
        questionNumber = "239",
        questionTitle = "滑动窗口最大值",
        difficultyLeve = DifficultyLevel.HARD,
        desc = "给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。",
        questionLink = "https://leetcode.cn/problems/sliding-window-maximum/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP, DataStructType.ARRAY_LIST}
)
public class SlidingWindowMaximum {

    /**
     * 使用类似单调递减栈结构去推进窗口<br/>
     * 为什么使用队列：因为需要移除队列头<br/>
     * 设置双端队列存储最大值（便于O(1)时间获取），队列降序排列，一轮遍历，先把窗口塞满，然后这时就可以返回最大值（队头）了，但返回前要做2件事，首先，要加入数组当前下标到队尾，并保证是单调的，其次，如果队头这是已经到了窗口左边，就移除队头
     *
     * @param nums
     * @param k
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/sliding-window-maximum/solutions/10025/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/",
            questionNumber = "239",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.DEDED_DOUBLE_QUEUE,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效,即是否超出窗口
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

}
