package algorithm.collection.leetcode.november.firstweek.november_3st;

import algorithm.collection.common.datastruct.linklist.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * @author shadow
 * @create 2024-11-03 20:56
 **/
public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = head;
        //head.next.next.next = new ListNode(1);
        DetectCycle detectCycle = new DetectCycle();
        detectCycle.detectCycle(head);
    }

    public ListNode detectCycle(ListNode head) {
        //定义哑结点，防止只有一个环的场景出现
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy,fast = dummy;
        //找到slow和fast在圈内相遇的第一个节点
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        //slow为环内相遇的第一个节点
        ListNode walk = dummy;
        while (walk != null && slow != null) {
            walk = walk.next;
            slow = slow.next;
            if(walk == slow) {
                return walk;
            }
        }
        return null;
    }

}
