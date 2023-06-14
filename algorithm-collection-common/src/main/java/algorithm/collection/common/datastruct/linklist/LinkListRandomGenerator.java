package algorithm.collection.common.datastruct.linklist;


/**
 * @author shadow
 * @create 2023-06-14 21:38
 **/
public class LinkListRandomGenerator {

    public static ListNode of(int[] array) {
        ListNode head = new ListNode();
        ListNode pre = head;
        ListNode last = head;
        for (int x : array) {
            pre.val = x;
            last = pre;
            pre = pre.next = new ListNode();
        }
        last.next = null;
        return head;
    }

    public static void printLinkListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 7, 8, 1};
        ListNode head = of(nums);
        printLinkListNode(head);
    }

}
