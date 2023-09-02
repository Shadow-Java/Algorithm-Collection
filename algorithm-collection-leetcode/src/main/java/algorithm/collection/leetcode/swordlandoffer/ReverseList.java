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
            //记一下当前节点的地址
            ListNode curNode = head;
            ListNode lastNode = pre.next;
            //注意这里的对象引用
            pre.next = new ListNode(curNode.val);
            pre.next.next = lastNode;
            //head节点的地址变化不会影响curNode.val的变化
            head = head.next;
        }
        return pre.next;
    }


    /**
     * <pre>
     *     双指针pre和cur，pre指向上一个节点，cur是当前节点，每次将cur.next = pre;
     *     例子： 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *          cur                       pre
     *
     * </pre>
     * <pre>
     *     MyClass obj1 = new MyClass();
     *     obj1.value = 5;
     *     MyClass obj2 = obj1; // 使用等号将obj1赋值给obj2
     *     obj2.value = 10;
     *     System.out.println(obj1.value); // 输出：10，因为obj1和obj2引用同一个对象
     *     System.out.println(obj2.value); // 输出：10
     *     cur.next = pre;          // 修改 next 引用指向
     *     pre = cur;               // pre 暂存 cur
     *     一种是修改内存地址的内容，一个是修改内存
     * </pre>
     *
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseListAnotherWay(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeRandomGenerator.generatorSingleList(5,10);
        ListNodeRandomGenerator.printSingleListNode(head);
        ListNode reverseList = reverseList(head);
        ListNodeRandomGenerator.printSingleListNode(reverseList);
    }

}
