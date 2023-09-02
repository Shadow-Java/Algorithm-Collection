package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * @author shadow
 * @create 2023-09-02 17:05
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "142",
        questionTitle = "环形链表 II",
        relevateClass = LinkedListCycle.class,
        desc = "给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。",
        questionLink = "https://leetcode.cn/problems/linked-list-cycle-ii/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class LinkedListCycleII {

    /**
     * <pre>
     *                                 d -> e(fast和slow第一次相遇点)
     *                              /        \
     *     head -> a -> b ->...-> c (入口)      f
     *                             \          /
     *                               m  ->   g
     *     假设head -> c距离为m，c到相遇点e距离为n,相遇点到c距离为h
     *     那么有：
     *     slow移动距离：m+n
     *     fast移动距离：m+n+k(n+h)
     *     环长：n+h
     *     fast移动距离 = 2*slow移动距离
     *     m-h = (k-1)(n+h) 意思是当fast和slow第一次相遇，head和slow再走h步，slow必会会到入口；但head到入口的距离为环长倍数，那么再继续走必会相遇
     * </pre>
     * @param head
     * @return
     */
    @MethodTag(
            questionNumber = "142",
            methodLink = "https://leetcode.cn/problems/linked-list-cycle-ii/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //fast和slow第一次相遇
            if(fast == slow){
                //相遇后，让head和slow继续走，相遇时必在入口处
                while (head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
