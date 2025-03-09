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
 *
 * 假设你有一串珠子，每颗珠子代表链表中的一个节点，每颗珠子之间用一根线（指针）相连。现在我们需要做的是：
 *
 *  解开当前珠子与下一颗珠子之间的线。
 *  把当前珠子重新连接到前一颗珠子的头结点上。
 *  移动到下一颗珠子重复上述步骤，直到所有的珠子都反向连接
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
        ListNode pre = new ListNode();//记录上一个链条
        while (head != null) {
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

    public ListNode reverseListV3(ListNode head) {
        ListNode pre = null;//上一个链表是空
        ListNode next = null;//起到临时存储的作用，head是下一个链表
        while(head != null) {
            next = head.next;//先提前存储下一个节点
            head.next = pre;//断开下一个节点，并将当前节点放到上一个链条的头节点上
            pre = head;//更新上一个链条的头结点
            head = next;//更新下一个节点的头结点
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeRandomGenerator.generatorSingleList(5,10);
        ListNodeRandomGenerator.printSingleListNode(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;
        //之前总是会判断失误，是因为两个指针指向的是实体，而不是逻辑地址；一旦一个指针修改后。另一个指针也会被修改的
        System.out.println(dummy.next.val == head.val);
        //ListNode reverseList = reverseList(head);
        //ListNodeRandomGenerator.printSingleListNode(reverseList);
    }

}
