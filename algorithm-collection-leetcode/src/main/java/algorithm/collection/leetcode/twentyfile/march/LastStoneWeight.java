package algorithm.collection.leetcode.twentyfile.march;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 1046. Last Stone Weight
 * TODO 类似的题目
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        // 创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // 模拟操作
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // 取出最大的石头
            int stone2 = maxHeap.poll(); // 取出第二大的石头
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2); // 将差值加入堆
            }
        }

        // 返回结果
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

}
