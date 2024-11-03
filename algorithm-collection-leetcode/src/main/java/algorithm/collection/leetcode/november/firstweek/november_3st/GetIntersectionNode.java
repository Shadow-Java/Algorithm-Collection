package algorithm.collection.leetcode.november.firstweek.november_3st;

import algorithm.collection.common.datastruct.linklist.ListNode;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *       a1 -> a2
 *               \
 *                c1 -> c2 -> c3
 *               /
 * b1 -> b2 -> b3
 *
 * @author shadow
 * @create 2024-11-03 17:18
 **/
public class GetIntersectionNode {

    /**
     * 遍历两个链表节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode curB = headB;
            while (curB != null) {
                if(headA == curB) {
                    return curB;
                }
                curB = curB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * 双指针：当A和B都不相同的时候，都移动
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_V2(ListNode headA, ListNode headB) {
        //创建一个指针进行遍历
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}
