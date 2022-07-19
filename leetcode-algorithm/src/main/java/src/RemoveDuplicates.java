package src;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);//使用哑结点,可以删除首字母重复的情况
        dummy.next = head;
        ListNode lastNode = dummy;
        int isDelete = 0;
        ListNode preNode = lastNode;
        ListNode curNode = lastNode.next;
        while(curNode != null){
            if(curNode.val == lastNode.val){
                isDelete = 1;
            }
            if(isDelete == 0 && curNode.val != lastNode.val){//如果上一次是不需要删除，则更新前驱节点
                preNode = lastNode;
            }
            if(isDelete == 1 && curNode.val != lastNode.val){//如果上一次是需要删除，则删除冗余节点，并更新
                preNode.next = curNode;
                isDelete = 0;
            }
            if(curNode.next == null && lastNode.val == curNode.val){
                preNode.next = null;
            }
            lastNode = lastNode.next;
            curNode = lastNode.next;
        }
        return dummy.next;
    }


    /**
     * 我们从指针 \textit{cur}cur 指向链表的哑节点，随后开始对链表进行遍历。如果当前 \textit{cur.next}cur.next 与 \textit{cur.next.next}cur.next.next 对应的元素相同，那么我们就需要将 \textit{cur.next}cur.next 以及所有后面拥有相同元素值的链表节点全部删除。我们记下这个元素值 xx，随后不断将 \textit{cur.next}cur.next 从链表中移除，直到 \textit{cur.next}cur.next 为空节点或者其元素值不等于 xx 为止。此时，我们将链表中所有元素值为 xx 的节点全部删除。
     *
     * 如果当前 \textit{cur.next}cur.next 与 \textit{cur.next.next}cur.next.next 对应的元素不相同，那么说明链表中只有一个元素值为 \textit{cur.next}cur.next 的节点，那么我们就可以将 \textit{cur}cur 指向 \textit{cur.next}cur.next。
     *
     * 当遍历完整个链表之后，我们返回链表的的哑节点的下一个节点 \textit{dummy.next}dummy.next 即可。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;//复制的节点，操作cur相当于操作dummy
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;//更新节点，
                }
            } else {
                cur = cur.next;//将cur.next地址交由cur
            }
        }

        return dummy.next;
    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
