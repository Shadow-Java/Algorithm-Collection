package algorithm.collection.leetcode.november.secondweek.november_15st;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author shadow
 * @create 2024-11-15 22:41
 **/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            dict.put(num, dict.getOrDefault(num, 0) + 1);
        }
        //堆结构一定要记得，负数是最小堆，正数是最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer f1 = dict.get(o1);
                Integer f2 = dict.get(o2);
                //如果出现的频率相同，则选择数字大的那个数，否则就是频率最高的
                return f1.equals(f2) ? o2 - o1 : f2 - f1;
            }
        });
        for (int num : dict.keySet()) {
            maxHeap.offer(num);
        }
        int left = 0;
        while (k > 0) {
            ans[left++] = maxHeap.poll();
            k--;
        }
        return ans;
    }
}
