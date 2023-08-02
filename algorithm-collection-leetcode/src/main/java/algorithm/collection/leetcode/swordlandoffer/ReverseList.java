package algorithm.collection.leetcode.swordlandoffer;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.linklist.ListNodeRandomGenerator;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author shadow
 * @create 2023-07-23 14:07
 **/
@QuestionTag(
        questionNumber = "剑指 Offer 24",
        questionTitle = "反转链表",
        difficultyLeve = DifficultyLevel.EASY,
        questionLink = "https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/",
        algorithmCategory = AlgorithmCategory.VIOLENCE,
        timeComplexity = TimeComplexity.O_N
)
public class ReverseList {

    @MethodTag(
            questionNumber = "剑指 Offer 24",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.UNIVERSAL_LINKLIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public static ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        while (head != null){
            ListNode curNode = head;
            ListNode lastNode = pre.next;
            //注意这里的对象引用
            pre.next = new ListNode(curNode.val);
            pre.next.next = lastNode;
            head = head.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeRandomGenerator.generatorSingleList(5,10);
        ListNodeRandomGenerator.printSingleListNode(head);
        ListNode reverseList = reverseList(head);
        ListNodeRandomGenerator.printSingleListNode(reverseList);
    }

}
