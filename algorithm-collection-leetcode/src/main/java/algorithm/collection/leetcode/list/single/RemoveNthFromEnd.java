package algorithm.collection.leetcode.list.single;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.list.AddTwoNumbers;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author shadow
 * @create 2023-06-14 07:54
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "19",
        questionTitle = "删除链表的倒数第 N 个结点",
        relevateClass = AddTwoNumbers.class,
        desc = "给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。",
        questionLink = "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class RemoveNthFromEnd {


    @MethodTag(
            questionNumber = "19",
            methodLink = "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用哑节点，若头结点被删除，则不会为空
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //拿到删除节点的前节点
        ListNode pre = dummy;
        //使用快慢指针,能找到倒数的第n个节点
        ListNode slow = head;
        ListNode fast = head;
        //若要找到倒数第n个节点，那么需要慢指针指向null，快指针离慢指针n个节点
        //1  ->  2  ->  3  ->  4  ->  5  ->  null
        //                    slow           fast （此情况让fast找到了倒数第2个节点）
        //             slow                  fast  （此情况让fast找到了倒数第3个节点）
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        //删除节点为slow，相当于pre->slow->slow.next,此时删除slow
        pre.next = slow.next;
        return dummy.next;
    }

}
