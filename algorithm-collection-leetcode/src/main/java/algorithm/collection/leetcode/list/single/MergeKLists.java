package algorithm.collection.leetcode.list.single;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.list.AddTwoNumbers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 输入：lists = []
 * 输出：[]
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author shadow
 * @create 2023-06-14 22:27
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "23",
        questionTitle = "合并 K 个升序链表",
        relevateClass = AddTwoNumbers.class,
        desc = "给你一个链表数组，每个链表都已经按升序排列。",
        questionLink = "https://leetcode.cn/problems/merge-k-sorted-lists/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MergeKLists {

    /**
     * K 个指针分别指向 K 条链表<br/>
     * 每次O(K) 比较 K个指针求 min, 时间复杂度：O(NK)
     * @param lists
     * @return
     */
    @MethodTag(
            questionNumber = "23",
            methodLink = "https://leetcode.cn/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public ListNode mergeKLists(ListNode[] lists) {
        //使用k个指针
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }


    /**
     * 使用小根堆对 1 进行优化,每次O(logK)比较K个指针求mini，时间复杂度O(nlogK)
     * @param lists
     * @return
     */
    @MethodTag(
            questionNumber = "23",
            methodLink = "https://leetcode.cn/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.HEAP,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public ListNode mergeKListsAnotherWay(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        //组成一个小顶堆
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        //合并的结点的哑节点
        ListNode dummyHead = new ListNode(0);
        //合并后的队尾
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            //堆顶出队
            ListNode minNode = pq.poll();
            //拿到最小值节点
            tail = tail.next = minNode;
            if (minNode.next != null) {
                //最小值节点的下一个节点入队
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }

}
