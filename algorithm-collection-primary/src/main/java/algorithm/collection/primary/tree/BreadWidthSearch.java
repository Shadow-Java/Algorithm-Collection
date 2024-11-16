package algorithm.collection.primary.tree;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 添加宽度优先搜索模版方法
 *
 * 1、翻转层序遍历：Collections.reverse(list);
 *
 * @author shadow
 * @create 2023-05-07 15:42
 **/
public class BreadWidthSearch {

    public static void bfs(TreeNode root) {
        if (root == null) {
            System.out.println("--------------------------二叉树为空，请重新输入--------------------------");
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!nodeDeque.isEmpty()) {
            int n = nodeDeque.size();//每一层的节点数
            List<Integer> levelNodeVals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = nodeDeque.pop();
                levelNodeVals.add(curNode.getVal());
                if (curNode.getLeft() != null) {
                    nodeDeque.add(curNode.getLeft());
                }
                if (curNode.getRight() != null) {
                    nodeDeque.add(curNode.getRight());
                }
            }
            list.add(levelNodeVals);
        }
        System.out.println(list);
    }

}
