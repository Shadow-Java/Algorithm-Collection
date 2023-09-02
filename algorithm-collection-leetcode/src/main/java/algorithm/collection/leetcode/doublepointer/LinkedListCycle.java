package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * @author shadow
 * @create 2023-08-31 00:01
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "141",
        questionTitle = "环形链表",
        relevateClass = NextGreaterElementIII.class,
        desc = "给你一个链表的头节点 head ，判断链表中是否有环。",
        questionLink = "https://leetcode.cn/problems/linked-list-cycle/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class LinkedListCycle {

    /**
     * 原理：如果存在环，那么快慢指针中终会相遇
     * ①是否存在环
     * ②求环的长度：在环的基础上，继续走K步，当第二次相遇时，即慢指针走的步数为环的长度
     * ③
     * 假设快指针和慢指针在环中的起始位置相差k个距离（即快指针比慢指针先进入环k个节点）。在这种情况下，它们将在慢指针继续移动k步后相遇。
     * 当慢指针进入环后，快指针与慢指针之间的距离为k个节点。由于快指针每次移动两步，而慢指针每次移动一步，所以在每次移动后，快指针与慢指针之间的距离都会减少1个节点。
     * @param head
     * @return
     */
    @MethodTag(
            questionNumber = "141",
            methodLink = "https://leetcode.cn/problems/linked-list-cycle/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }


    /**
     * 统计环的长度：当fast和slow从第一次相遇后，开始计数，第二次相遇走的步数即为环长
     * @param head
     * @return
     */
    public static int countCycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        int count = 0;//相遇次数
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count = slow == fast ? ++count : count;
            if (count == 2) {
                ++cycleLength;
            }
            if(count == 3){
                return cycleLength;
            }
        }
        return cycleLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,4};
        ListNode head = new ListNode(3);
        ListNode pre = head;
        //相遇的索引值
        ListNode posNode = new ListNode();
        for (int val : nums){
            head.next = new ListNode(val);
            if(val == 2){
                posNode = head.next;
            }
            head = head.next;
        }
        head.next = posNode;

        System.out.println(countCycleLength(pre));
    }

}
