package algorithm.collection.leetcode.deprecated;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curNode = head;
        while(curNode != null && curNode.next != null){
            if(curNode.val == curNode.next.val){//如果相等，则删除节点，但是不更新指针
                curNode.next = curNode.next.next;
            }else{
                curNode = curNode.next;//不等则更新当前指针
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


