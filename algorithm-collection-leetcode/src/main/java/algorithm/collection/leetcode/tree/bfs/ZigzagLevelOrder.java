package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 * @author shadow
 * @create 2023-05-04 22:48
 **/
public class ZigzagLevelOrder {

    /**
     * 仍然是利用dfs搜索整棵树
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelValList = new ArrayList<>();
        if(root == null){
            return levelValList;
        }
        Deque<TreeNode> levelOrderQueue = new ArrayDeque<>();
        levelOrderQueue.add(root);
        boolean leftToRight = true;
        while(!levelOrderQueue.isEmpty()){
            int n = levelOrderQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                TreeNode treeNode = levelOrderQueue.pop();
                list.add(treeNode.getVal());
                if(treeNode.getLeft() != null){
                    levelOrderQueue.add(treeNode.getLeft());
                }
                if(treeNode.getRight() != null){
                    levelOrderQueue.add(treeNode.getRight());
                }
            }
            if(!leftToRight){
                Collections.reverse(list);
            }
            leftToRight = !leftToRight;
            levelValList.add(list);
        }
        return levelValList;
    }

}
