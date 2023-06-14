package algorithm.collection.leetcode.list;

import algorithm.collection.common.datastruct.linklist.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author shadow
 * @create 2023-06-14 07:54
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headIndex = head;
        //单链表怎么实现删除尾项
        while (n > 1) {
            head = head.next;
        }
        return head;
    }

}
