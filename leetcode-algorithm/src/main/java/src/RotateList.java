package src;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class RotateList {

    /**
     * 双指针思路，拿到循环链表，计算链表长度。定义slow与fast=slow+node[k],两者相差k个节点，那么移动slow就能拿到fast的尾节点
     */

    /**
     * 将单链表置成循环链表，通过计算循环次数找到尾节点，置空再返回头结点
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode tail = head;
        int count = 1;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        tail.next = head;//形成循环链表
        tail = head;
        int index = 0;//第几个是尾节点
        if(k < count){
            index = count-k;
        }else{
            index = count - k%count;
        }
        for(int i=1;i<index;i++){//第几个是尾节点，找到他
            tail = tail.next;
        }
        head = tail.next;//拿到头结点
        tail.next = null;//尾节点置null
        return head;
    }

    /**
     * 暴力法：递归找到倒数第二个节点，插入前驱节点，时间复杂度O（n*k）
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight_1(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        head = dummy;
        for(int i=1;i<=k;i++){
            while(head.next.next != null){//拿到倒数第二个节点
                head = head.next;
            }
            ListNode curNode = head.next;
            head.next = null;
            curNode.next = preNode.next;
            preNode.next = curNode;
            head = preNode;
        }
        return dummy.next;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
