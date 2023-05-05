package algorithm.collection.leetcode.baseclass.list;

/**
 * Definition for singly-linked list.
 *
 * @author shadow
 * @date 2023/4/10 9:29
 * @since 1.0
 */
public class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
