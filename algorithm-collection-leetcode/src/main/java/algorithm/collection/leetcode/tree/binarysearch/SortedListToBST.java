package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.linklist.ListNode;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.List;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 *
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 *
 * 输入: head = []
 * 输出: []
 *
 * @author shadow
 * @create 2023-10-08 21:21
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "109",
        questionTitle = "有序链表转换二叉搜索树",
        relevateClass = SortedArrayToBST.class,
        desc = "给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。",
        questionLink = "https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        return buildBalanceBST(head);
    }

    /**
     * 1.利用链表二分法插入节点（利用快慢指针，拿到中间节点）
     * 2.将链表节点存入数组中，利用数组的节点值二分（简单）
     * 3.中序遍历策略带来的优化(较难理解)
     * @param head
     * @return
     */
    public TreeNode buildBalanceBST(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBalanceBST(head);
        root.right = buildBalanceBST(mid.next);
        return root;
    }


    ListNode cur = null;

    /**
     * 方法1每次获取数组中点：O(1)O(1)O(1)，方法2每次获取链表中点：O(N)O(N)O(N)，所以更慢。
     *
     * 其实直接获取链表头结点：O(1)O(1)O(1)，不如直接构建它吧！它对应 BST 最左子树的根节点。
     *
     * 于是我们先构建左子树，再构建根节点，再构建右子树。——遵循中序遍历。
     *
     * 其实，BST 的中序遍历，打印的节点值正是这个有序链表的节点值顺序。
     *
     * 如下图，维护指针 h，从头结点开始，用 h.val 构建节点，构建一个，指针后移一位。
     *
     *
     *
     * @param head
     * @return
     */
    @MethodTag(
            questionNumber = "109",
            methodLink = "https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/solutions/378753/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.BALANCE_BINARY_SEARCH_TREE,
            algorithmCategory = AlgorithmCategory.RECURSION
    )
    public TreeNode sortedListToBSTByThird(ListNode head) {
        if (head == null) return null;
        int len = 0;
        cur = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        return sortedListToBST(0, len - 1);
    }
    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo >> 1);
        TreeNode left = sortedListToBST(lo, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next;
        root.right = sortedListToBST(mid + 1, hi);
        return root;
    }

}
