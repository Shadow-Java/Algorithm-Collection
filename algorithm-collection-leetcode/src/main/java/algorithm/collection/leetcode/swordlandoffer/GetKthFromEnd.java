package algorithm.collection.leetcode.swordlandoffer;
import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
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

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    public static ListNode revertList(ListNode head){
        //TODO modify this method
        ListNode lastNode = null;
        ListNode pre = head;
        //指向的是对象内存地址
        while (head != null){
            pre.next = lastNode;
            lastNode = head;
            head = head.next;
            pre = head;
        }
        return pre;
    }

}
