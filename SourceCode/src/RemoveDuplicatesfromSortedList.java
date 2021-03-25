package SourceCode.src;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        return new ListNode();
    }

    public class ListNode {
        int val;
        RemoveDuplicates.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveDuplicates.ListNode next) { this.val = val; this.next = next; }
    }
}


