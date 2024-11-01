package algorithm.collection.leetcode.october.fourtweek.twenty_thirty_one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 窗口使用队列，而不是用list
 * @author shadow
 * @create 2024-10-31 20:55
 **/
public class MaxSlidingWindow {

    /**
     * 本题难点： 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从 O(k) 降低至 O(1)
     * 窗口对应的数据结构为 双端队列 ，本题使用 单调队列 即可解决以上问题。遍历数组时，每轮保证单调队列 deque ：
     *
     * 1.deque 内 仅包含窗口内的元素 ⇒ 每轮窗口滑动移除了元素 nums[i−1] ，需将 deque 内的对应元素一起删除。
     * 2.deque 内的元素 非严格递减 ⇒ 每轮窗口滑动添加了元素 nums[j+1] ，需将 deque 内所有 <nums[j+1] 的元素删除。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_V3(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减，将 “获取窗口内最大值” 的时间复杂度从 O(k) 降低至 O(1)
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        if(nums.length==1) {
            ans[0] = nums[0];
            return ans;
        }
        int left =0;
        //int windowMax = nums[left];
        List<Integer> window = new ArrayList<>();
        for(int right=0;right<nums.length;right++) {
            window.add(nums[right]);
            if(window.size() == k) {
                int windowMax = window.stream().max(Integer::compare).get();
                window.remove(0);
                ans[left++] = windowMax;
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow_V2(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        if(nums.length==1) {
            ans[0] = nums[0];
            return ans;
        }
        int left =0;
        for(int right=0;right<nums.length;right++) {
            int windowSize = right - left + 1;
            if(windowSize == k) {
                int max = Integer.MIN_VALUE;
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                }
                ans[left++] = max;
            }
        }
        return ans;
    }

}
