package algorithm.collection.leetcode.october.fourtweek.twenty_nine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * @author shadow
 * @create 2024-11-02 13:52
 **/
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        //堆结构其实就是排序，只不过是通过单词出现的频次进行排序
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> maxHeap =  new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //利用频次进行统计
                Integer count1 = countMap.get(o1);
                Integer count2 = countMap.get(o2);
                //如果频次相同则根据数字进行比较,取出最大的那个
                return count2-count1 == 0 ? o1.compareTo(o2) : count2-count1;
            }
        });
        for (Integer key : countMap.keySet()) {
            maxHeap.add(key);
        }
        int[] ans = new int[k];
        int left = 0;
        while (left < k) {
            ans[left++] = maxHeap.poll();
        }
        return ans;
    }

}
