package algorithm.collection.leetcode.test;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.linklist.SingleLinkListNode;

public class TestCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        if (slow == fast) {
            return true;
        }
        return false;
    }
    public static SingleLinkListNode reverseList(SingleLinkListNode head) {
        //记录的新的链表
        SingleLinkListNode prev = null;
        SingleLinkListNode next;
        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
