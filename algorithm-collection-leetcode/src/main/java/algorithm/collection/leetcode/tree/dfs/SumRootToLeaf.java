package algorithm.collection.leetcode.tree.dfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.leetcode.tree.binarysearch.SerializeDeserializeBST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 *
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * @author shadow
 * @create 2023-09-16 14:02
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1022",
        questionTitle = "从根到叶的二进制数之和",
        relevateClass = SerializeDeserializeBST.class,
        desc = "给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。",
        questionLink = "https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.BINARY_SEARCH_TREE}
)
public class SumRootToLeaf {

    @MethodTag(
            questionNumber = "1022",
            methodLink = "https://leetcode.cn/problems/root-equals-sum-of-children/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 1.先序遍历可以被认为是一种特殊的DFS算法，它是DFS的一种具体实现方式。
     * 2.计算bit的整数的方式：int res = (res << 1) + val(bit 位)，如111=4+2+1=7
     * @param root
     * @param cur
     * @return
     */
    int dfs(TreeNode root, int cur) {
        int ans = 0;
        int ncur = (cur << 1) + root.val;
        if (root.left != null) {
            ans += dfs(root.left, ncur);
        }
        if (root.right != null) {
            ans += dfs(root.right, ncur);
        }
        //如果是叶子节点，则返回路径整数
        return root.left == null && root.right == null ? ncur : ans;
    }

    /**
     * 思路：从头结点向下遍历时，提前将子节点的值相加，比如
     *              1
     *            /  \
     *          0     1
     *         / \   / \
     *        1   0 1   1
     * dfs遍历节点1时，将子节点值改为左节点10，右节点11，然后到了叶子节点则相加，这样不用记遍历路径
     * @param root
     * @return
     */
    public int sumRootToLeafAnotherWay(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            if (poll.left != null) {
                poll.left.val = (poll.val << 1) + poll.left.val;
                d.addLast(poll.left);
            }
            if (poll.right != null) {
                poll.right.val = (poll.val << 1) + poll.right.val;
                d.addLast(poll.right);
            }
            if (poll.left == null && poll.right == null) ans += poll.val;
        }
        return ans;
    }



    public int anotherWay(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        List<TreeNode> deepNodeList = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            deepNodeList.add(curNode);
            //叶子节点
            if(curNode.right == null && curNode.left == null){
                res = res+genNumber(deepNodeList);
                deepNodeList.remove(curNode);
            }
            if(curNode.right != null){
                stack.push(curNode.right);
            }
            if(curNode.left != null){
                stack.push(curNode.left);
            }
        }
        return res;
    }

    public static int genNumber(List<TreeNode> deepNodeList){
        if(deepNodeList == null || deepNodeList.isEmpty()){
            return 0;
        }
        double res = 0;
        int length = deepNodeList.size();
        for (int i=0;i < length;i++){
            res = res + deepNodeList.get(i).val * Math.pow(2,length-i-1);
        }
        return (int) res;
    }


    public static void main(String[] args) {
        /**
         * dfs的问题在于回溯的时候，会没有回退完全
         *              8
         *            /  \
         *          3     5
         *         / \   / \
         *        6   7 9   4
         *对于这棵树的dfs的遍历路径是8，3，6，7，5，9，4，那么遍历到7时，路径上会记录8，3，7；但是从7遍历到5时，需要回退路径上记录的节点3，但是又回退不了，故会有问题；
         * 那么有一种解决方式就是记录节点的父节点，比如我遍历节点7时，我同时记录父节点3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
    }



}
