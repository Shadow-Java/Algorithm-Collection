package algorithm.collection.leetcode.november.firstweek.november_3st;

import algorithm.collection.common.datastruct.linklist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shadow
 * @create 2024-11-03 20:12
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        //head.next.next.next = new ListNode(1);
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while(slow != null && fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null && !stack.isEmpty()) {
            Integer peek = stack.pop();
            if(!peek.equals(slow.val)) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
