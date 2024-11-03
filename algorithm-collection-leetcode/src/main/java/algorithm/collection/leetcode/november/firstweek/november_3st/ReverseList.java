package algorithm.collection.leetcode.november.firstweek.november_3st;

import algorithm.collection.common.datastruct.linklist.ListNode;

/**
 * @author shadow
 * @create 2024-11-03 17:40
 **/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        //对于每个当前的节点都有个前节点和后节点
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
