package algorithm.collection.leetcode.swordlandoffer;
import algorithm.collection.common.datastruct.linklist.LinkListRandomGenerator;
import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * @author shadow
 * @create 2023-08-31 22:17
 **/
@QuestionTag(
        questionNumber = "剑指 Offer 22",
        questionTitle = "链表中倒数第k个节点",
        difficultyLeve = DifficultyLevel.EASY,
        relevateClass = ReverseList.class,
        questionLink = "https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/",
        algorithmCategory = AlgorithmCategory.VIOLENCE,
        timeComplexity = TimeComplexity.O_N
)
public class GetKthFromEnd {

    /**
     * 解法:
     * ①使用反转链表，然后按顺序计数
     * ②双指针：慢指针和快指针都指向头结点，先将快指针走K步，然后慢指针和快指针再同时走，当快指针到达null时，即慢指针达到倒数第k个节点；
     * 原理：到null的链表长度假设为n，要求倒数第k个节点，那么需要慢节点走N-K步，即快指针先走k步，后面快指针就能走N-K步
     * @param head
     * @param k
     * @return
     */
    @MethodTag(
            questionNumber = "剑指 Offer 22",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.UNIVERSAL_LINKLIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode revertList(ListNode head){
        ListNode pre = new ListNode();
        ListNode dummyNode = pre;
        while (head != null){
            //将实际存在的节点地址记录一下，后续会更改
            ListNode curNode = head;
            ListNode lastNode = pre;
            ListNode reverNode = new ListNode(curNode.val);
            reverNode.next = pre;
            head = head.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = LinkListRandomGenerator.of(nums);
        ListNode pre = revertList(head);
        System.out.println(pre);
    }

}
