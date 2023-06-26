package algorithm.collection.leetcode.list.single;


import algorithm.collection.common.datastruct.linklist.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKListsTest {

    public ListNode mergeKListsAnotherWay(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //最小堆
        Queue<ListNode> heap = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.offer(listNode);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            preNode.next = minNode;
            preNode = preNode.next;
            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }
        return dummyNode.next;
    }

}