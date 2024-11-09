package algorithm.collection.leetcode.november.firstweek.november_8st;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * @author shadow
 * @create 2024-11-08 22:34
 **/
public class KthSmallest {

    /**
     * 为什么要设置为全局的，因为int变量是引用传递
     * Integer 是一个不可变（immutable）类。这意味着一旦创建了一个 Integer 对象，它的值就不能被改变。因此，当你在方法中传递一个 Integer 参数时，任何试图修改它的值的操作都不会影响原始对象
     */
    private int ans = -1;
    private List<Integer> res = new ArrayList<>();

    /**
     * 利用中序遍历是从小到大排序的特点
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_V2(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }

    public void dfs(TreeNode root,int k) {
        if(root == null) {
            return;
        }
        dfs(root.left,k);
        res.add(root.val);
        if(res.size() == k) {
            ans = root.val;
        }
        dfs(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        dfs(root,minHeap);
        while (k > 1) {
            minHeap.poll();
            k--;
        }
        return minHeap.isEmpty() ? -1 : minHeap.poll().val;
    }

    public void dfs(TreeNode root,PriorityQueue<TreeNode> minHeap) {
        if(root == null) {
            return;
        }
        minHeap.add(root);
        dfs(root.left,minHeap);
        dfs(root.right,minHeap);
    }

}
