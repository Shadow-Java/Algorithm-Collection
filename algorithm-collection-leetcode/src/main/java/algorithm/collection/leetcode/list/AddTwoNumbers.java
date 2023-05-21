package algorithm.collection.leetcode.list;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.linklist.ListNodeRandomGenerator;

/**
 * 2. 两数相加
 * @author shadow
 * @create 2023-05-21 14:22
 **/
public class AddTwoNumbers {

    /**
     * 末尾相加，需要的进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 错误写法：ListNode head = tail = null;tail = tail -> next;<br/>
         * 这种写法即使tail一直更新，head也一直指向的是null;<br/>
         * ListNode head = tail = null;的意思是head = null且tail = null，而不是tail变化 head就会变化，指向的是不同的地址空间
         *
         * 区别：
         * Node newNode = new Node(data);
         * Node current = head;（加个引用，即指向new Node(data)，而不是指向newNode）
         * newNode和current指向相同的地址空间，current变化，而newNode仍然指向new Node(data)
         *
         */
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNodeRandomGenerator.generatorSingleList(5,10);
        ListNode head2 = ListNodeRandomGenerator.generatorSingleList(4,10);
        ListNodeRandomGenerator.printSingleListNode(head1);
        ListNodeRandomGenerator.printSingleListNode(head2);
        addTwoNumbers(head1,head2);
    }

}
