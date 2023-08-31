package algorithm.collection.leetcode.list;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.doublepointer.NextGreaterElementIII;

/**
 * @author shadow
 * @create 2023-08-31 21:50
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "876",
        questionTitle = "给你单链表的头结点 head ，请你找出并返回链表的中间结点。",
        relevateClass = NextGreaterElementIII.class,
        desc = "如果有两个中间结点，则返回第二个中间结点。",
        questionLink = "https://leetcode.cn/problems/middle-of-the-linked-list/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MiddleTheLinkedList {


    @MethodTag(
            questionNumber = "876",
            methodLink = "https://leetcode.cn/problems/middle-of-the-linked-list/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null && fast != null && fast.next != null){
            slow = slow.next;
            fast =  fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int val : nums){
            head.next = new ListNode(val);
            head = head.next;
        }
        System.out.println(middleNode(pre));
    }

}
