package algorithm.collection.leetcode.november.firstweek.daily;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 3254. 长度为 K 的子数组的能量值 I
 *
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 *
 * 一个数组的 能量值 定义为：
 *
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的子数组的能量值。
 *
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 *
 * 输入：nums = [1,2,3,4,3,2,5], k = 3
 *
 * 输出：[3,4,-1,-1,-1]
 *
 * 解释：
 *
 * nums 中总共有 5 个长度为 3 的子数组：
 *
 * [1, 2, 3] 中最大元素为 3 。
 * [2, 3, 4] 中最大元素为 4 。
 * [3, 4, 3] 中元素 不是 连续的。
 * [4, 3, 2] 中元素 不是 上升的。
 * [3, 2, 5] 中元素 不是 连续的。
 *
 * 输入：nums = [2,2,2,2,2], k = 4
 *
 * 输出：[-1,-1]
 *
 * 输入：nums = [3,2,3,2,3,2], k = 2
 * 输出：[-1,3,-1,3,-1]
 *
 * @author shadow
 * @create 2024-11-06 23:54
 **/
public class ResultsArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,5};
        ResultsArray resultsArray = new ResultsArray();
        System.out.println(resultsArray.resultsArray(nums,3));
    }

    /**
     * 核心思路：找连续上升的段。如果段长至少是 k，那么这段中的所有长为 k 的子数组都是符合要求的，子数组的最后一个元素是最大的。
     *
     * 具体来说，遍历数组的同时，用一个计数器 cnt 统计连续递增的元素个数：
     *
     * 初始化 cnt=0。
     * 如果 i=0 或者 nums[i]=nums[i−1]+1，把 cnt 增加 1；否则，把 cnt 置为 1。
     * 如果发现 cnt≥k，那么下标从 i−k+1 到 i 的这个子数组的能量值为 nums[i]，即 ans[i−k+1]=nums[i]。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray_V2(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);//填写默认值
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }

    /**
     * 单调栈
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray_V3(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};

        int len = nums.length;
        int[] res = new int[len - k + 1];

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            // 如果栈顶元素不等于 nums[i] - 1，那么不满足题目的连续增长的条件
            // 把栈内元素全部 pop 出去
            if (!stack.isEmpty() && stack.getFirst() != nums[i] - 1) {
                while (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            }

            // 把目前遍历的元素加进去
            stack.addFirst(nums[i]);

            // 如果目前遍历的 nums[i] 可以是长度为 k 的子数组的结尾值
            // 判断栈内元素数量是否大于等于 k
            if (i >= k - 1) {
                // 如果大于等于 k，说明以 nums[i] 结尾的长度为 k 的子数组满足连续增长的条件
                if (stack.size() >= k) res[i - k + 1] = nums[i];
                else res[i - k + 1] = -1;
            }
        }

        return res;
    }

    /**
     * 定长滑窗
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for (int right = 0;right<nums.length;right++) {
            deque.offerLast(nums[right]);
            if(deque.size() == k) {
                if(isAsc(deque)) {
                    ans[right-k+1] = deque.peekLast();
                } else {
                    ans[right-k+1]= -1;
                }
                deque.pollFirst();
            }
        }
        return ans;
    }

    /**
     * 注意Integer比较用equals
     * @param deque
     * @return
     */
    public boolean isAsc(Deque<Integer> deque) {
        int lastVal = deque.peekFirst();
        boolean isAsc = true;
        int index = 1;
        for (Integer cur : deque) {
            if(index == 1) {
                index++;
                continue;
            }
            if(!cur.equals(lastVal+1)) {
                isAsc = false;
            }
            lastVal = cur;
        }
        return isAsc;
    }

}
