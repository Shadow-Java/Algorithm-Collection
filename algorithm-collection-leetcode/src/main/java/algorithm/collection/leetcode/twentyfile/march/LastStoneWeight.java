package algorithm.collection.leetcode.twentyfile.march;

import java.util.PriorityQueue;

/**
 * LeetCode 1046. Last Stone Weight
 * TODO 类似的题目
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        //创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int item : stones) {
            maxHeap.offer(item);
        }
        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int min = maxHeap.poll();
            if(max > min) {//判断是否相等
                maxHeap.offer(max-min);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

}
