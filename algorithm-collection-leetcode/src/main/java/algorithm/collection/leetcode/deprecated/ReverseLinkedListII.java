package algorithm.collection.leetcode.deprecated;

public class ReverseLinkedListII {
    /**
     * 实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:
     *
     * 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * 当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     * 当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     * 1->4->3->2->5.
     * @param head
     * @param m
     * @param n
     * @return
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//操作pre 等于操作 head
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;//head为pre.next对象的引用
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;//pre改变，同一内存下的结点值dummy头结点不变
    }


    public static void main(String[] arg){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        pre.next.val = 7;

        System.out.println(head.val);//等于7

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
