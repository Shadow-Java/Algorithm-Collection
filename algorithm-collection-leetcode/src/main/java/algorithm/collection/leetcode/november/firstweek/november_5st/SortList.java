package algorithm.collection.leetcode.november.firstweek.november_5st;

import algorithm.collection.common.datastruct.linklist.ListNode;

/**
 * @author shadow
 * @create 2024-11-06 08:55
 **/
public class SortList {

    public ListNode sortList_v2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode left = sortList_v2(head);
        ListNode right = sortList_v2(mid);
        return merge(left, right);
    }
    // 迭代实现
    /**
     ListNode merge(ListNode left, ListNode right){
     ListNode alpha = new ListNode(0);
     ListNode ans = alpha;
     while(left!=null&&right!=null){
     if(left.val<right.val){
     ans.next = left;
     left = left.next;
     }else{
     ans.next = right;
     right = right.next;
     }
     ans = ans.next;
     }
     if(left==null)ans.next = right;
     else ans.next = left;
     return alpha.next;
     }
     */
    // 递归实现
    ListNode merge(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    ListNode findMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (fast.next != null) {
            if (fast.next.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode x = slow.next;
        slow.next = null;
        return x;
    }

// 迭代实现
/**
 ListNode merge(ListNode left, ListNode right){
 ListNode alpha = new ListNode(0);
 ListNode ans = alpha;
 while(left!=null&&right!=null){
 if(left.val<right.val){
 ans.next = left;
 left = left.next;
 }else{
 ans.next = right;
 right = right.next;
 }
 ans = ans.next;
 }
 if(left==null)ans.next = right;
 else ans.next = left;
 return alpha.next;
 }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}
