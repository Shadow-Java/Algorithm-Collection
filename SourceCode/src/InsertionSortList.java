package SourceCode.src;

/*
* 对链表进行插入排序。
* 插入排序算法：

* 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
* 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
* 重复直到所有输入数据插入完为止。
* 输入: 4->2->1->3
* 输出: 1->2->3->4
 */
public class InsertionSortList {
    /**
     * 对于链表而言，插入元素时只要更新相邻节点的指针即可，不需要像数组一样将插入位置后面的元素往后移动，因此插入操作的时间复杂度是 O(1)，但是找到插入位置需要遍历链表中的节点，时间复杂度是 O(n)，因此链表插入排序的总时间复杂度仍然是 O(n^2)
     * 该算法是将一个待排序的链表插入到已排序的链表里，对每一个节点查找已排序的链表是O（n）,如果用二分查找是O（log（n）），n个节点则是O(N^2)或O(N(log(n)))
     * 2
     *  )，其中 nn 是链表的长度。
     *
     * @param head
     * @return
     */

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummyHead = new ListNode(0); // 定一个虚拟头结点
        ListNode cur = head;//待插入节点
        ListNode pre = dummyHead;//带插入节点的前一个节点

        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {//遍历已经插入的节点，找到带插入的位置O(N)
                pre = pre.next;
            }
            // 在pre和prenext之间插入数据
            ListNode next = cur.next; // 步骤一：保存curnext
            cur.next = pre.next;      // 步骤二
            pre.next = cur;            // 步骤三
            pre = dummyHead;            // 步骤四：pre重新指向虚拟头结点来找下一个插入位置
            cur = next;                 // 步骤五：cur的前一个节点的下一个节点指向保存的next
        }
        return dummyHead.next;

    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


